# Arduino Code Metrics

The following code metrics have been calculated using SourceMonitor.

## 1. Code metrics for the entire code

* Number of functions = 10
* Number of lines = 331
  * Number of statements = 148
  * Percentage branches = 27.7
  * Percentage comments = 49.2
* Method complexity (Max) = 13
* Method complexity (Avg) = 3.8
* Code depth (Max) = 4
* Code depth (Avg) = 1.24

## 2. Metrics for individual methods

| Method Name | Complexity | Statements | Maximum Depth | Calls |
|-------------|------------|------------|---------------|-------|
| echoCheck() | 2 | 2 | 2 | 1 |
| initSpeedPins() | 1 | 6 | 1 | 12 |
| initTurnPins() | 1 | 6 | 1 | 12 |
| loop() | 13 | 35 | 4 | 15 |
| readSpeedInput() | 4 | 7 | 1 | 6 |
| readTurnInput() | 4 | 7 | 1 | 6 |
| setup() | 3 | 8 | 2 | 8 |
| writeDistanceData() | 2 | 4 | 2 | 6 |
| writeSpeedData() | 4 | 13 | 3 | 14 |
| writeTurnData() | 4 | 13 | 3 | 14 |

## 3. Legend

| Metric | Description |
|--------|-------------|
| Statements | In C++, computational statements are terminated with a semicolon character. Branches such as if, for, while and goto are also counted as statements. The exception control statements try and catch are also counted as statements. Preprocessor directives #include, #define, and #undef are counted as statements. All other preprocessor directives are ignored. In addition all statements between each #else or #elif statement and its closing #endif statement are ignored, to eliminate fractured block structures. |
| Percent Branch Statements | Statements that cause a break in the sequential execution of statements are counted separately. These are the following: if, else, for, while, break, continue, goto, switch, case, default, and return. Note that do is not counted because it is always followed by a while, which is counted. The try block statement catch is also counted as a branch statement. |
| Percent Lines with Comments | The lines that contain comments, either C style (/*...*/) or C++ style (//...) are counted and compared to the total number of lines in the file to compute this metric. |
| Functions | Number of functions found. |
| Method Complexity | The complexity metric is counted approximately as defined by Steve McConnell in his book Code Complete, Microsoft Press, 1993, p.395. The complexity metric measures the number of execution paths through a function or method. Each function or method has a complexity of one plus one for each branch statement such as if, else, for, foreach, or while. Arithmetic if statements (MyBoolean ? ValueIfTrue : ValueIfFalse) each add one count to the complexity total. A complexity count is added for each '&&' and '\|\|' in the logic within if, for, while or similar logic statements. |
| Maximum Block Depth | Maximum Block Depth is the maximum nested block depth level found. At the start of each file the block level is zero. Depths up to 9 are recorded and all statements at deeper levels are counted as depth 9. This is indicated by the "9+" label for the deepest level. |
| Average Block Depth | Average Block Depth is the average nested block depth weighted by depth. While nesting can be used alone in most languages, nested blocks are almost always introduced with execution control statements such as “if”, "case".  and “while”. As the depth grows, the code gets harder to read because with each new nested depth level, more conditions must be evaluated if you want to know when the code will be executed. Average block depth is the weighted average of the block depth of all statements in a file or checkpoint. |
