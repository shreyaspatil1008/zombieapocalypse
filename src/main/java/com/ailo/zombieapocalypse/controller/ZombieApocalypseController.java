package com.ailo.zombieapocalypse.controller;

import com.ailo.zombieapocalypse.model.InputRequest;
import com.ailo.zombieapocalypse.model.OutputResponse;
import com.ailo.zombieapocalypse.service.ZombieMovementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ZombieApocalypseController {

    Logger logger = LogManager.getLogger(ZombieApocalypseController.class);

    private ZombieMovementService zombieMovementService;

    public ZombieApocalypseController(ZombieMovementService zombieMovementService) {

        this.zombieMovementService = zombieMovementService;
    }

    @PostMapping("/apocalypse")
    public OutputResponse apocalypse(@Valid @RequestBody InputRequest inputRequest) {

        logger.info("/apocalypse, received input: " + inputRequest);
        zombieMovementService.init(inputRequest);
        OutputResponse response = zombieMovementService.move();
        logger.info("/apocalypse, generated output: " + response);
        return response;
    }
}
