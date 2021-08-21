package com.board.task.service;

import com.board.task.dto.request.BoardRequest;
import com.board.task.dto.request.TaskRequest;
import com.board.task.dto.response.BoardResponse;
import com.board.task.dto.response.TaskResponse;
import com.board.task.model.Board;

import java.util.List;


public interface BoardService {

  BoardResponse createBoard(BoardRequest request);

  TaskResponse createTasks(TaskRequest request, Long id);

  BoardResponse getBoard(Long id);

  List<Board> getAllBoards();

  void deleteBoard(Long id);

}
