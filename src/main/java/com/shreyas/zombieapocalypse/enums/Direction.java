package com.shreyas.zombieapocalypse.enums;

public enum Direction {
    L("L"),
    R("R"),
    U("U"),
    D("D");

    private String movement;

    Direction(String movement){
        this.movement = movement;
    }

    public String getMovement(){
        return this.movement;
    }
}
