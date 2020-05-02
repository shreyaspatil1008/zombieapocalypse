package com.shreyas.zombieapocalypse.service;

import com.shreyas.zombieapocalypse.enums.Direction;
import com.shreyas.zombieapocalypse.exception.InvalidInputException;
import com.shreyas.zombieapocalypse.model.*;

import java.util.*;

public class ZombieMovementService {

    private World world;

    private List<Direction> directions;

    private Queue<Creature> zombies;

    private List<Position> zombiePositions;

    private int zombieScore;

    public ZombieMovementService(InputRequest inputRequest) {
        world = new World(
                inputRequest.getDimension(),
                new Creature(new Position(2, 1), true),
                List.of(
                        new Creature(new Position(0, 1), false),
                        new Creature(new Position(1, 2), false),
                        new Creature(new Position(3, 1), false)
                )
        );

        directions = new ArrayList<>();
        directions.add(Direction.DOWN);
        directions.add(Direction.LEFT);
        directions.add(Direction.UP);
        directions.add(Direction.UP);
        directions.add(Direction.RIGHT);
        directions.add(Direction.RIGHT);

        zombies = new LinkedList<>();
        zombiePositions = new LinkedList<>();
    }

    public OutputResponse move() throws InvalidInputException {
        zombies.add(world.getZombie());
        while (!zombies.isEmpty()) {
            world.setZombie(zombies.poll());
            for (Direction direction : directions) {
                Optional<Creature> affectedCreature = world.moveZombie(direction);
                affectedCreature.ifPresent(
                        creature -> {
                            zombies.add(creature);
                            zombieScore++;
                        }
                );
            }
            zombiePositions.add(world.getZombie().getCurrentPosition());
        }

        //System.out.println("Positions: ");

        StringBuilder stringBuilder = new StringBuilder();
        for (Position pos : zombiePositions) {
            //System.out.println("(" + pos.getXCoordinate() + "," + pos.getYCoordinate() + ") \n");
            stringBuilder.append("(" + pos.getXCoordinate() + "," + pos.getYCoordinate() + ") ");
        }
        //System.out.println("zombieScore: " + zombieScore);

        return OutputResponse
                .builder()
                .zombieScore(zombieScore)
                .zombiePosition(stringBuilder.toString())
                .build();
    }
}