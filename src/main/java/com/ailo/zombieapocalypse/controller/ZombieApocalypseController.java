package com.ailo.zombieapocalypse.controller;

import com.ailo.zombieapocalypse.model.InputRequest;
import com.ailo.zombieapocalypse.model.OutputResponse;
import com.ailo.zombieapocalypse.service.ZombieMovementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ZombieApocalypseController {

    private ZombieMovementService zombieMovementService;

    public ZombieApocalypseController(ZombieMovementService zombieMovementService) {
        this.zombieMovementService = zombieMovementService;
    }

    @PostMapping("/apocalypse")
    public OutputResponse apocalypse(@Valid @RequestBody InputRequest inputRequest){
        zombieMovementService.init(inputRequest);
        return zombieMovementService.move();
    }
}
