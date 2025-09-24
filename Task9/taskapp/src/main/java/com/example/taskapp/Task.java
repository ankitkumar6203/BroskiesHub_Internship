package com.example.taskapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String description;

	public Task() {}
	public Task(Long id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	// getters & setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
}
