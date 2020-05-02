package com.shreyas.zombieapocalypse.model;

import com.shreyas.zombieapocalypse.enums.Direction;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Position {
    private Integer xCoordinate;
    private Integer yCoordinate;

    public Position moveUp(Integer dimension){
        int newYCoordinate = (this.yCoordinate == 0) ? dimension-1 : this.yCoordinate - 1;
        return new Position(xCoordinate, newYCoordinate);
    }

    public Position moveDown(Integer dimension){
        int newYCoordinate = this.yCoordinate + 1 == dimension ? 0 : this.yCoordinate + 1;
        return new Position(xCoordinate, newYCoordinate);
    }

    public Position moveLeft(Integer dimension){
        int newXCoordinate = (this.xCoordinate == 0) ? (dimension-1) : this.xCoordinate - 1;
        return new Position(newXCoordinate, yCoordinate);
    }

    public Position moveRight(Integer dimension){
        int newXCoordinate = this.xCoordinate + 1 == dimension ? 0 : this.xCoordinate + 1;
        return new Position(newXCoordinate, yCoordinate);
    }

    public Position move(Direction direction, Integer dimensions){
        switch (direction){
            case U:
                return moveUp(dimensions);
            case D:
                return moveDown(dimensions);
            case L:
                return moveLeft(dimensions);
            case R:
                return moveRight(dimensions);
        }
        return null;
    }
}
