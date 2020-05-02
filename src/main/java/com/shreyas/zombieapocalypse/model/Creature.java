package com.shreyas.zombieapocalypse.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Creature {

    private Position currentPosition;
    private boolean isZombie;

    public Creature bites(Creature creature) {
        return new Creature(currentPosition, true);
    }
}
