package com.smg.springmvc.service;
 
import com.smg.springmvc.model.Employee;
 
public interface RegistrationService {
 
    void saveEmployee(Employee employee);
    public Employee findEmployeeByUsername(String username);
     
}