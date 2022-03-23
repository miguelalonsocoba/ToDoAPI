package com.mac.todoapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mac.todoapp.persistence.entity.Task;
import com.mac.todoapp.persistence.entity.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long> {

	public List<Task> findByTaskStatus(TaskStatus taskStatus);

	@Modifying // Indicates that is an update query.
	@Query(value = "UPDATE TASK SET FINISHED = true WHERE ID = :id", nativeQuery = true)
	public void markTaskAsFinished(@Param("id") Long id);

}
