package com.shreyas.zombieapocalypse.service;

import com.shreyas.zombieapocalypse.model.Creature;
import org.springframework.stereotype.Service;

@Service
public class BiteService {

    public Creature bite(final Creature creature){

        return new Creature(creature.getCurrentPosition(), true);
    }
}
