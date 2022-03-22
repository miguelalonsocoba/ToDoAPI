package com.mac.todoapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mac.todoapp.persistence.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
