package com.mac.todoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mac.todoapp.exceptions.ToDoExceptions;
import com.mac.todoapp.mapper.TaskInDTOToTask;
import com.mac.todoapp.persistence.entity.Task;
import com.mac.todoapp.persistence.entity.TaskStatus;
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

	public List<Task> findAll() {
		return this.repository.findAll();
	}

	public List<Task> findAllByTaskStatus(TaskStatus status) {
		return this.repository.findByTaskStatus(status);
	}

	@Transactional // Indica que es un proceso transacional.
	public void markTaskAsFinished(Long id) {
		Optional<Task> optionalTask = this.repository.findById(id);
		if (optionalTask.isEmpty()) {
			throw new ToDoExceptions("Task not found. ", HttpStatus.NOT_FOUND);
		}
		this.repository.markTaskAsFinished(id);
	}

	public void deleteById(Long id) {
		Optional<Task> optionalTask = this.repository.findById(id);
		if (optionalTask.isEmpty()) {
			throw new ToDoExceptions("Task not found. ", HttpStatus.NOT_FOUND);
		}
		this.repository.deleteById(id);
	}
}
