package com.board.task.controller;

import com.board.task.dto.request.UserRequest;
import com.board.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@Slf4j
@Validated
@RequestMapping("webhooks")
public class WebHooksController {

  @Autowired
  private TaskService taskService;

  @PostMapping("user-deleted")
  public ResponseEntity<Void> deleteTasksByUser(@RequestBody @Valid UserRequest request){
    log.info("Deleting task for user");
    taskService.deleteTasksByUser(request);
    return ResponseEntity.noContent().build();
  }
}
