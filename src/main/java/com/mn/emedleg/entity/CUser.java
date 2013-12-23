package com.mn.emedleg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CUser implements IUser{
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String password;
	private Date registeredDate;
	private String emailID;
	private boolean enabled;
	@Enumerated(EnumType.STRING)
    @Column(name = "userRole")
    private Role role;
    //  get and set
	public enum Role {
		ROLE_ADMIN, ROLE_PUBLICIST,ROLE_USER
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role.toString();
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public CUser(){}
	public CUser(String firstName) {
		this.firstName = firstName;
		this.registeredDate=new Date();
	}
	public CUser(String firstName, String password) {
		this.firstName = firstName;
		this.password = password;
		this.registeredDate=new Date();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return firstName+" "+lastName;
	}
	@Override
	public String getRegisteredDate() {
		return registeredDate.toString();
	}
}
