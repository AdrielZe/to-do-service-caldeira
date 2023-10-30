package com.example.demo.services;

import com.example.demo.controllers.TaskController;
import com.example.demo.models.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service

public class TaskService {
    public ArrayList<TaskModel> tasks = new ArrayList<TaskModel>();

    public void listTasks(ArrayList<TaskModel> tasks) {
        System.out.println("Added tasks: ");
        for (TaskModel x : tasks) {
            System.out.println("----------");
            System.out.println("Id: " + x.getId());
            System.out.println("Description: " + x.getDescription());
            System.out.println("Data de validade: " + x.getExpirationDate());
            System.out.println("Done: " + x.getDone());
            System.out.println("----------");
        }
    }

    public TaskModel addTask(TaskModel task) {
        System.out.println(task.getId());
        System.out.println(task.getDescription());
        System.out.println(task.getExpirationDate());
        System.out.println(task.getDone());
        tasks.add(task);
        return task;
    }

    public ResponseEntity<String> editTaskPostMapping(String taskId, TaskModel taskToEdit) {
        for (TaskModel task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setId(taskToEdit.getId());
                task.setDescription(taskToEdit.getDescription());
                task.setExpirationDate(taskToEdit.getExpirationDate());
                task.setDone(taskToEdit.getDone());
                return ResponseEntity.ok("Alterado com sucesso");
            }
        }
        return ResponseEntity.ofNullable("Erro.");
    }

    public ResponseEntity<String> deleteTask(String taskId) {
        for (TaskModel task : tasks) {
            if (task.getId().equals(taskId)) {
                tasks.remove(task);
                return ResponseEntity.ok("Tarefa de id " + taskId + " foi removida com sucesso");
            }
        }
        return ResponseEntity.ofNullable("Erro.");
    }
}
