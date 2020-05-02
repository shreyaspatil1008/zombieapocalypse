package com.shreyas.zombieapocalypse.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
