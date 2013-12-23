package com.mn.emedleg.service;

import com.mn.emedleg.entity.IUser;

public interface IUserService extends IItemService<IUser>{
	public boolean autenticate(String email, String password);
	public boolean chekEmail(String email);
}
