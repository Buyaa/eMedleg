package com.mn.emedleg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CUser {
	@Id
	@GeneratedValue
	private long id;
	private String userName;
	private String password;
	
	public CUser(){}
	public CUser(String userName) {
		this.userName = userName;
	}
	public CUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	
}
