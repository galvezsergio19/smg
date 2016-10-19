package com.smg.springmvc.dao;

import com.smg.springmvc.model.Employee;
 
public interface RegistrationDao {
 
    void saveEmployee(Employee employee);
    public Employee findEmployeeByUsername(String username);
}