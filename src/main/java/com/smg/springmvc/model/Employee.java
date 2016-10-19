package com.smg.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Size(min=5, max=250)
    @Column(name = "FULL_NAME", nullable = false)
    private String full_name;
    
    @Size(min=1, max=50)
    @Column(name = "USERNAME", nullable = false)
    private String username;
    
    @Size(min = 6, max = 15)
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    
    @Transient
    @Size(min=6, max=15)
    @Column(name = "RETYPE_PASSWORD", nullable = false)
    private String retype_password;

    private Date register_date;
    private Date last_logon_date;
    
    @Column(name = "ONLINE_STATUS", nullable = false)
    private Integer online_status;
    
    @Column(name = "PROFILE_PICTURE")
    private String profile_picture;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetype_password() {
		return retype_password;
	}

	public void setRetype_password(String retype_password) {
		this.retype_password = retype_password;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public Date getLast_logon_date() {
		return last_logon_date;
	}

	public void setLast_logon_date(Date last_logon_date) {
		this.last_logon_date = last_logon_date;
	}

	public Integer getOnline_status() {
		return online_status;
	}

	public void setOnline_status(Integer online_status) {
		this.online_status = online_status;
	}

	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}
	
	
}