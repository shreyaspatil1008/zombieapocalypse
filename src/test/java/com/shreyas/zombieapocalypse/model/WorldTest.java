package com.shreyas.zombieapocalypse.model;

import com.shreyas.zombieapocalypse.enums.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class WorldTest {

    private World world;
    private List<Creature> creatures;
    private Creature zombie;

    @BeforeAll
    public void setUp() {
        Creature creature = new Creature(new Position(1, 1), false);
        Creature anotherCreature = new Creature(new Position(1, 1), false);
        creatures = new ArrayList<>();
        creatures.add(creature);
        creatures.add(anotherCreature);
        zombie = new Creature(new Position(1, 1), true);
        world = new World(4, zombie, creatures);
    }

    @Test
    void moveZombieTestWithOptionalValue() {
        Optional<Creature> optionalCreature = world.moveZombie(Direction.D);
        Assertions.assertEquals(optionalCreature.isPresent(), true);
        //Assertions.assertEquals(optionalCreature.get(), anotherCreature);
    }

    @Test
    void moveZombieTestWithOptionalEmpty() {
        Optional<Creature> optionalCreature = world.moveZombie(Direction.D);
        Assertions.assertEquals(optionalCreature.isPresent(), true);
        //Assertions.assertEquals(optionalCreature.get(), anotherCreature);
    }



}