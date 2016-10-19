package com.smg.springmvc.dao;

import java.util.List;

import com.smg.springmvc.model.Employee;

public interface DashboardDao {
 
	public Long countRegistered();
	public Employee getFullName(String username);
	public List<Employee> getContacts(String username);
}