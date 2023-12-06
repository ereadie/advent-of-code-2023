# To use:

Modify project.clj to point to the location of the script for the day you want to run.

## Ex.
```
:main ^:skip-aot advent-of-code-2023.day01-1
```
->
```
:main ^:skip-aot advent-of-code-2023.day02-1
```

then

```
lein run
```