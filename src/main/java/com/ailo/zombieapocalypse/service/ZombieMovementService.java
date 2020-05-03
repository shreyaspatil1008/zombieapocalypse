package com.ailo.zombieapocalypse.service;

import com.ailo.zombieapocalypse.enums.Direction;
import com.ailo.zombieapocalypse.factory.PositionFactory;
import com.ailo.zombieapocalypse.model.Creature;
import com.ailo.zombieapocalypse.model.InputRequest;
import com.ailo.zombieapocalypse.model.OutputResponse;
import com.ailo.zombieapocalypse.model.Position;
import com.ailo.zombieapocalypse.model.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

@Service
public class ZombieMovementService {

    Logger logger = LogManager.getLogger(ZombieMovementService.class);

    private World world;

    private List<Direction> directions;

    private Queue<Creature> zombies;

    private List<Position> zombiePositions;

    private int zombieScore;

    public void init(InputRequest inputRequest) {
        logger.info("initializing ZombieMovementService with inputRequest: " + inputRequest);
        world = createWorld(inputRequest);
        directions = createDirections(inputRequest.getMovements());
        zombies = new LinkedList<>();
        zombiePositions = new LinkedList<>();
        zombieScore = 0;
    }

    private List<Direction> createDirections(String movements) {
        logger.info("creating directions from movements: " + movements);
        return movements.chars()
                .mapToObj(c -> Direction.valueOf(String.valueOf((char) c)))
                .collect(Collectors.toList());
    }

    private World createWorld(InputRequest inputRequest) {
        logger.info("creating world object from inputRequest: " + inputRequest);
        return new World(
                inputRequest.getDimension(),
                createZombie(inputRequest.getZombiePosition(), true),
                createCreatures(inputRequest.getCreaturePosition())
        );
    }

    private Creature createZombie(String zombiePosition, boolean b) {
        logger.info("creating zombie creature object from zombiePosition: " + zombiePosition);
        return new Creature(PositionFactory.createPosition(zombiePosition), b);
    }

    private List<Creature> createCreatures(String creaturePosition) {
        logger.info("creating creature list from creaturePosition: " + creaturePosition);
        creaturePosition = creaturePosition.trim().replaceAll("\\)", "\\):");
        String[] positions = creaturePosition.split(":");
        List<Creature> creatures = new ArrayList<>();
        for (String position : positions) {
            creatures.add(createZombie(position, false));
        }
        logger.info("generated creature list: " + creatures);
        return creatures;
    }

    public OutputResponse move() {

        logger.info("adding initial zombie to queue zombies");
        zombies.add(world.getZombie());
        while (!zombies.isEmpty()) {
            logger.info("retrieving first zombie from queue zombies");
            retrieveFirstZombieFromQueue();
            logger.info("moving zombie on directions");
            moveZombieOnDirections();
            logger.info("persisting zombie's final position");
            persistZombiesFinalPosition();
        }
        return buildOutputResponse();
    }

    private void retrieveFirstZombieFromQueue() {
        world.setZombie(zombies.poll());
    }

    private void persistZombiesFinalPosition() {
        zombiePositions.add(world.getZombie().getCurrentPosition());
    }

    private void moveZombieOnDirections() {
        for (Direction direction : directions) {
            Optional<Creature> affectedCreature = world.moveZombie(direction);
            affectedCreature.ifPresent(
                    creature -> {
                        logger.info("zombie bites creature: " + creature);
                        zombies.add(creature);
                        zombieScore++;
                        logger.info("zombieScore is: " + zombieScore);
                    }
            );
        }
    }

    private OutputResponse buildOutputResponse() {
        logger.info("building output response");
        return OutputResponse
                .builder()
                .zombieScore(zombieScore)
                .zombiePosition(zombiePositions
                        .stream()
                        .map(pos -> "(" + pos.getXCoordinate() + "," + pos.getYCoordinate() + ") ")
                        .collect(Collectors.joining()))
                .build();
    }
}