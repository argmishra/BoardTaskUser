package com.board.task.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class TaskRequest {

  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @NotBlank
  private String user;

}
