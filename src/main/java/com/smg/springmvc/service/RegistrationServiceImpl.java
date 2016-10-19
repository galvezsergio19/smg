package com.smg.springmvc.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.smg.springmvc.dao.RegistrationDao;
import com.smg.springmvc.model.Employee;
 
@Service("registrationService")
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
 
    @Autowired
    private RegistrationDao dao;

    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }
    
    public Employee findEmployeeByUsername(String username) {
        return dao.findEmployeeByUsername(username);
    }
 
}