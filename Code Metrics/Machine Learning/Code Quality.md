<div align=center>
  <h1>Code Metrices</h1>
  <h2>Project Volantè</h2>
  <b> Self Driving Car </b><br />
  <b> Version <i>1.0</i></b><br />
  <b> Code Quality </b><br />
</div><br /><br />

# Code Quality Metrics

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

## Code Quality by Pylint:

Pylint is a Python source code analyzer which looks for programming errors, helps enforcing a coding standard and sniffs for some code smells (as defined in Martin Fowler's Refactoring book).

Pylint has many rules enabled by default, way too much to silence them all on a minimally sized program. It's highly configurable and handle pragmas to control it from within your code. Additionally, it is possible to write plugins to add your own checks.

It's a free software distributed under the GNU General Public Licence.

Pylint is shipped with following additional commands:

- pyreverse: an UML diagram generator
- symilar: an independent similarities checker
- epylint: Emacs and Flymake compatible Pylint

Pylint will display a number of messages as it analyzes the code and it can also be used for displaying some statistics about the number of warnings and errors found in different files. The messages are classified under various categories such as errors and warnings.

Last but not least, the code is given an overall mark, based on the number and severity of the warnings and errors.

## Measurement and Results:

### File: Machine Learning/driver.py

```

78 statements analysed.  
  
Statistics by type  
  
  
+---------+-------+-----------+-----------+------------+---------+  
|type     |number |old number |difference |%documented |%badname |  
+=========+=======+===========+===========+============+=========+  
|module   |1      |NC         |NC         |0.00        |0.00     |  
+---------+-------+-----------+-----------+------------+---------+  
|class    |0      |NC         |NC         |0           |0        |  
+---------+-------+-----------+-----------+------------+---------+  
|method   |0      |NC         |NC         |0           |0        |  
+---------+-------+-----------+-----------+------------+---------+  
|function |5      |NC         |NC         |40.00       |0.00     |  
+---------+-------+-----------+-----------+------------+---------+  
  
  
  
External dependencies  
---------------------  
::  
  
    requests (remote1)  
  
  
  
Raw metrics  
-----------  
  
+----------+-------+------+---------+-----------+  
|type      |number |%     |previous |difference |  
+==========+=======+======+=========+===========+  
|code      |85     |47.75 |NC       |NC         |  
+----------+-------+------+---------+-----------+  
|docstring |3      |1.69  |NC       |NC         |  
+----------+-------+------+---------+-----------+  
|comment   |23     |12.92 |NC       |NC         |  
+----------+-------+------+---------+-----------+  
|empty     |67     |37.64 |NC       |NC         |  
+----------+-------+------+---------+-----------+  
  
  
  
Duplication  
-----------  
  
+-------------------------+------+---------+-----------+  
|                         |now   |previous |difference |  
+=========================+======+=========+===========+  
|nb duplicated lines      |0     |NC       |NC         |  
+-------------------------+------+---------+-----------+  
|percent duplicated lines |0.000 |NC       |NC         |  
+-------------------------+------+---------+-----------+  
  
  
  
Messages by category  
--------------------  
  
+-----------+-------+---------+-----------+  
|type       |number |previous |difference |  
+===========+=======+=========+===========+  
|convention |44     |NC       |NC         |  
+-----------+-------+---------+-----------+  
|refactor   |1      |NC       |NC         |  
+-----------+-------+---------+-----------+  
|warning    |54     |NC       |NC         |  
+-----------+-------+---------+-----------+  
|error      |19     |NC       |NC         |  
+-----------+-------+---------+-----------+  
  
  
  
Messages  
--------  
  
+-----------------------------+------------+  
|message id                   |occurrences |  
+=============================+============+  
|mixed-indentation            |49          |  
+-----------------------------+------------+  
|trailing-whitespace          |13          |  
+-----------------------------+------------+  
|superfluous-parens           |13          |  
+-----------------------------+------------+  
|undefined-variable           |12          |  
+-----------------------------+------------+  
|import-error                 |6           |  
+-----------------------------+------------+  
|wrong-import-order           |4           |  
+-----------------------------+------------+  
|missing-docstring            |4           |  
+-----------------------------+------------+  
|line-too-long                |4           |  
+-----------------------------+------------+  
|bad-whitespace               |4           |  
+-----------------------------+------------+  
|unused-variable              |2           |  
+-----------------------------+------------+  
|unused-import                |2           |  
+-----------------------------+------------+  
|invalid-name                 |2           |  
+-----------------------------+------------+  
|too-many-boolean-expressions |1           |  
+-----------------------------+------------+  
|no-name-in-module            |1           |  
+-----------------------------+------------+  
|global-at-module-level       |1           |  
+-----------------------------+------------+  
  
  
  
Global evaluation  
-----------------  
Your code has been rated at 4.87/10

```
### File: Machine Learning/gcp_functions.py

```
369 statements analysed.

Statistics by type
------------------

+---------+-------+-----------+-----------+------------+---------+
|type     |number |old number |difference |%documented |%badname |
+=========+=======+===========+===========+============+=========+
|module   |1      |NC         |NC         |0.00        |0.00     |
+---------+-------+-----------+-----------+------------+---------+
|class    |0      |NC         |NC         |0           |0        |
+---------+-------+-----------+-----------+------------+---------+
|method   |0      |NC         |NC         |0           |0        |
+---------+-------+-----------+-----------+------------+---------+
|function |22     |NC         |NC         |90.91       |0.00     |
+---------+-------+-----------+-----------+------------+---------+



Raw metrics
-----------

+----------+-------+------+---------+-----------+
|type      |number |%     |previous |difference |
+==========+=======+======+=========+===========+
|code      |386    |56.10 |NC       |NC         |
+----------+-------+------+---------+-----------+
|docstring |51     |7.41  |NC       |NC         |
+----------+-------+------+---------+-----------+
|comment   |83     |12.06 |NC       |NC         |
+----------+-------+------+---------+-----------+
|empty     |168    |24.42 |NC       |NC         |
+----------+-------+------+---------+-----------+



Duplication
-----------

+-------------------------+------+---------+-----------+
|                         |now   |previous |difference |
+=========================+======+=========+===========+
|nb duplicated lines      |0     |NC       |NC         |
+-------------------------+------+---------+-----------+
|percent duplicated lines |0.000 |NC       |NC         |
+-------------------------+------+---------+-----------+



Messages by category
--------------------

+-----------+-------+---------+-----------+
|type       |number |previous |difference |
+===========+=======+=========+===========+
|convention |113    |NC       |NC         |
+-----------+-------+---------+-----------+
|refactor   |0      |NC       |NC         |
+-----------+-------+---------+-----------+
|warning    |2      |NC       |NC         |
+-----------+-------+---------+-----------+
|error      |4      |NC       |NC         |
+-----------+-------+---------+-----------+



Messages
--------

+---------------------+------------+
|message id           |occurrences |
+=====================+============+
|superfluous-parens   |75          |
+---------------------+------------+
|invalid-name         |25          |
+---------------------+------------+
|bad-continuation     |10          |
+---------------------+------------+
|missing-docstring    |3           |
+---------------------+------------+
|too-many-format-args |2           |
+---------------------+------------+
|redefined-outer-name |2           |
+---------------------+------------+
|import-error         |2           |
+---------------------+------------+



Global evaluation
-----------------
Your code has been rated at 6.34/10
```

