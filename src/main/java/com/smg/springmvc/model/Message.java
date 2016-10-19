package com.smg.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="MESSAGE")
public class Message {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Column(name = "USERNAME")
    private String username;
    
    @Transient
    private String full_name;
    
    @Column(name = "MESSAGE")
    private String message;
    
    @Column(name = "CREATEDATE")
    private Date createdate;
    
    @Column(name = "RECEPIENT")
    private String recepient;
    
    public Message(){}
    
	public Message(int id, String username, String full_name, String message, Date createdate, String recepient) {
		super();
		this.id = id;
		this.username = username;
		this.full_name = full_name;
		this.message = message;
		this.createdate = createdate;
		this.recepient = recepient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getRecepient() {
		return recepient;
	}

	public void setRecepient(String recepient) {
		this.recepient = recepient;
	}
	
    
}