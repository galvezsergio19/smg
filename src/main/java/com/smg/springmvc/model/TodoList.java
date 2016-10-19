package com.smg.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TODOLIST")
public class TodoList {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Column(name = "ORDERID")
    private int orderid;
    
    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "CREATE_DATE")
    private Date create_date;
    
    @Column(name = "DUE_DATE")
    private Date due_date;
    
    @Column(name = "PRIORITY")
    private int priority;
    
    @Column(name = "STATUS")
    private int status;
    
    @Column(name = "USERNAME")
    private String username;
    
    public TodoList(){}

	public TodoList(int id, int orderid, String title, Date create_date, Date due_date, int priority, int status,
			String username) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.title = title;
		this.create_date = create_date;
		this.due_date = due_date;
		this.priority = priority;
		this.status = status;
		this.username = username;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}