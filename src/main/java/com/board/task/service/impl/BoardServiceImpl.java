package com.board.task.service.impl;

import com.board.task.client.UserClient;
import com.board.task.convertor.BoardConverter;
import com.board.task.convertor.TaskConverter;
import com.board.task.dto.request.BoardRequest;
import com.board.task.dto.request.TaskRequest;
import com.board.task.dto.response.BoardResponse;
import com.board.task.dto.response.Result;
import com.board.task.dto.response.TaskResponse;
import com.board.task.dto.response.UserDetail;
import com.board.task.exception.BoardNotFoundException;
import com.board.task.model.Board;
import com.board.task.model.Task;
import com.board.task.repo.BoardRepository;
import com.board.task.repo.TaskRepository;
import com.board.task.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    Board board = BoardConverter.toBoard(request);
    board = boardRepository.save(board);
    return BoardConverter.toBoardResponse(board);
  }

  @Override
  public TaskResponse createTasks(TaskRequest request, Long id){
    Board board  = this.getBoardById(id);

    Task task = TaskConverter.toTask(request, board);
    task = taskRepository.save(task);
    return TaskConverter.toTaskResponse(task);
  }

  @Override
  public BoardResponse getBoard(Long id){
    Board board = this.getBoardById(id);

    List<Result> users = this.fetchUserDetail();

    String userFromService =null;
    for(Result result : users){
      userFromService = result.getLogin().get("uuid");
    }

    List<TaskResponse> taskList = new ArrayList<>();
    for (Task task : board.getTasks()){
      UserDetail userDetail = null;
      if(task.getUser().equals(userFromService)) {
        userDetail = new UserDetail();
        userDetail.setResults(users);
      }

      TaskResponse taskResponse = TaskConverter.toTaskResponseWithUserDetails(task, userDetail);
      taskList.add(taskResponse);
    }

    return BoardConverter.toBoardResponseWithTask(board, taskList);
  }

  private List<Result> fetchUserDetail() {
    ResponseEntity<UserDetail> userDetail = UserClient.getUserDetail();
    return userDetail.getBody().getResults();
  }

  @Override
  public List<Board> getAllBoards(){
    return boardRepository.findAll();
  }

  @Override
  public void deleteBoard(Long id){
    boardRepository.deleteById(id);
  }

  private Board getBoardById(Long id){
    return boardRepository.findById(id).orElseThrow(() -> {
      throw new BoardNotFoundException("Board not found.");
    });
  }

}
