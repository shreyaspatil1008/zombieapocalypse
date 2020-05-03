package com.ailo.zombieapocalypse.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class CreatureTest {

    private Creature creature;
    private Creature zombie;
    private Creature expectedCreature;

    @BeforeAll
    public void setUp() {
        creature = new Creature(new Position(1, 1), false);
        zombie = new Creature(new Position(1, 1), true);
        expectedCreature = new Creature(new Position(1, 1), true);
    }

    @Test
    void zombieToCreatureBiteTest() {
        creature.setZombie(false);
        Creature returnedCreature = zombie.bites(creature);
        Assertions.assertEquals(returnedCreature, expectedCreature);
    }

    @Test
    void zombieToZombieBiteTest() {
        creature.setZombie(true);
        Creature returnedCreature = zombie.bites(creature);
        Assertions.assertEquals(returnedCreature, expectedCreature);
    }
}