package com.board.task.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class BoardRequest {

  @NotEmpty
  private String name;

  @NotBlank
  private String description;

}
