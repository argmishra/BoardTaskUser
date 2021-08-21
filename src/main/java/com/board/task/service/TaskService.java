package com.board.task.service;

import com.board.task.dto.request.UserRequest;
import com.board.task.dto.request.TaskRequest;
import com.board.task.dto.response.TaskResponse;

public interface TaskService {

  void deleteTask(Long id);

  TaskResponse replaceTask(TaskRequest request, Long id);

  TaskResponse updateTask(TaskRequest request, Long id);

  void deleteTasksByUser(UserRequest request);

}
