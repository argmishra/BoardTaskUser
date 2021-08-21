package com.board.task.convertor;


import com.board.task.dto.request.TaskRequest;
import com.board.task.dto.response.TaskResponse;
import com.board.task.dto.response.UserDetail;
import com.board.task.enums.StatusEnum;
import com.board.task.model.Board;
import com.board.task.model.Task;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TaskConverter {

  public static TaskResponse toTaskResponse(Task task) {
    return TaskResponse.builder().description(task.getDescription()).name(task.getName()).status(task.getStatus()).id(task.getId()).user(task.getUser()).build();
  }

  public static Task toTask(TaskRequest request, Board board) {
    return Task.builder().description(request.getDescription()).name(request.getName()).board(board).user(request.getUser()).status(StatusEnum.Created).build();
  }

  public static TaskResponse toTaskResponseWithUserDetails(Task task, UserDetail userDetail) {
    return TaskResponse.builder().description(task.getDescription()).id(task.getId()).name(task.getName()).status(task.getStatus()).userDetail(userDetail).build();
  }

}
