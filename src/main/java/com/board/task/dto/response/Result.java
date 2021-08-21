package com.board.task.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result{

  public String gender;

  public Map<String, String> name;

  public String email;

  public String phone;

  public String cell;

  public Map<String, String> login;

  public Map<String, String> picture;

  public String nat;
}