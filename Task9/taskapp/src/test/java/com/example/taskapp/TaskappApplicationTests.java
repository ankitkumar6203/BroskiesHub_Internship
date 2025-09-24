package com.example.taskapp;

import com.example.taskapp.controller.TaskController;
import com.example.taskapp.model.Task;
import com.example.taskapp.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaskService taskService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testGetAllTasks() throws Exception {
		Task task1 = new Task(1L, "Task 1", "Desc 1");
		Task task2 = new Task(2L, "Task 2", "Desc 2");

		when(taskService.getAllTasks()).thenReturn(Arrays.asList(task1, task2));

		mockMvc.perform(get("/tasks"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.size()").value(2));
	}

	@Test
	void testGetTaskById() throws Exception {
		Task task = new Task(1L, "Sample", "Test");

		when(taskService.getTaskById(1L)).thenReturn(Optional.of(task));

		mockMvc.perform(get("/tasks/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("Sample"));
	}

	@Test
	void testCreateTask() throws Exception {
		Task task = new Task(1L, "New Task", "New Desc");

		when(taskService.saveTask(any(Task.class))).thenReturn(task);

		mockMvc.perform(post("/tasks")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(task)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("New Task"));
	}

	@Test
	void testUpdateTask() throws Exception {
		Task updated = new Task(1L, "Updated Task", "Updated Desc");

		when(taskService.updateTask(Mockito.eq(1L), any(Task.class))).thenReturn(Optional.of(updated));

		mockMvc.perform(put("/tasks/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updated)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("Updated Task"));
	}

	@Test
	void testDeleteTask() throws Exception {
		mockMvc.perform(delete("/tasks/1"))
				.andExpect(status().isNoContent());
	}
}
