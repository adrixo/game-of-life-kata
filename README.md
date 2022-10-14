
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

