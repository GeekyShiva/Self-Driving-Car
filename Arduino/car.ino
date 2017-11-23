#include <NewPing.h>

// Pins for ultrasonic sensors (HC-SR04).
#define FRONT_US 9
#define LEFT_US  8
#define RIGHT_US 7

// Baud rate for UART
#define BAUD_RATE 9600

// Pins for external speed control input.
#define SPEED_INPUT2 A0
#define SPEED_INPUT1 A1
#define SPEED_INPUT0 A2

// Pins for controlling the acceleration motors.
#define SPEED_MOTOR_PIN1 11
#define SPEED_MOTOR_PIN0 10

// Pins for external turn control input.
#define TURN_INPUT2 A3
#define TURN_INPUT1 A4
#define TURN_INPUT0 A5

// Pins for controlling the turn motors.
#define TURN_MOTOR_PIN1 6
#define TURN_MOTOR_PIN0 5

// Number of distance sensors.
#define NUM_SENSORS 3

// Constants defining direction of motion.
#define MOVE_FORWARD  0
#define MOVE_BACKWARD 1

// Constants defining direction of turn.
#define TURN_LEFT  1
#define TURN_RIGHT 0


// FUNCTION DECLARATIONS
void echoCheck();
void writeDistanceData();
void initSpeedPins();
unsigned int readSpeedInput();
void writeSpeedData(unsigned int direction, unsigned int percent);
void initTurnPins();
unsigned int readTurnInput();
void writeTurnData(unsigned int direction, unsigned int percent);


NewPing sonar[NUM_SENSORS] = {{FRONT_US, FRONT_US, 200},   // sonar[0] => front sensor
                              {LEFT_US,  LEFT_US,  200},   // sonar[1] => left  sensor
                              {RIGHT_US, RIGHT_US, 200}};  // sonar[2] => right sensor
unsigned int pingSpeed = 50;      // Time (in milliseconds) between every distance sensor ping.
unsigned long pingTimer;          // Holds the next ping time (in milliseconds).
unsigned long data[NUM_SENSORS];  // Holds the ping sensor data (in cm).
unsigned int currentSensor;       // Indicates the sensor to collect data from


/**
 * Sets up I/O pins.
 * Sets up UART for communication with Raspberry Pi.
 * Initializes global variables.
 * Initializes Timer2 for ultrasonic sensor data recording.
 * 
 * Input: None
 * Output: None
 */
void setup() {
  initSpeedPins();
  initTurnPins();
  Serial.begin(BAUD_RATE);  // UART setup
  
  for (int i = 0; i < NUM_SENSORS; ++i) {
    data[i] = 0;
  }

  pingTimer = millis();  // Start ultrasonic sensor timer.
}

/**
 * This is the main thread of execution of the system. It does the following:
 * 
 *   1. Update distance sensor timer data for Timer2 and read distance data.
 *   2. Read data for and configure speed control motors.
 *   3. Read data for and configure turn control motors.
 * 
 * in a continuous loop.
 * 
 * Input: None
 * Output: None
 */
void loop() {
  // update distance data output
  if (millis() >= pingTimer) {    // pingSpeed milliseconds since last ping, do another ping.
    pingTimer += pingSpeed;       // Set the next ping time.

    // query each sensor sequentially
    for (currentSensor = 0; currentSensor < NUM_SENSORS; ++currentSensor) {
      sonar[currentSensor].ping_timer(echoCheck);
    }

    writeDistanceData();  // update UART output
  }

  // update speed motor output
  unsigned int speedInput = readSpeedInput();
  unsigned int speedPercent = 0;
  switch (speedInput & 0x03) {
    case 1: speedPercent = 33;  break;
    case 2: speedPercent = 67;  break;
    case 3: speedPercent = 100; break;
  }
  writeSpeedData(speedInput >> 2, speedPercent);

  // update turn motor output
  unsigned int turnInput = readTurnInput();
  unsigned int turnPercent = 0;
  switch (turnInput & 0x03) {
    case 1: turnPercent = 33;  break;
    case 2: turnPercent = 67;  break;
    case 3: turnPercent = 100; break;
  }
  writeTurnData(turnInput >> 2, turnPercent);
}

/**
 * Timer2 ISR to read distance data from sensor "currentSensor" into
 * data[currentSensor].
 * 
 * Input: None
 * Output: None
 */
void echoCheck() {
  if (sonar[currentSensor].check_timer()) {  // Check if the ping was received.
    // collect the data from the sensor
    data[currentSensor] = sonar[currentSensor].ping_result / US_ROUNDTRIP_CM;
  }
}

/**
 * Writes the distance data into the UART, in the following order
 * 
 * data[0]'\r\n'
 * data[1]'\r\n'
 * data[2]'\r\n'
 * ...
 * data[NUM_SENSORS - 1]'\r\n'
 * 
 * Input: None
 * Output: None
 */
void writeDistanceData() {
  for (int i = 0; i < NUM_SENSORS; ++i) {
    Serial.println(data[i]);
  }
}

