<div align=center>
  <h1>Code Metrices</h1>
  <h2>Project Volantè</h2>
  <b> Self Driving Car </b><br />
  <b> Version <i>1.0</i></b><br />
  <b> Machine Learning Code Metrics </b><br />
</div><br /><br />

# Code Metrices

## Contents:

- Raw Metrics
- Cyclomatic Complexity
- Maintainability Index
- Code Quality ([PEP8](https://www.python.org/dev/peps/pep-0008/) and Code Analysis)

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

### Raw Metrics


- LOC: the total number of lines of code
- LLOC: the number of logical lines of code
- SLOC: the number of source lines of code - not necessarily corresponding to the LLOC
- comments: the number of Python comment lines (i.e. only single-line comments #)
- multi: the number of lines representing multi-line strings
- blank: the number of blank lines (or whitespace-only ones)

The equation `SLOC + Multi + Single comments + Blank = LOC` should always hold. Additionally, comment stats are calculated:

- C % L: the ratio between number of comment lines and LOC, expressed as a percentage;
- C % S: the ratio between number of comment lines and SLOC, expressed as a percentage;
- C + M % L: the ratio between number of comment and multiline strings lines and LOC, expressed as a percentage.

### Cyclomatic Complexity

Cyclomatic Complexity corresponds to the number of decisions a block of code contains plus 1. This number (also called McCabe number) is equal to the number of linearly independent paths through the code. This number can be used as a guide when testing conditional logic in blocks.

| CC score | Rank | Risk |
| --- | --- | --- |
| 1 - 5 | A | low - simple block |
| 6 - 10 | B | low - well structured and stable block |
| 11 - 20 | C |	moderate - slightly complex block |
| 21 - 30 | D | more than moderate - more complex block |
| 31 - 40 | E | high - complex block, alarming |
| 41+ |	F | very high - error-prone, unstable block |

| Block type | Letter |
| --- | --- |
| Function | F |
| Method | M |
| Class | C |

### Maintainability Index

Maintainability Index is a software metric which measures how maintainable (easy to support and change) the source code is. The maintainability index is calculated as a factored formula consisting of SLOC (Source Lines Of Code), Cyclomatic Complexity and Halstead volume. It is used in several automated software metric tools, including the Microsoft Visual Studio 2010 development environment, which uses a shifted scale (0 to 100) derivative.

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

## Code Quality

Pylint is a Python source code analyzer which looks for programming errors, helps enforcing a coding standard and sniffs for some code smells (as defined in Martin Fowler's Refactoring book).

Pylint has many rules enabled by default, way too much to silence them all on a minimally sized program. It's highly configurable and handle pragmas to control it from within your code. Additionally, it is possible to write plugins to add your own checks.

It's a free software distributed under the GNU General Public Licence.

Pylint is shipped with following additional commands:

- pyreverse: an UML diagram generator
- symilar: an independent similarities checker
- epylint: Emacs and Flymake compatible Pylint

Pylint will display a number of messages as it analyzes the code and it can also be used for displaying some statistics about the number of warnings and errors found in different files. The messages are classified under various categories such as errors and warnings.

Last but not least, the code is given an overall mark, based on the number and severity of the warnings and errors.

## Links:

Please follow the below links to know more about our analysis of Raw Metrics, Cyclomatic Complexity and Code Maintainability Index.


- [Raw Metrics]()
- [Cyclomatic Complexity]()
- [Code Maintaibility Index]()
- [Code Quality]()
