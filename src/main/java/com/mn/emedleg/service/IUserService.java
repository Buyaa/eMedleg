package com.mn.emedleg.service;

import com.mn.emedleg.entity.IUser;

public interface IUserService extends IItemService<IUser>{
	public IUser autenticate(String email, String password);
	public boolean chekEmail(String email);
	public IUser getUser(long id);
}
