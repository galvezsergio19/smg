package com.smg.springmvc.service;
 
import java.util.List;

import com.smg.springmvc.model.Employee;
import com.smg.springmvc.model.Message;
 
public interface MessageService {
 
	public void saveMessage(Message message);
	public List<Message> getMessage();
	public List<Message> getMessageByContact(String username, String recepient);
	public Employee getFullName(String username);
	public void updateOnlineStatus(String username, Integer status);
	public void deleteMessage();
	public List<Employee> getContacts(String username);
    
}