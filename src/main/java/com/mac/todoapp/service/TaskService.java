package com.mac.todoapp.service;

import org.springframework.stereotype.Service;

import com.mac.todoapp.mapper.TaskInDTOToTask;
import com.mac.todoapp.persistence.entity.Task;
import com.mac.todoapp.persistence.repository.TaskRepository;
import com.mac.todoapp.service.dto.TaskInDTO;

@Service
public class TaskService {

	private final TaskRepository repository;
	private final TaskInDTOToTask mapper;

	public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public Task createTask(TaskInDTO taskInDTO) {
		return this.repository.save(mapper.map(taskInDTO));
	}
}
