package com.mn.emedleg.entity;


public interface IUser {
	public String getUserName();
	public String getRegisteredDate();
	public boolean isEnabled();
	public int getRole();
}
