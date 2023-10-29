package com.example.demo.controllers;

import com.example.demo.models.TaskModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class TaskController {
    public ArrayList<TaskModel> tasks = new ArrayList<TaskModel>();

    @GetMapping("/tasks")
    public String listTasksEndPoint(){
        return "Listar tasks";
    }

    @PostMapping(value = "/tasks")
    public void listTaksPostMapping(){
        System.out.println("Added tasks: ");
        for (TaskModel x: tasks) {
            System.out.println("----------");
            System.out.println("Id: " + x.getId());
            System.out.println("Description: " + x.getDescription());
            System.out.println("Data de validade: " + x.getExpirationDate());
            System.out.println("Done: " + x.getDone());
            System.out.println("----------");
        }
    }

    @GetMapping("/tasks/add")
    public String addTasksEndPoint(){
        return "Adicionar tasks";
    }

    @PostMapping(value = "/tasks/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TaskModel addTaskPostMapping(@RequestBody TaskModel task){
        System.out.println(task.getId());
        System.out.println(task.getDescription());
        System.out.println(task.getExpirationDate());
        System.out.println(task.getDone());
        tasks.add(task);
        return task;
    }

    @GetMapping("/tasks/edit/{taskId}")
    public ResponseEntity<String> editTaskEndPoint(@PathVariable String taskId){
        return ResponseEntity.ok("EndPoint para editar tarefas");
    }

    @PostMapping(value = "/tasks/edit/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> editTaskPostMapping(@PathVariable String taskId, @RequestBody TaskModel taskJson){
        for(TaskModel task : tasks){
            if (task.getId().equals(taskId)){
                task.setId(taskJson.getId());
                task.setDescription(taskJson.getDescription());
                task.setExpirationDate(taskJson.getExpirationDate());
                task.setDone(taskJson.getDone());
                return ResponseEntity.ok("Alterado com sucesso");
            }
        }
        return ResponseEntity.ofNullable("Erro.");
    }

    @GetMapping("/tasks/delete/{taskId}")
    public ResponseEntity<String> deleteTaskEndPoint(@PathVariable String taskId){
        return ResponseEntity.ok("EndPoint para deletar tarefas");
    }

    @PostMapping(value = "/tasks/delete/{taskId}")
    public ResponseEntity<String> deleteTaskPostMapping(@PathVariable String taskId){
        for(TaskModel task : tasks){
            if (task.getId().equals(taskId)){
                tasks.remove(task);
                return ResponseEntity.ok("Tarefa de id " + taskId + " foi removida com sucesso");
            }
        }
        return ResponseEntity.ofNullable("Erro.");
    }







}
