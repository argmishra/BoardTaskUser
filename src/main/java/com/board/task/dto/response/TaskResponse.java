package com.board.task.dto.response;

import com.board.task.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskResponse {

  private Long id;

  private String name;

  private String description;

  private StatusEnum status;

  private UserDetail userDetail;

  private String user;

}