/**
 * Initializes pins for speed control I/O.
 * 
 * Input: None
 * Output: None
 */
void initSpeedPins() {
  pinMode(SPEED_INPUT2, INPUT);
  pinMode(SPEED_INPUT1, INPUT);
  pinMode(SPEED_INPUT0, INPUT);
  pinMode(SPEED_MOTOR_PIN1, OUTPUT);
  pinMode(SPEED_MOTOR_PIN0, OUTPUT);
}

/**
 * Reads and returns speed control data, which is in the range [0,3].
 * 
 * Data in [0,3] signifies forward motion, with each higher number signifying
 * higher speed.
 * 
 * Data in [4,7] signifies backward motion, with each higher number signifying
 * higher speed.
 * 
 * Requires the following pins to be set to INPUT mode:
 *   SPEED_INPUT2
 *   SPEED_INPUT1
 *   SPEED_INPUT0
 * 
 * Input: None
 * Output: Speed data in the range [0,7]
 */
unsigned int readSpeedInput() {
  // read bit 2
  unsigned int data = (digitalRead(SPEED_INPUT2) == HIGH) ? (4) : (0);
  
  // read bit 1
  data += (digitalRead(SPEED_INPUT1) == HIGH) ? (2) : (0);
  
  // read bit 0
  data += (digitalRead(SPEED_INPUT0) == HIGH) ? (1) : (0);
  
  return data;
}

/**
 * Configure the speed control motors to run at 'percent' percentage of their
 * capacity. Consequently,
 * 
 *   1. direction must be either MOVE_FORWARD or MOVE_BACKWARD
 *   2. 0 <= percent <= 100.
 * 
 * Requires the following pins to be not set to INPUT mode:
 *   SPEED_MOTOR_PIN1
 *   SPEED_MOTOR_PIN0
 * 
 * Input: direction : Direction of the car's motion
 *        percent :   Speed of the car in percentage terms.
 * Output: None
 */
void writeSpeedData(unsigned int direction, unsigned int percent) {
  switch (direction) {
    case MOVE_FORWARD: analogWrite(SPEED_MOTOR_PIN1, percent * 2.55);
                       analogWrite(SPEED_MOTOR_PIN0, 0);
                       break;
    
    case MOVE_BACKWARD: analogWrite(SPEED_MOTOR_PIN1, 0);
                        analogWrite(SPEED_MOTOR_PIN0, percent * 2.55);
                        break;

    default: analogWrite(SPEED_MOTOR_PIN1, 0);
             analogWrite(SPEED_MOTOR_PIN0, 0);
  }
}

/**
 * Initializes pins for turn control I/O.
 * 
 * Input: None
 * Output: None
 */
void initTurnPins() {
  pinMode(TURN_INPUT2, INPUT);
  pinMode(TURN_INPUT1, INPUT);
  pinMode(TURN_INPUT0, INPUT);
  pinMode(TURN_MOTOR_PIN1, OUTPUT);
  pinMode(TURN_MOTOR_PIN0, OUTPUT);
}

/**
 * Reads and returns turn control data, which is in the range [0,7].
 * 
 * Data in [0,3] signifies right turn, with each higher number signifying
 * a higher degree of turn.
 * 
 * Data in [4,7] signifies left turn, with each higher number signifying
 * a higher degree of turn.
 * 
 * Requires the following pins to be set to INPUT mode:
 *   TURN_INPUT2
 *   TURN_INPUT1
 *   TURN_INPUT0
 * 
 * Input: None
 * Output: Turn data in the range [0,7].
 */
unsigned int readTurnInput() {
  // read bit 2
  unsigned int data = (digitalRead(TURN_INPUT2) == HIGH) ? (4) : (0);

  // read bit 1
  data += (digitalRead(TURN_INPUT1) == HIGH) ? (2) : (0);

  // read bit 0
  data += (digitalRead(TURN_INPUT0) == HIGH) ? (1) : (0);

  return data;
}

/**
 * Configures the turn motors to turn in 'percent' percentage in
 * 'direction' direction. Consequently,
 * 
 *   1. direction must be either TURN_LEFT or TURN_RIGHT
 *   2. 0 <= percent <= 100
 * 
 * Requires the following pins to be not set to INPUT mode:
 *   TURN_MOTOR_PIN1
 *   TURN_MOTOR_PIN0
 * 
 * Input: direction : Direction of the car's turn.
 *        percent   : Degree of the car's turn in percentage terms.
 * Output: None
 */
void writeTurnData(unsigned int direction, unsigned int percent) {
  switch (direction) {
    case TURN_LEFT: analogWrite(TURN_MOTOR_PIN1, percent * 2.55);
                    analogWrite(TURN_MOTOR_PIN0, 0);
                    break;
    
    case TURN_RIGHT: analogWrite(TURN_MOTOR_PIN1, 0);
                     analogWrite(TURN_MOTOR_PIN0, percent * 2.55);
                     break;

    default: analogWrite(TURN_MOTOR_PIN1, 0);
             analogWrite(TURN_MOTOR_PIN0, 0);
  }
}

