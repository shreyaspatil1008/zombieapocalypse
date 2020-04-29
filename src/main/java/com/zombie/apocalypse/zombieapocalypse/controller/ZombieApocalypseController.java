package com.zombie.apocalypse.zombieapocalypse.controller;

import com.zombie.apocalypse.zombieapocalypse.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZombieApocalypseController {

    @Autowired
    private ZombieMovementController zombieMovementController;

    @PostMapping("/attack")
    public ResponseEntity attack(
            @RequestHeader(value = "area") Integer area
            ) {

        return null;
    }
}
