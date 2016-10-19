package com.smg.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.smg.springmvc.model.TodoList;
 
@Repository("todolistDao")
public class TodolistDaoImpl extends AbstractDao<Integer, TodoList> implements TodolistDao {
	
	private String UPDATE_TODO_STATUS = "update Todolist set status = :status "
			+  "where username = :username and orderid = :orderid " ;
	
	@SuppressWarnings("unchecked")
	public List<TodoList> getTodoList(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        criteria.addOrder(Order.asc("orderid"));
        criteria.addOrder(Order.asc("create_date"));
        return (List<TodoList>) criteria.list();
    }
	
	public void updateTodoStatus(String username, Integer orderid, Integer status) {
		
        Query query = getSession().createSQLQuery(UPDATE_TODO_STATUS);
        query.setInteger("status", status);
        query.setString("username", username);
        query.setInteger("orderid", orderid);
        query.executeUpdate();
    }
 
}