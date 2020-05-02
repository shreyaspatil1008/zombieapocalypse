package com.shreyas.zombieapocalypse.service;

import com.shreyas.zombieapocalypse.enums.Direction;
import com.shreyas.zombieapocalypse.factory.PositionFactory;
import com.shreyas.zombieapocalypse.model.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ZombieMovementService {

    private World world;

    private List<Direction> directions;

    private Queue<Creature> zombies;

    private List<Position> zombiePositions;

    private int zombieScore;

    public void init(InputRequest inputRequest) {
        world = new World(
                inputRequest.getDimension(),
                new Creature(PositionFactory.createPosition(inputRequest.getZombiePosition()), true),
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

    public OutputResponse move(){
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
        String stringBuilder = zombiePositions.stream().map(
                pos -> "(" + pos.getXCoordinate() + "," + pos.getYCoordinate() + ") "
        ).collect(Collectors.joining());

        return OutputResponse
                .builder()
                .zombieScore(zombieScore)
                .zombiePosition(stringBuilder)
                .build();
    }
}