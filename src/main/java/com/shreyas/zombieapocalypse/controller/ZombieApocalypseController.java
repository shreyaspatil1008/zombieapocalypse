package com.shreyas.zombieapocalypse.controller;

import com.shreyas.zombieapocalypse.exception.InvalidInputException;
import com.shreyas.zombieapocalypse.model.InputRequest;
import com.shreyas.zombieapocalypse.model.OutputResponse;
import com.shreyas.zombieapocalypse.service.ZombieMovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZombieApocalypseController {


    public ZombieApocalypseController() {
    }

    @PostMapping("/attack")
    public OutputResponse attack(@RequestBody InputRequest inputRequest) throws InvalidInputException {
        return new ZombieMovementService(inputRequest).move();
    }
}
