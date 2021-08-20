package com.board.task.controller;

import com.board.task.dto.request.TaskRequest;
import com.board.task.dto.response.TaskResponse;
import com.board.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("tasks")
@Slf4j
@Validated
public class TaskController {

  @Autowired
  private TaskService taskService;

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable Long id){
    log.info("Delete task by id {}", id);
    taskService.deleteTask(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity<TaskResponse> replaceTask(@RequestBody @Valid TaskRequest request, @PathVariable Long id){
    log.info("Replace task by {}", id);
    return new ResponseEntity(taskService.replaceTask(request, id), HttpStatus.OK);
  }


  @PatchMapping("{id}")
  public ResponseEntity<TaskResponse> updateTask(@RequestBody @Valid  TaskRequest request, @PathVariable Long id){
    log.info("Replace task by {}", id);
    return new ResponseEntity(taskService.updateTask(request, id), HttpStatus.OK);
  }



}
