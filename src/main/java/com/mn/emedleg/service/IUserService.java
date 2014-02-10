package com.mn.emedleg.service;

import com.mn.emedleg.entity.IUser;

public interface IUserService extends IItemService<IUser>{
	public boolean chekEmail(String email);
	public IUser getUser(long id);
	public IUser getUser(String username);
}
