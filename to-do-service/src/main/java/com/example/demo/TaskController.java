package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;

@RestController

public class TaskController {
    public ArrayList<Task> tasks = new ArrayList<Task>();

    @GetMapping("/tasks")
    public String listTasksText(){
        return "Listar tasks";
    }

    @PostMapping(value = "/tasks")
    public void listTaks(){
        System.out.println("Added tasks: ");
        for (Task x: tasks) {
            System.out.println("----------");
            System.out.println("Id: " + x.getId());
            System.out.println("Description: " + x.getDescription());
            System.out.println("Data de validade: " + x.getExpirationDate());
            System.out.println("Done: " + x.isDone());
            System.out.println("----------");
        }
    }

    @GetMapping("/tasks/add")
    public String index(){
        return "Adicionar tasks";
    }

    @PostMapping(value = "/tasks/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task createTask(@RequestBody Task task){
        System.out.println(task.getId());
        System.out.println(task.getDescription());
        System.out.println(task.getExpirationDate());
        System.out.println(task.isDone());
        tasks.add(task);
        return task;
    }
}
