package com.zombie.apocalypse.zombieapocalypse.model;

import com.zombie.apocalypse.zombieapocalypse.enums.Direction;
import lombok.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class World {

    private Integer dimensions;

    private Position[][] positions;

    private Creature zombie;

    private List<Creature> creatures;

    public Optional<Creature> moveZombie(Direction direction) {
        Position newZombiePosition = zombie.move(direction);
        Position suspectedCreaturePosition = positions[newZombiePosition.getXCoordinate()][newZombiePosition.getYCoordinate()];
        for(Creature creature: creatures){
            if(creature.getCurrentPosition().equals(suspectedCreaturePosition)){
                if(!creature.isZombie()){
                    zombie.biteCreature(creature);
                    return Optional.of(creature);
                }
                break;
            }
        }
        return null;
    }
}
