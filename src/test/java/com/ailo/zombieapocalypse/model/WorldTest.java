package com.ailo.zombieapocalypse.model;

import com.ailo.zombieapocalypse.enums.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class WorldTest {

    private World world;
    private List<Creature> creatures;
    private Creature zombie;

    @BeforeEach
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
        Assertions.assertEquals(optionalCreature.isPresent(), false);
    }

    @Test
    void moveZombieTestWithOptionalEmpty() {
        zombie.setCurrentPosition(new Position(1, 0));
        world.setZombie(zombie);
        Optional<Creature> optionalCreature = world.moveZombie(Direction.D);
        Assertions.assertEquals(optionalCreature.isPresent(), true);
        //Assertions.assertEquals(optionalCreature.get(), anotherCreature);
    }


}