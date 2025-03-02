package io.todoapp.controller;

import io.todoapp.model.Task;
import io.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.of(Optional.ofNullable(taskService.getTasks()));
    }

    @PostMapping("/addTask")
    public ResponseEntity.BodyBuilder addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return ResponseEntity.accepted();
    }

    @PostMapping("/addTasks")
    public ResponseEntity.BodyBuilder addAllTasks(@RequestBody List<Task> taskList) {
        taskService.addTasks(taskList);
        return ResponseEntity.accepted();
    }

    @PutMapping("/markAsComplete")
    public ResponseEntity.BodyBuilder updateStatus(@RequestBody String taskId) {
        return taskService.markTaskComplete(taskId) > 0 ? ResponseEntity.accepted() : ResponseEntity.badRequest();
    }

    @PutMapping("/updateTask")
    public ResponseEntity.BodyBuilder updateTask(@RequestBody Task task) {
        return taskService.updateTask(task) > 0 ? ResponseEntity.accepted() : ResponseEntity.badRequest();
    }

    @DeleteMapping("/deleteTask")
    public ResponseEntity.BodyBuilder deleteTask(@RequestBody Task task) {
        taskService.deleteTask(task);
        return ResponseEntity.ok();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity.BodyBuilder deleteAllTasks() {
        taskService.deleteAllTasks();
        return ResponseEntity.accepted();
    }

}
