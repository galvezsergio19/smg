package com.smg.springmvc.dao;

import java.util.Date;

import com.smg.springmvc.model.Employee;
 
public interface LoginDao {
 
    public Employee findEmployeeByUsername(String username);
    public Employee findEmployeeByUsernamePassword(String username, String password);
    public void updateLoginDate(String username, Date loginDate);
}