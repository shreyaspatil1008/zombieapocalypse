package com.zombie.apocalypse.zombieapocalypse.controller;

import com.zombie.apocalypse.zombieapocalypse.model.Creature;
import com.zombie.apocalypse.zombieapocalypse.enums.Direction;
import com.zombie.apocalypse.zombieapocalypse.model.World;
import com.zombie.apocalypse.zombieapocalypse.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

@Controller
public class ZombieMovementController {

    private World world;

    private List<Direction> directions;

    private Queue<Creature> zombies = new LinkedList<>();

    private Queue<Creature> zombiePositions = new LinkedList<>();

    @Autowired
    private MoveService moveService;

    public void move() throws Exception {

        for (Direction direction : directions) {
            Optional<Creature> affectedCreature = world.moveZombie(direction);
            affectedCreature.ifPresent(
                    creature -> zombiePositions.add(creature)
            );
        }
        zombiePositions.add(world.getZombie());
    }
}