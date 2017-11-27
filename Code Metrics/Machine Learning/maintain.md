<div align=center>
  <h1>Code Metrices</h1>
  <h2>Project Volantè</h2>
  <b> Self Driving Car </b><br />
  <b> Version <i>1.0</i></b><br />
  <b> Code Maintainability Index </b><br />
</div><br /><br />

# Code Maintainability Index

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

### Maintainability Index

Maintainability Index is a software metric which measures how maintainable (easy to support and change) the source code is. The maintainability index is calculated as a factored formula consisting of SLOC (Source Lines Of Code), Cyclomatic Complexity and Halstead volume. It is used in several automated software metric tools, including the Microsoft Visual Studio 2010 development environment, which uses a shifted scale (0 to 100) derivative.

Common formulas are:

- Origin Formula 
```
  MI=171−5.2lnV−0.23G−16.2lnL  
```
- Derivative used by SEI
```
MI=171−5.2log2V−0.23G−16.2log2L+50sin(√2.4C)
```
- Derivative used by Visual Studio
```
MI=max[0,100(171−5.2lnV−0.23G−16.2lnL)/171]
```

Radon uses another derivative, computed from both SEI derivative and Visual Studio one:

```
MI=max[0,100(171−5.2lnV−0.23G−16.2lnL+50sin(√2.4C))/171]
```

Where:

- V is the Halstead Volume (see below)
- G is the total Cyclomatic Complexity
- L is the number of Source Lines of Code (SLOC)
- C is the percent of comment lines (important: converted to radians).

## Legend

| MI score | Rank |	Maintainability |
| --- | --- | --- |
| 100 - 20 | A | Very high |
| 19 - 10 |	B |	Medium |
| 9 - 0 | C | Extremely low |

| Block type | Letter |
| --- | --- |
| Function | F |
| Method | M |
| Class | C |

## Measurement and Results:

### File: Machine Learning/driver.py

```
driver.py - A (100.0)
```
### File: Machine Learning/gcp_functions.py

```
gcp_functions - A (100.0)
```



