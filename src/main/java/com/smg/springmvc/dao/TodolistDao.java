package com.smg.springmvc.dao;

import java.util.List;

import com.smg.springmvc.model.TodoList;
 
public interface TodolistDao {
	public List<TodoList> getTodoList(String username);
	public void updateTodoStatus(String username, Integer orderid, Integer status);
}