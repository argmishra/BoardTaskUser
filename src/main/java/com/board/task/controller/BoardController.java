package com.board.task.controller;

import com.board.task.dto.request.BoardRequest;
import com.board.task.dto.request.TaskRequest;
import com.board.task.dto.response.BoardResponse;
import com.board.task.dto.response.TaskResponse;
import com.board.task.model.Board;
import com.board.task.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("boards")
@Slf4j
@Validated
public class BoardController {

  @Autowired
  private BoardService boardService;

  @PostMapping
  public ResponseEntity<BoardResponse> createBoard(@RequestBody @Valid  BoardRequest request){
    log.info("Creating board");
    return new ResponseEntity(boardService.createBoard(request), HttpStatus.CREATED);
  }

  @PostMapping("{id}/tasks")
  public ResponseEntity<TaskResponse> createTasks(@RequestBody @Valid  TaskRequest request, @PathVariable Long id){
    log.info("Creating tasks for board id {}", id);
    return new ResponseEntity(boardService.createTasks(request, id), HttpStatus.CREATED);
  }

  @GetMapping("{id}")
  public ResponseEntity<BoardResponse> getBoard(@PathVariable Long id){
    log.info("Get board by id {}", id);
    return new ResponseEntity(boardService.getBoard(id), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Board>> getAllBoards(){
    log.info("Get all boards");
    return new ResponseEntity(boardService.getAllBoards(), HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteBoard(@PathVariable Long id){
    log.info("Delete board by id {}", id);
    boardService.deleteBoard(id);
    return ResponseEntity.noContent().build();
  }

}