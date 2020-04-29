package com.zombie.apocalypse.zombieapocalypse.model;

import com.zombie.apocalypse.zombieapocalypse.enums.Direction;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Creature {

    private Position currentPosition;
    private boolean isZombie;

    public Position move(Direction direction) {
        //TO DO: Logic to calculate direction and new position
        return new Position();
    }

    public void biteCreature(Creature creature) {
        creature.setZombie(true);
    }
}
