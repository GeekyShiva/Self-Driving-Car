# Testing strategy for Embedded System

## 1. Unit Testing

### 1.1 Arduino

| Function | Pins | Description |
|----------|------|-------------|
| initSpeedPins() | A0, A1, A2, 11, 10, 9 | Verify correct initialization of speed pins. |
| readSpeedInput() | A0, A1, A2 | Test correct reading of speed data from Raspberry Pi. |
| writeSpeedData() | 11, 10, 9 | Drive the rear motors in both the possible directions, at all possible speeds. |
| initTurnPins() | A3, A4, A5, 6, 5, 4 | Verify correct initialization of turn pins. |
| readTurnInput() | A3, A4, A5 | Test correct reading of turn data from Raspberry Pi. |
| writeTurnData() | 6, 5, 4 | Drive the front motors in both the possible directions, at all possible speeds. |
| Test VIN | VIN | Test optimal power input into Arduio's VIN pin from Raspberry Pi. |

### 1.2 Raspberry Pi

| Function | Pins | Description |
|----------|------|-------------|
| init() | 33, 35, 36, 37, 38, 40 | Verify correct initialization of all required GPIO pins. |
| setTurn() | 33, 35, 37 | Check correct transmission of turn data from Raspberry Pi to Arduino. |
| setSpeed() | 36, 38, 40 | Check correct transmission of speed data from Raspberry Pi to Arduino. |

## 2. Integration Testing

### 2.1 Combination of Arduino and motors

* __Description:__ This test was run to ensure proper communication between Arduino and motor driver IC.
* __Errors Found:__ No errors or failures were collected.

### 2.2 Combination of Arduino and Raspberry Pi

* __Description:__ This test was run to ensure proper communication between Arduino and Raspberry Pi.
* __Errors Found:__ Wrong pin diagrams were used which led to incorrect connections.

## 3. System Testing

### 3.1 Turn car left

* __Description:__ This test was run to ensure correct dataflow from Raspberry Pi to motor driver IC, via Arduino, to turn the car left.
* __Errors Found:__ No errors or failures were collected.

### 3.1 Turn car right

* __Description:__ This test was run to ensure correct dataflow from Raspberry Pi to motor driver IC, via Arduino, to turn the car right.
* __Errors Found:__ No errors or failures were collected.

### 3.1 Move car forward

* __Description:__ This test was run to ensure correct dataflow from Raspberry Pi to motor driver IC, via Arduino, to move the car forward.
* __Errors Found:__ No errors or failures were collected.

### 3.1 Move car backward

* __Description:__ This test was run to ensure correct dataflow from Raspberry Pi to motor driver IC, via Arduino, to move the car backward.
* __Errors Found:__ No errors or failures were collected.
