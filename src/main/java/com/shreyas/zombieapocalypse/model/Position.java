package com.shreyas.zombieapocalypse.model;

import com.shreyas.zombieapocalypse.enums.Direction;
import com.shreyas.zombieapocalypse.exception.InvalidInputException;
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

    public Position move(Direction direction, Integer dimensions) throws InvalidInputException {
        switch (direction){
            case UP:
                return moveUp(dimensions);
            case DOWN:
                return moveDown(dimensions);
            case LEFT:
                return moveLeft(dimensions);
            case RIGHT:
                return moveRight(dimensions);
            default:
                throw new InvalidInputException("No direction available with value: " + direction);
        }
    }
}
