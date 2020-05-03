package com.ailo.zombieapocalypse.enums;

import com.ailo.zombieapocalypse.enums.base.Movement;
import com.ailo.zombieapocalypse.model.Position;

public enum Direction implements Movement {
    U("UP") {
        @Override
        public Position move(Position position, Integer dimension) {
            int newYCoordinate = (position.getYCoordinate() == 0) ? dimension - 1 : position.getYCoordinate() - 1;
            return new Position(position.getXCoordinate(), newYCoordinate);
        }
    },
    D("DOWN") {
        @Override
        public Position move(Position position, Integer dimension) {
            int newYCoordinate = position.getYCoordinate() + 1 == dimension ? 0 : position.getYCoordinate() + 1;
            return new Position(position.getXCoordinate(), newYCoordinate);
        }
    },
    L("LEFT") {
        @Override
        public Position move(Position position, Integer dimension) {
            int newXCoordinate = (position.getXCoordinate() == 0) ? (dimension - 1) : position.getXCoordinate() - 1;
            return new Position(newXCoordinate, position.getYCoordinate());
        }
    },
    R("RIGHT") {
        @Override
        public Position move(Position position, Integer dimension) {
            int newXCoordinate = position.getXCoordinate() + 1 == dimension ? 0 : position.getXCoordinate() + 1;
            return new Position(newXCoordinate, position.getYCoordinate());
        }
    };

    private String movement;

    Direction(String movement){
        this.movement = movement;
    }
}
