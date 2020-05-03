package com.ailo.zombieapocalypse.enums.base;

import com.ailo.zombieapocalypse.model.Position;

public interface Movement {

    Position move(Position position, Integer dimension);
}
