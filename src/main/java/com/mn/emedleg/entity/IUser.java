package com.mn.emedleg.entity;

import java.io.Serializable;


public interface IUser extends Serializable{
	public String getUserName();
	public String getRegisteredDate();
	public boolean isEnabled();
	public int getRole();
}
