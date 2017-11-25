import RPi.GPIO as GPIO
import serial

########################
# Constant declarations
########################
SPEED_DATA_PINS = [36, 38, 40]     # Pins used for speed data output
TURN_DATA_PINS  = [33, 35, 37]     # Pins used for turn data output
SERIAL_PORT_NAME = "/dev/ttyAMA0"  # Serial port used for distance data input (pins 14 and 15)
SERIAL_BAUD_RATE = 9600            # Baud rate for the serial port
SERIAL_DATA_SIZE = 60              # Size (in bytes) of distance data

TURN_LEFT  = True
TURN_RIGHT = not TURN_LEFT
MOVE_BACKWARD = True
MOVE_FORWARD  = not MOVE_BACKWARD

# global serial port variable
serial_port = serial.Serial(SERIAL_PORT_NAME)

def init():
    '''
    Initializes GPIO pins for
    
      speed    data output
      turn     data output
    
    Initializes serial port for

      distance data input

    The RPi.GPIO is used in BOARD mode.
    '''
    # use physical pin numbers
    GPIO.setmode(GPIO.BOARD)

    # set up output pins
    for pin in (SPEED_DATA_PINS + TURN_DATA_PINS):
        GPIO.setup(pin, GPIO.OUT)
    
    # set up serial port
    serial_port = serial.Serial(SERIAL_PORT_NAME)
    serial_port.baudrate = SERIAL_BAUD_RATE

def set_turn(direction, degree):
    '''
    This is used to set the direction and degree of turn. Requires

      direction in [TURN_LEFT, TURN_RIGHT]
      0 <= degree <= 3

    degree = 0 corresponds to no turn.
    degree = 3 corresponds to full turn.
    degree = [1,2] are intermediate values
    '''
    # set bit 2 of turn data
    if direction:
        GPIO.output(TURN_DATA_PINS[2], GPIO.HIGH)
    else:
        GPIO.output(TURN_DATA_PINS[2], GPIO.LOW)

    # set bit 1 of turn data
    if degree in [2,3]:
        GPIO.output(TURN_DATA_PINS[1], GPIO.HIGH)  
    else:
        GPIO.output(TURN_DATA_PINS[1], GPIO.LOW)

    # set bit 0 of turn data
    if degree in [1,3]:
        GPIO.output(TURN_DATA_PINS[0], GPIO.HIGH)
    else:
        GPIO.output(TURN_DATA_PINS[0], GPIO.LOW)

def set_speed(direction, speed):
    '''
    This is used to set the car's speed. Requires

      direction in [MOVE_FORWARD, MOVE_BACKWARD]
      0 <= speed <= 3

    speed = 0 corresponds to no speed.
    speed = 3 corresponds to full speed.
    speed = [1,2] are intermediate values
    '''
    # set bit 2 of speed data
    if direction:
        GPIO.output(SPEED_DATA_PINS[2], GPIO.HIGH)
    else:
        GPIO.output(SPEED_DATA_PINS[2], GPIO.LOW)
    
    # set bit 1 of speed data
    if speed in [2,3]:
        GPIO.output(SPEED_DATA_PINS[1], GPIO.HIGH)  
    else:
        GPIO.output(SPEED_DATA_PINS[1], GPIO.LOW)

    # set bit 0 of speed data
    if speed in [1,3]:
        GPIO.output(SPEED_DATA_PINS[0], GPIO.HIGH)
    else:
        GPIO.output(SPEED_DATA_PINS[0], GPIO.LOW)

def get_distance():
    '''
    Reads distance data from serial port.
    
    Requires serial_port to be initialized to the desired port name.
    
    Reads SERIAL_DATA_SIZE bytes, and returns the distance data as a list of ints.
    Requires serial data to be in the format:

      data[0]\r\n
      data[1]\r\n
      data[2]\r\n
    '''
    serial_data = str(serial_port.read(SERIAL_DATA_SIZE), 'utf-8')

    return [int(serial_data[0:3]), int(serial_data[5:8]), int(serial_data[10:13])]
