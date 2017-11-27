# Testing Strategy for Android App

## 1. Unit Testing
Tested with a required heading in all four quadrants. The required heading must not be 45, 135, 225 or 315 degrees, as they may lead to ambiguity.For required direction in a quadrant, tested with current heading in all four quadrants Tested the special cases of required heading of 0, 90, 180 or 270 degrees.

| Test Function| Description |Result | 
|----- |----- |----- |
|firstQuadrant0 |Tests currentHeading = 0 degree <br>requiredHeading = 60 degree | PASSED|
|firstQuadrant90 |Tests currentHeading = 90 degree <br>requiredHeading = 60 degree | PASSED|
|firstQuadrant180 |Tests currentHeading = 180 degree <br>requiredHeading = 60 degree | PASSED|
|firstQuadrant270 |Tests currentHeading = 270 degree <br>requiredHeading = 60 degree | PASSED|
|secondQuadrant0 |Tests currentHeading = 0 degree <br>requiredHeading = 150 degree | PASSED|
|secondQuadrant90 |Tests currentHeading = 90 degree <br>requiredHeading = 150 degree | PASSED|
|secondQuadrant180 |Tests currentHeading = 180 degree <br>requiredHeading = 150 degree | PASSED|
|secondQuadrant270 |Tests currentHeading = 270 degree <br>requiredHeading = 150 degree | PASSED|
|thirdQuadrant0 |Tests currentHeading = 0 degree <br>requiredHeading = 240 degree | PASSED|
|thirdQuadrant90 |Tests currentHeading = 90 degree <br>requiredHeading = 240 degree | PASSED|
|thirdQuadrant180 |Tests currentHeading = 180 degree <br>requiredHeading = 240 degree | PASSED|
|thirdQuadrant270 |Tests currentHeading = 270 degree <br>requiredHeading = 240 degree | PASSED|
|fourthQuadrant0 |Tests currentHeading = 0 degree <br>requiredHeading = 330 degree | PASSED|
|fourthQuadrant90 |Tests currentHeading = 90 degree <br>requiredHeading = 330 degree | PASSED|
|fourthQuadrant180 |Tests currentHeading = 180 degree <br>requiredHeading = 330 degree | PASSED|
|fourthQuadrant270 |Tests currentHeading = 270 degree <br>requiredHeading = 330 degree | PASSED|
| perfect0| Tests currentHeading = 310 degree<br> requiredHeading = 0 degree| PASSED|
| perfect90| Tests currentHeading = 270 degree<br> requiredHeading = 90 degree| PASSED|
| perfect0| Tests currentHeading = 246 degree<br> requiredHeading = 180 degree| PASSED|
| perfect0| Tests currentHeading = 45 degree<br> requiredHeading = 270 degree| PASSED|

## 2. Integration Testing

| Action| Desired Output |Actual Output |Result |
|----- | -----| ----|---- |---- |
|send image to GCP|sending image to GCP|All tasks completed | PASSED|
| send json to GCP|sending json to GCP |All tasks completed |PASSED | 


## Conclusion

* Code PASSED under restricted compatibility
* Lack of tolerence and Robustness present in code.
* Scalability of code is a plus.

## PS:

Some functions and API calls have not been tested due to Google's Proprietary Code under Google Cloud API's