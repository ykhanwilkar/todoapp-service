package io.todoapp.service;

import io.todoapp.model.Task;
import io.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void addTasks(List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

    public int markTaskComplete(String taskId) {
        return taskRepository.markTaskAsComplete(taskId);
    }

    public int updateTask(@NonNull Task task) {
        return taskRepository.updateTask(task.getTaskHeading(), task.getTaskDescription(), task.getStatus(), task.getId());
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }
}
