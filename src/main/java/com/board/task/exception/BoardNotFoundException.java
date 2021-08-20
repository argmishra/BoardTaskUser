package com.board.task.exception;

public class BoardNotFoundException extends RuntimeException {

  public BoardNotFoundException(String msg){
    super(msg);
  }

}