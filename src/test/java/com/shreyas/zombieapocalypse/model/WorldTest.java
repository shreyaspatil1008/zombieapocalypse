package com.shreyas.zombieapocalypse.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WorldTest {

    private World world;

    @Test
    void zombieToCreatureBiteTest() {
        Creature creature = new Creature(new Position(1, 1), false);
        Creature zombie = new Creature(new Position(1, 1), true);
        Creature returnedCreature = zombie.bites(creature);
        Creature expectedCreature = new Creature(new Position(1, 1), true);
        Assertions.assertEquals(returnedCreature, expectedCreature);
    }

    @Test
    void zombieToZombieBiteTest() {
        Creature creature = new Creature(new Position(1, 1), true);
        Creature zombie = new Creature(new Position(1, 1), true);
        Creature returnedCreature = zombie.bites(creature);
        Creature expectedCreature = new Creature(new Position(1, 1), true);
        Assertions.assertEquals(returnedCreature, expectedCreature);
    }

}