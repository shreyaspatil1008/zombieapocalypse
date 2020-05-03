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

If a zombie moves so that it end up on the same location as a creature, the creature is
transformed into another zombie and zombies score one point. 

The zombie continues moving and infecting creatures until has performed all its moves.

Once it has completed its movement, the first newly created zombie moves using the same
sequence as the original zombie. 

Once it has completed its move, the second newly created
zombie moves, and so in order of infection with each zombie performing the same sequence
of moves. 

Once no new zombies have been created and all the zombies have completed
moving the program ends.


### Task: 

Your task is to write a program that takes input that describes the following parameters:

#### Input

dimensions of the area (N)

the initial position of the zombie

a list of positions of poor creatures

and a list of moves zombies will make to produce an output that shows:


#### Output: 

the number of points scored by the zombies

the final position of the zombies



# Solution
This repository contains solution to above problem.

To build the application and run unit tests run command ``mvn clean install``

To run the application run command ``mvn spring-boot:run``

To access the swagger page to simulate and check api visit [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

For authentication Basic Auth is configured:
    ``username: ailo``
    ``password: password``
