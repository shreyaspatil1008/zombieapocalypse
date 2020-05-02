package com.shreyas.zombieapocalypse.model;

import com.shreyas.zombieapocalypse.enums.Direction;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
public class World {

    private Integer dimensions;

    private Map<Position,Creature> positions;

    private Creature zombie;

    private List<Creature> creatures;

    public World(Integer dimensions, Creature zombie, List<Creature> creatures) {
        this.dimensions = dimensions;
        this.positions = new LinkedHashMap<>();
        this.zombie = zombie;
        this.creatures = creatures;
        keepCreaturesOnTheirPositions();
    }

    private void keepCreaturesOnTheirPositions() {
        for(Creature creature: creatures) {
            positions.put(creature.getCurrentPosition(), creature);
        }
    }

    public Optional<Creature> moveZombie(Direction direction){
        Position newZombiePosition = zombie.getCurrentPosition().move(direction, dimensions);
        Creature creature = positions.get(newZombiePosition);
        zombie.setCurrentPosition(newZombiePosition);
        if(null != creature && !creature.isZombie()) {
            creature.setZombie(true);
            positions.put(newZombiePosition, creature);
            return Optional.of(creature);
        }
        return Optional.empty();
    }
}
