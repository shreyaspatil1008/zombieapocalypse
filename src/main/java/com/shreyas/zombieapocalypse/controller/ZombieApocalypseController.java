package com.shreyas.zombieapocalypse.controller;

import com.shreyas.zombieapocalypse.model.InputRequest;
import com.shreyas.zombieapocalypse.model.OutputResponse;
import com.shreyas.zombieapocalypse.service.ZombieMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ZombieApocalypseController {


    @Autowired
    private ZombieMovementService zombieMovementService;

    @PostMapping("/apocalypse")
    public OutputResponse apocalypse(@Valid @RequestBody InputRequest inputRequest){
        zombieMovementService.init(inputRequest);
        return zombieMovementService.move();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
