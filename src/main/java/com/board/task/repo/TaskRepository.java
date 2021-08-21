package com.board.task.repo;

import com.board.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

  @Query(value = "delete FROM Task t where t.user = :user")
  @Transactional
  @Modifying
  void deleteAllByUser(String user);

}
