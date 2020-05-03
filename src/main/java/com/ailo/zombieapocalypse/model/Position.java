package com.ailo.zombieapocalypse.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Position {
    private Integer xCoordinate;
    private Integer yCoordinate;
}
