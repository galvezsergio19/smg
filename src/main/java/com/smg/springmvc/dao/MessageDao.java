package com.smg.springmvc.dao;

import java.util.List;

import com.smg.springmvc.model.Message;
 
public interface MessageDao {
 
	public void saveMessage(Message message);
	public Long countMessage();
	public List<Message> getMessage();
	public List<Message> getMessageByContact(String username, String recepient);
	public void updateOnlineStatus(String username, Integer status);
	public void deleteMessage();
}