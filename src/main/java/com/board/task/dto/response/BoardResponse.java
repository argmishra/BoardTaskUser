package com.board.task.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class BoardResponse {

  private Long id;

  private String name;

  private String description;
}
