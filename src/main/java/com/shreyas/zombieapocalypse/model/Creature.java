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
}
