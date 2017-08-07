# url-dynamic-parts

## General
All algorithms suppose that both paths are symmetric.

Dynamic parts will follow this pattern `query_randomPrintableChar`

1. [Naive algorithm](https://github.com/ysusuk/url-dynamic-parts/blob/master/src/main/scala/App.scala#L15-L27) is the most convinient and simple to understand but will indeed need at least memory to hold list of parts from both paths (something like n * 2, where n is number of parts and part is a string).
1. [Simple algorithm](https://github.com/ysusuk/url-dynamic-parts/blob/master/src/main/scala/App.scala#L29-L51) will need extra processing power, since it will do a lot of char by char traversal (`takeWhile` and `dropWhile`), but will hold in memory only 2 symmetric parts (e.g. users and users or Ben and Lewis )
1. Next algorithm (no implemented) will more efficient ways to take and drop values. It will mainly use best parts of mentioned algorithms.

## Run
```shell
sbt 'runMain Main "/users/Ben/info/location" "/users/Lewis/info/birthday"'
```