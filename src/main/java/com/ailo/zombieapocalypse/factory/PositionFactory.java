package com.ailo.zombieapocalypse.factory;

import com.ailo.zombieapocalypse.model.Position;

public class PositionFactory {

    public static Position createPosition(String coordinates){

        String[] coordinateValues = coordinates
                .trim()
                .replace("(","")
                .replace(")","")
                .split(",");
        int xCoordinate = Integer.parseInt(coordinateValues[0]);
        int yCoordinate = Integer.parseInt(coordinateValues[1]);
        return new Position(xCoordinate, yCoordinate);
    }
}
