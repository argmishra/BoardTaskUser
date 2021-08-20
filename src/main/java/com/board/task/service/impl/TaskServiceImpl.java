package com.board.task.service.impl;

import com.board.task.dto.request.TaskRequest;
import com.board.task.dto.response.TaskResponse;
import com.board.task.enums.StatusEnum;
import com.board.task.exception.TaskNotFoundException;
import com.board.task.model.Task;
import com.board.task.repo.TaskRepository;
import com.board.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  private TaskRepository taskRepository;

  @Override
  public void deleteTask(Long id){
    taskRepository.deleteById(id);
  }

  @Override
  public TaskResponse replaceTask(TaskRequest request, Long id){
    Task task = this.getTask(id);
    task.setName(request.getName());
    task.setDescription(request.getDescription());
    task.setStatus(StatusEnum.Created);

    task = taskRepository.save(task);
    return TaskResponse.builder().description(task.getDescription()).name(task.getName()).status(task.getStatus()).id(task.getId()).build();  }

  @Override
  public TaskResponse updateTask(TaskRequest request, Long id){
    Task task = this.getTask(id);
    task.setName(updateField(request.getName(),task.getName()));
    task.setDescription(updateField(request.getDescription(), task.getDescription()));

    task = taskRepository.save(task);
    return TaskResponse.builder().description(task.getDescription()).name(task.getName()).status(task.getStatus()).id(task.getId()).build();
  }


  public Task getTask(Long id){
    return taskRepository.findById(id).orElseThrow(() -> {
      throw new TaskNotFoundException("Task not found.");
    });
  }

  private String updateField(String newValue, String oldValue){
    if(newValue == null){
      return oldValue;
    }
    return newValue;
  }

}
