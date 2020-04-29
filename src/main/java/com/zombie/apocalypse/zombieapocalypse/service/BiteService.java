package com.zombie.apocalypse.zombieapocalypse.service;

import com.zombie.apocalypse.zombieapocalypse.model.Creature;
import org.springframework.stereotype.Service;

@Service
public class BiteService {

    public Creature bite(final Creature creature){

        return new Creature(creature.getCurrentPosition(), true);
    }
}
