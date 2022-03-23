package com.mac.todoapp.service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TaskInDTO {

	private String title;
	private String description;
	private LocalDateTime eta; // Fecha de finalizaciòn estimada.
}
