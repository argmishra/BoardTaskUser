package com.board.task.exception;

public class TaskNotFoundException extends RuntimeException {

  public TaskNotFoundException(String msg){
    super(msg);
  }
}
