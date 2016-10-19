package com.smg.springmvc.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smg.springmvc.dao.DashboardDao;
import com.smg.springmvc.dao.MessageDao;
import com.smg.springmvc.model.Employee;
import com.smg.springmvc.model.Message;
 
@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService {
 
    @Autowired
    private MessageDao dao;
    
    @Autowired
    private DashboardDao dashboardDao;

	public void saveMessage(Message message){
		dao.saveMessage(message);
	}

	public List<Message> getMessage(){
		return dao.getMessage();
	}
	
	public List<Message> getMessageByContact(String username, String recepient){
		return dao.getMessageByContact(username, recepient);
	}
	
	public Employee getFullName(String username){
		return dashboardDao.getFullName(username);
	}
	
	public void updateOnlineStatus(String username, Integer status) {
		dao.updateOnlineStatus(username, status);
	}
	
	public void deleteMessage(){
		dao.deleteMessage();
	}
	
	public List<Employee> getContacts(String username){
		return dashboardDao.getContacts(username);
	}
 
}