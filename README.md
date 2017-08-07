# url-dynamic-parts

## General
All algorithms suppose that both paths are symmetric.
Dynamic parts will follow this pattern ***query_randomPrintableChar***

1. Naive algorithm is the most convinient and simple to understand but will indeed need at least memory to hold list of parts from both paths (something like n * 2, where n is number of parts).
1. Simple algorithm will need extra processing power, since it will do a lot of char by chare traversal (`takeWhile` and `dropWhile`)
1. Next algorithm (no implemented) will more efficient ways to take and drop values.

## Run
```shell
sbt 'runMain Main "/users/Ben/info/location" "/users/Lewis/info/birthday"'
```