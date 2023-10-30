package com.example.demo.controllers;

import com.example.demo.models.TaskModel;
import com.example.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public String listTasksEndPoint(){
        return "Listar tasks";
    }

    @PostMapping(value = "/tasks")
    public void listTasksPostMapping(){
       taskService.listTasks(taskService.tasks);
    }

    @GetMapping("/tasks/add")
    public String addTasksEndPoint(){
        return "Adicionar tasks";
    }

    @PostMapping(value = "/tasks/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskModel> addTaskPostMapping(@RequestBody TaskModel task){
        return taskService.addTask(task);
    }

    @GetMapping("/tasks/edit/{taskId}")
    public ResponseEntity<String> editTaskEndPoint(@PathVariable String taskId){
        return ResponseEntity.ok("EndPoint para editar tarefas");
    }

    @PostMapping(value = "/tasks/edit/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> editTaskPostMapping(@PathVariable String taskId, @RequestBody TaskModel taskJson){
        return taskService.editTaskPostMapping(taskId,taskJson);
        }

    @GetMapping("/tasks/delete/{taskId}")
    public ResponseEntity<String> deleteTaskEndPoint(@PathVariable String taskId){
        return ResponseEntity.ok("EndPoint para deletar tarefas");
    }

    @PostMapping(value = "/tasks/delete/{taskId}")
    public ResponseEntity<String> deleteTaskPostMapping(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
    }
}
