package com.mn.emedleg.dao;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mn.emedleg.entity.CUser;


public interface IUserDao extends IItemDAO<CUser>, UserDetailsService {

	public CUser findByName(String name);

}
