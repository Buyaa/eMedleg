package com.mn.emedleg.service;

import java.util.List;
import com.mn.emedleg.entity.IUser;

public class CUserService extends AItemService<IUser> implements IUserService{

	@Override
	public IUser autenticate(String email, String password) {
		List<IUser> list=getDAO().find(email+"\n"+password);
		if (list.size()==1)
			return list.get(0);
		return null;
	}

	@Override
	public boolean chekEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IUser getUser(long id) {
		return getDAO().get(id);
	}
}
