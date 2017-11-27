<div align=center>
  <h1>Code Metrices</h1>
  <h2>Project Volantè</h2>
  <b> Self Driving Car </b><br />
  <b> Version <i>1.0</i></b><br />
  <b> Raw Metrics </b><br />
</div><br /><br />


# Raw Metrices

## Programming Language and Interpreter:

- Python 
- Python 3.x

## Tools Used:

| Tool | About 
| --- | --- |
| PyCharm | Python IDE for Professional Developers with inbuilt metrics tools | 
| Radon 2.1.1 | Radon is a Python tool which computes various code metrics. Supported metrics are Raw, Cyclomatic, Halstead and Maintainability Index|
| Pylint | A Python source code analyzer which looks for programming errors, helps enforcing a coding standard and sniffs for some code smells  |
| Metrics Reloaded | Automated code metrics for IntelliJ IDEA and IntelliJ Platform IDEs. Lines of Code and file count metrics for all languages supported by your IDE |

## Measurement Parameters:

- LOC: the total number of lines of code
- LLOC: the number of logical lines of code
- SLOC: the number of source lines of code - not necessarily corresponding to the LLOC
- comments: the number of Python comment lines (i.e. only single-line comments #)
- multi: the number of lines representing multi-line strings
- blank: the number of blank lines (or whitespace-only ones)

The equation `SLOC + Multi + Single comments + Blank = LOC` should always hold. Additionally, comment stats are calculated:

- `C % L`: the ratio between number of comment lines and LOC, expressed as a percentage;
- `C % S`: the ratio between number of comment lines and SLOC, expressed as a percentage;
- `C + M % L`: the ratio between number of comment and multiline strings lines and LOC, expressed as a percentage.

## Measurement and Results:

### File: Machine Learning/driver.py
    LOC: 177
    LLOC: 89
    SLOC: 89
    Comments: 19
    Single comments: 20
    Multi: 2
    Blank: 66
    - Comment Stats
        (C % L): 11%
        (C % S): 21%
        (C + M % L): 12%
    
### File: Machine Learning/gcp_functions.py
    LOC: 687
    LLOC: 370
    SLOC: 409
    Comments: 83
    Single comments: 96
    Multi: 14
    Blank: 168
    - Comment Stats
        (C % L): 12%
        (C % S): 20%
        (C + M % L): 14%