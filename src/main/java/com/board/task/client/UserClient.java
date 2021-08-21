package com.board.task.client;

import com.board.task.dto.response.UserDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class UserClient {

  private WebClient webClient = null;

  public static ResponseEntity<UserDetail> getUserDetail() {
    WebClient webClientBuilder = WebClient.create();

    return webClientBuilder
        .get()
        .uri("https://randomuser.me/api/")
        .retrieve()
        .toEntity(UserDetail.class)
        .block();
  }
}