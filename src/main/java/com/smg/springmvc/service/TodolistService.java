package com.smg.springmvc.service;

import java.util.List;

import com.smg.springmvc.model.TodoList;

public interface TodolistService {
 
	public List<TodoList> getTodoList(String username);
	public void updateTodoStatus(String username, Integer orderid, Integer status);
	
}