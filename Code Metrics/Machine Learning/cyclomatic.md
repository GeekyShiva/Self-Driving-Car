<div align=center>
  <h1>Code Metrices</h1>
  <h2>Project Volantè</h2>
  <b> Self Driving Car </b><br />
  <b> Version <i>1.0</i></b><br />
  <b> Cyclomatic Complexity </b><br />
</div><br /><br />


# Cyclomatic Complexity

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

Radon analyzes the AST tree of a Python program to compute Cyclomatic Complexity. Statements have the following effects on Cyclomatic Complexity:

| Construct | 	Effect on CC | 	Reasoning |
| --- | --- | --- |
|if |	+1| An if statement is a single decision.|
|elif| 	+1| The elif statement adds another decision.|
|else |	+0 |The else statement does not cause a new decision.The decision is at the if.|
|for |	+1|There is a decision at the start of the loop.|
|while |+1 |There is a decision at the while statement.|
|except |+1| 	Each except branch adds a new conditional path of execution.|
|finally|+0	|The finally block is unconditionally executed.|
|with |	+1 | The with statement roughly corresponds to a try/except block (see PEP 343 for details).|
|assert |+1| The assert statement internally roughly equals a conditional statement.|
|Comprehension| +1| A list/set/dict comprehension of generator expression is equivalent to a for loop.|
|Boolean Operator |	+1| Every boolean operator (and, or) adds a decision point.|

## Measurement and Results:

### File: Machine Learning/driver.py

```
F 111:0 detect_labels_uri - C
F 65:0 road_detected - B
F 35:0 android_data - B
F 155:0 image_data - A
F 90:0 detect_labels - A
```

### File: Machine Learning/gcp_functions.py
```
F 546:0 run_local - C
F 569:0 run_uri - C
F 350:0 detect_web - B
F 394:0 detect_web_uri - B
F 483:0 detect_document - B
F 517:0 detect_document_uri - B
F 25:0 detect_faces - A
F 126:0 detect_landmarks - A
F 256:0 detect_text - A
F 433:0 detect_crop_hints - A
F 59:0 detect_faces_uri - A
F 88:0 detect_labels - A
F 168:0 detect_logos - A
F 282:0 detect_text_uri - A
F 304:0 detect_properties - A
F 460:0 detect_crop_hints_uri - A
F 109:0 detect_labels_uri - A
F 151:0 detect_landmarks_uri - A
F 189:0 detect_logos_uri - A
F 206:0 detect_safe_search - A
F 329:0 detect_properties_uri - A
F 233:0 detect_safe_search_uri - A
```
