package com.mn.emedleg.entity;

import java.util.Date;

import com.mn.emedleg.entity.CUser.Role;

public class UserInfo {
	private String name;
	private String registeredDate;
	private boolean enabled;
    private String role;
    public UserInfo(){}
	public UserInfo(String name, String registeredDate, boolean enabled, String role) {
		this.name = name;
		this.registeredDate = registeredDate;
		this.enabled = enabled;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public String getRegisteredDate() {
		return registeredDate;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public String getRole() {
		return role;
	}
}
