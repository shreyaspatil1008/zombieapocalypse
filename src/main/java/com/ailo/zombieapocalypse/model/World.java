package com.ailo.zombieapocalypse.model;

import com.ailo.zombieapocalypse.enums.Direction;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
public class World {

    Logger logger = LogManager.getLogger(World.class);

    private Integer dimension;

    private Map<Position, Creature> positions;

    private Creature zombie;

    private List<Creature> creatures;

    public World(Integer dimension, Creature zombie, List<Creature> creatures) {
        this.dimension = dimension;
        this.positions = new LinkedHashMap<>();
        this.zombie = zombie;
        this.creatures = creatures;
        keepCreaturesOnTheirPositions();
    }

    private void keepCreaturesOnTheirPositions() {
        logger.info("keeping creatures on their positions: " + creatures);
        for(Creature creature: creatures) {
            positions.put(creature.getCurrentPosition(), creature);
        }
    }

    public Optional<Creature> moveZombie(Direction direction){
        Position newZombiePosition = direction.move(zombie.getCurrentPosition(), dimension);
        logger.info("zombie moved from : " + zombie.getCurrentPosition() + " to : " + newZombiePosition);
        Creature creature = positions.get(newZombiePosition);
        zombie.setCurrentPosition(newZombiePosition);
        if(null != creature && !creature.isZombie()) {
            logger.info("creature present on new zombie position, hence zombie bites this creature.");
            return zombieBitesCreature(newZombiePosition, creature);
        }
        return Optional.empty();
    }

    private Optional<Creature> zombieBitesCreature(Position newZombiePosition, Creature creature) {
        Creature zombieCreature = zombie.bites(creature);
        positions.put(newZombiePosition, zombieCreature);
        return Optional.of(zombieCreature);
    }
}
