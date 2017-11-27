<div align=center>
  <h1>Code Metrices</h1>
  <h2>Project Volantè</h2>
  <b> Self Driving Car </b><br />
  <b> Version <i>1.0</i></b><br />
  <b> Code Metrics </b><br />
</div><br /><br />


# Cyclomatic Complexity

## Legend

| CC score | Rank | Risk |
|----------|------|------|
| 1 - 5 | A | Low - Simple Block |
| 6 - 10 | B | Low - well structured and stable block |
| 11 - 20 |	C | Moderate - slightly complex block |
| 21 - 30 |	D |	More than moderate - more complex block |
| 31 - 40 |	E |	High - complex block, alarming |
| 41+ |	F |	Very high - error-prone, unstable block |

| Block type | Letter |
|------------|--------|
| Function | F |
| Method | M |
| Class | C |

## Metric

| Block type | Name | Rank | CC Score |
|------------|------|------|----------|
| F 45:0 | set_turn | A | 4 |
| F 74:0 | set_speed | A | 4 |
| F 21:0 | init | A | 2 |
| F 103:0 | get_distance | A | 1 |

4 blocks (classes, functions, methods) analyzed.
Average complexity: A (2.75)

# Maintainability Index

## Legend

| MI Score | Rank | Maintainability |
|----------|------|-----------------|
| 100 - 20 | A | Very High |
| 19 - 10 | B | Medium |
| 9 - 0 | C | Extremely Low |

## Metric

| File | MI Score | Rank |
|------|----------|------|
| car.py | 77.35 | A|

# Raw Metrics

| Metric | value | Description |
|--------|-------|-------------|
| LOC | 118 | The total number of lines of code. It does not necessarily correspond to the number of lines in the file. |
| LLOC | 48 | The number of logical lines of code. Every logical line of code contains exactly one statement. |
| SLOC | 47 | The number of source lines of code - not necessarily corresponding to the LLOC. |
| Comments | 18 | The number of comment lines. |
| Single comments | 13 | Single line comments |
| Multi | 33 | The number of lines which represent multi-line strings. |
| Blank | 25 | The number of blank lines (or whitespace-only ones). |
| C % L | 15% | The ratio between number of comment lines and LOC, expressed as a percentage. |
| C % S | 38% | The ratio between number of comment lines and SLOC, expressed as a percentage. |
|C + M % L | 43% | The ratio between number of comment and multiline strings lines and LOC, expressed as a percentage. |