package com.mn.emedleg.service;

import java.util.Hashtable;
import java.util.List;

import com.mn.emedleg.entity.CUser;
import com.mn.emedleg.entity.IUser;

public class CUserService extends AItemService<IUser> implements IUserService{
	Hashtable<Long, CUser> users;
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

	@Override
	public IUser getUser(String username) {
		List <IUser> users= getDAO().find("from CUser where emailID ='"+username+"'");
		if(users.size()>0)
			return users.get(0);
		else return null;
	}
}
