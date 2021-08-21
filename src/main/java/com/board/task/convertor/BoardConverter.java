package com.board.task.convertor;


import com.board.task.dto.request.BoardRequest;
import com.board.task.dto.response.BoardResponse;
import com.board.task.dto.response.TaskResponse;
import com.board.task.model.Board;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class BoardConverter {

  public static BoardResponse toBoardResponse(Board board) {
   return BoardResponse.builder().description(board.getDescription()).name(board.getName()).id(board.getId()).build();
  }

  public static Board toBoard(BoardRequest request) {
    return Board.builder().name(request.getName()).description(request.getDescription()).build();
  }

  public static BoardResponse toBoardResponseWithTask(Board board, List<TaskResponse> taskList) {
    return BoardResponse.builder().id(board.getId()).name(board.getName()).description(board.getDescription()).tasks(taskList).build();
  }
}
