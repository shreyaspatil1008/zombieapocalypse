package com.ailo.zombieapocalypse.enums;

import com.ailo.zombieapocalypse.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class DirectionTest {

    private Position position;
    private Direction direction;
    private Integer dimension;
    private Position expectedPosition;

    @BeforeAll
    public void setUp() {
        position = new Position(1, 1);
        dimension = 4;
    }

    @Test
    void testUpDirection() {
        direction = Direction.U;
        expectedPosition = new Position(1, 0);
        Position returnedPosition = direction.move(position, dimension);
        Assertions.assertEquals(returnedPosition, expectedPosition);
    }

    @Test
    void testDownDirection() {
        direction = Direction.D;
        expectedPosition = new Position(1, 2);
        Position returnedPosition = direction.move(position, dimension);
        Assertions.assertEquals(returnedPosition, expectedPosition);
    }

    @Test
    void testLeftDirection() {
        direction = Direction.L;
        expectedPosition = new Position(0, 1);
        Position returnedPosition = direction.move(position, dimension);
        Assertions.assertEquals(returnedPosition, expectedPosition);
    }

    @Test
    void testRightDirection() {
        direction = Direction.R;
        expectedPosition = new Position(2, 1);
        Position returnedPosition = direction.move(position, dimension);
        Assertions.assertEquals(returnedPosition, expectedPosition);
    }
}