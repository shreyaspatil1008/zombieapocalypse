package com.ailo.zombieapocalypse.service;

import com.ailo.zombieapocalypse.model.InputRequest;
import com.ailo.zombieapocalypse.model.OutputResponse;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ZombieMovementServiceTest {

    private ZombieMovementService zombieMovementService;

    @BeforeAll
    public void setUp() {
        zombieMovementService = new ZombieMovementService();

    }

    @Test
    void moveZombieWithProvidedInputRequest() {
        zombieMovementService.init(new InputRequest(
                4,
                "(2,1)",
                "(0,1) (1,2) (3,1)",
                "DLUURR"
        ));
        OutputResponse outputResponse = zombieMovementService.move();
        Assert.assertEquals(outputResponse.getZombieScore(), Integer.valueOf(3));
        Assert.assertEquals(outputResponse.getZombiePosition(), "(3,0) (2,1) (1,0) (0,0) ");
    }

    @Test
    void moveZombieWithDifferentInputRequest() {
        zombieMovementService.init(new InputRequest(
                4,
                "(1,1)",
                "(1,1) (1,2) (3,1) (3,2)",
                "DLUURR"
        ));
        OutputResponse outputResponse = zombieMovementService.move();
        Assert.assertEquals(outputResponse.getZombieScore(), Integer.valueOf(2));
        Assert.assertEquals(outputResponse.getZombiePosition(), "(2,0) (2,1) (2,0) ");
    }
}