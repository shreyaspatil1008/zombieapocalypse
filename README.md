# Zombie Apocalypse

### Introduction: 

After the nuclear war, a strange and deadly virus has infected the planet. Living creatures
are becoming zombies that spread their zombiness by an unfriendly bite. 

### Problem Statement: 

The world consists of an n x n grid on which zombies and creatures live.
Both of these occupy a single square on the grid and can be addressed using zero-indexed
x-y coordinates. Top left corner is (x: 0, y: 0) with x represent horizontal coordinate, y
represent vertical coordinate. 
Any number of zombies and creatures may occupy the same grid square.
At the beginning of the program, a single zombie awakes and begins to move around the
grid. It is given an initial x-y coordinate and a list of movements, up, down, left and right. E.g.
( U , D , L , R ).

### Rules: 

1. If a zombie moves so that it end up on the same location as a creature, the creature is
transformed into another zombie and zombies score one point. 

2. The zombie continues moving and infecting creatures until has performed all its moves.

3. Once it has completed its movement, the first newly created zombie moves using the same
sequence as the original zombie. 

4. Once it has completed its move, the second newly created
zombie moves, and so in order of infection with each zombie performing the same sequence
of moves. 

5. Once no new zombies have been created and all the zombies have completed
moving the program ends.


### Task: 

Your task is to write a program that takes input that describes the following parameters:

#### Input

1. Dimensions of the area (N)
2. The initial position of the zombie
3. A list of positions of poor creatures
4. A list of moves zombies will make to produce an output that shows:


#### Output: 

1. The number of points scored by the zombies
2. The final position of the zombies



# Solution
This repository contains solution to above problem.

To build the application and run unit tests run command ``mvn clean install``

To run the application run command ``mvn spring-boot:run``

To access the swagger page to simulate and check api visit [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

For authentication Basic Auth is configured:
    ``username: ailo``
    ``password: password``


### Assumptions:

1. The input to the RestController is an Input object and the caller's responsibility to provide input in InputRequest format only.

2. Conversion of one input format (json, txt, xml) is out of scope of this problem.

3. As the problem statement does not contain sample input files, the conversion of the input from file to specified object is for future scope once we will have clarity of the file formats.