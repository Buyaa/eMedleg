package com.mn.emedleg.entity;

import com.mn.emedleg.entity.CUser.Role;

public interface IUser {
	public String getUserName();
	public String getRegisteredDate();
	public boolean isEnabled();
	public String getRole();
}
