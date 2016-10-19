package com.smg.springmvc.service;
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smg.springmvc.dao.TodolistDao;
import com.smg.springmvc.model.TodoList;
 
@Service("todolistService")
@Transactional
public class TodoListServiceImpl implements TodolistService {
 
    @Autowired
    private TodolistDao dao;
    
    public List<TodoList> getTodoList(String username) {
    	return dao.getTodoList(username);
    }
    
    public void updateTodoStatus(String username, Integer orderid, Integer status){
    	dao.updateTodoStatus(username, orderid, status);
    }
    
}