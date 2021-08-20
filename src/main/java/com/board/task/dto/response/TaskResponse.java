package com.board.task.dto.response;

import com.board.task.enums.StatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class TaskResponse {

  private Long id;

  private String name;

  private String description;

  private StatusEnum status;

  private String user;

}
