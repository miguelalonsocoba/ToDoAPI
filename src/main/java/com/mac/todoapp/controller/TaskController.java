package com.mac.todoapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mac.todoapp.persistence.entity.Task;
import com.mac.todoapp.persistence.entity.TaskStatus;
import com.mac.todoapp.service.TaskService;
import com.mac.todoapp.service.dto.TaskInDTO;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping
	public Task createTask(@RequestBody TaskInDTO taskInDTO) {
		return this.taskService.createTask(taskInDTO);
	}

	@GetMapping
	public List<Task> findAll() {
		return this.taskService.findAll();
	}

	@GetMapping(value = "/status/{status}")
	public List<Task> findAllByTaskStatus(@PathVariable(value = "status") TaskStatus status) {
		return this.taskService.findAllByTaskStatus(status);
	}

	@PatchMapping(value = "/mark_as_finished/{id}")
	public ResponseEntity<Void> markAsFinished(@PathVariable(value = "id") Long id) {
		this.taskService.markTaskAsFinished(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
		this.taskService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
