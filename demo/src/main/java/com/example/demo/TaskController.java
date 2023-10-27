package com.example.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TaskController {
    private Task tasksList[];

    @PostMapping("/tasks")
    public String createTask(){
        return "teste";
    }
}
