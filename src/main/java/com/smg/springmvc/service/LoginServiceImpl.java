package com.smg.springmvc.service;
 
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smg.springmvc.dao.LoginDao;
import com.smg.springmvc.model.Employee;
 
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
 
    @Autowired
    private LoginDao dao;
    
    public Employee findEmployeeByUsername(String username) {
    	return dao.findEmployeeByUsername(username);
    }
    
    public Employee findEmployeeByUsernamePassword(String username, String password) {
    	return dao.findEmployeeByUsernamePassword(username, password);
    }
    
    public void updateLoginDate(String username, Date loginDate){
    	dao.updateLoginDate(username, loginDate);
    }
    
 
}