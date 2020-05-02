package com.shreyas.zombieapocalypse.enums;

public enum Direction {
    LEFT("L"),
    RIGHT("R"),
    UP("U"),
    DOWN("D");

    private String movement;

    Direction(String movement){
        this.movement = movement;
    }

    public String getMovement(){
        return this.movement;
    }
}
