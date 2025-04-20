package com.example.todoapp.Services;

import com.example.todoapp.models.Task;
import com.example.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public void createTask(String title){
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }
    public void alterStatus(Long id){
        Task element=taskRepository.findById(id).orElse(null);
        if(element!=null){
            boolean status= element.isCompleted();
            element.setCompleted(!status);
            taskRepository.save(element);
        }
    }
}
