package com.board.task.service.impl;

import com.board.task.dto.request.BoardRequest;
import com.board.task.dto.request.TaskRequest;
import com.board.task.dto.response.BoardResponse;
import com.board.task.dto.response.TaskResponse;
import com.board.task.enums.StatusEnum;
import com.board.task.exception.BoardNotFoundException;
import com.board.task.model.Board;
import com.board.task.model.Task;
import com.board.task.repo.BoardRepository;
import com.board.task.repo.TaskRepository;
import com.board.task.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private TaskRepository taskRepository;

  @Override
  public BoardResponse createBoard(BoardRequest request){
    Board board = Board.builder().name(request.getName()).description(request.getDescription()).build();
    board = boardRepository.save(board);
    return BoardResponse.builder().description(board.getDescription()).name(board.getName()).id(board.getId()).build();
  }

  @Override
  public TaskResponse createTasks(TaskRequest request, Long id){
    Board board  = this.getBoard(id);

    Task task = Task.builder().description(request.getDescription()).name(request.getName()).board(board).user(request.getUser()).status(StatusEnum.Created).build();
    task = taskRepository.save(task);
    return TaskResponse.builder().description(task.getDescription()).name(task.getName()).status(task.getStatus()).id(task.getId()).user(task.getUser()).build();
  }

  @Override
  public Board getBoard(Long id){
    return boardRepository.findById(id).orElseThrow(() -> {
      throw new BoardNotFoundException("Board not found.");
    });
  }

  @Override
  public List<Board> getAllBoards(){
    return boardRepository.findAll();
  }

  @Override
  public void deleteBoard(Long id){
    boardRepository.deleteById(id);
  }



}
