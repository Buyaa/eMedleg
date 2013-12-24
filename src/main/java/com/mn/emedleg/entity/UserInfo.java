package com.mn.emedleg.entity;


public class UserInfo {
	private String name;
	private String registeredDate;
	private boolean enabled;
    private int role;
    public UserInfo(){}
	public UserInfo(String name, String registeredDate, boolean enabled, int role) {
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
	public int getRole() {
		return role;
	}
}
