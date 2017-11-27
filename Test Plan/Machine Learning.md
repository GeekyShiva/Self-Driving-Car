<div align=center>
  <h1>Code Metrices</h1>
  <h2>Project Volantè</h2>
  <b> Self Driving Car </b><br />
  <b> Version <i>1.0</i></b><br />
  <b> Machine Learning Test Plan </b><br />
</div><br /><br />

# Test Plan

## Tools:

* Nose2 Module
* Unittest Module

# WhiteBox Testing

## Unit Tests  

|TEST Function|Function|Result|
|---|----|----|
| android_data | Check and parse data from android | *PASSED* |
| road_detected | Detect and classify images| *PASSED* |
| detect_labels | label detections in ML| *PASSED* |
| detect_label_uri | remote detection| *PASSED* |
| image_data | parse image data and communicate with gcp| *PASSED* |

## Coverage Report

| Module Covered | Statements | Miss | Cover |
|---|---|---|---|
| **argparse** | 2390  |  95.6  |  94% |
| **io** | 100 | 12 | 88% |
| **vision** | source missing | source missing | source missing |
| **types** | 267 | 8 | 98% |
| **json** | 368 | 12 | 97% |
| **urllib** | 2740 | 374 | 87% |
| **sys** | source missing | source missing | source missing |
| **time** | source missing | source missing | source missing |

## Functional Testing


| Action | Desired Output | Actual Output | Result |
|---|---|---|---|
|Fetch `android_data` and parse | Fetching data and parsing in to Raspi function calls | *All tasks completed* | PASSED |
|Fetch data and perform `detection` function| Fetching the parsed data, analysing and return result | *All tasks completed* | PASSED |
|Call `API` and return `labels`| Invoke API call and return label value | *All tasks completed* | PASSED|
|Call `API` and return `labels` for `remote files` | Connect to database,Invoke API call and return label value |*All tasks completed*| PASSED |
|Parse `Image data` and invoke `label call`| Check image and connectivity, invoke function call | *All tasks completed* | PASSED |

## Conclusion 
* Code *PASSED* under restricted compatibility
* Lack of tolerence and Robustness present in code.
* Scalability of code is a plus.


## PS:

Some functions and API calls have not been tested due to Google's Proprietary Code under `Google Cloud API's`

