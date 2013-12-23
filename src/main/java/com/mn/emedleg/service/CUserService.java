package com.mn.emedleg.service;

import java.util.List;
import com.mn.emedleg.entity.IUser;

public class CUserService extends AItemService<IUser> implements IUserService{

	@Override
	public boolean autenticate(String email, String password) {
		List<IUser> list=getDAO().find(email+"\n"+password);
		if (list.size()==1)
			return true;
		return false;
	}

	@Override
	public boolean chekEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}
}
