package com.board.task.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Map;

@Setter
@Getter
public class UserRequest {

  @NotEmpty
  private Date date;

  @NotEmpty
  private Map<String, String> data;

}
