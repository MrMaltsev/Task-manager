package Roadmap.TaskManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService service;
    TaskController(TaskService service) { this.service = service; }

    @GetMapping("/tasks")
    List<Task> all() {
        return service.getAllTasks();
    }

    @GetMapping("/tasks/{status}")
    List<Task> doneTasks(@PathVariable Status status) {
        return service.getTasks(status);
    }

    @PutMapping("/tasks")
    Task updateTask(@RequestBody Task updatedTask) {
        return service.updateTask(updatedTask);
    }

    @PostMapping("/tasks")
    Task newTask(@RequestBody Task newTask) {
        return service.addTask(newTask);
    }

    @DeleteMapping("/tasks/{id}")
    void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
