
# My rules
think about:
- allow two types of boards indistinctly
- two types of coordinate systems
- custom rules
- custom representation system

game -> setups everything, can implement architectural patterns'
cell -> implements the operations to use the rules
board -> create cells and locate them, tells about neighbours
Coordinate -> as an interface, can define different space rules

# Curious approach -> board with only live cells and check neighbours!
this board
```
          |
     O    |
O         |
     O    |
          |
```
will only check in the hashmap
```
    xxx   |
xx  xOx   |
Ox  xxx   |
xx  xOx   |
    xxx   |
```

Using only alive cells ->
lack of information about dead ones.
if dead ones are accessed by a limit variable (width of 10 e.g.) we can not implement an infinite board

using both ->
also stuck into board limits
Memory usage goes always to high x width

Using alive + dead neighbours ->
infinite board
memory usage reduced
- need to calculate the dead neighbours in each step, can have exponential growth if the game tent to spread (Could we solve this problem through code? maybe assign/unassigned neighbours during process, this could make the whole game completely scalable and cells could work using parallelism

How can we implement this on golang?!
