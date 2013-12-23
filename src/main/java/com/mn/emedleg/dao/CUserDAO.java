package com.mn.emedleg.dao;

import java.util.List;

import org.hibernate.Query;

import com.mn.emedleg.entity.IUser;

public class CUserDAO extends AItemDAO<IUser>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<IUser> find(String hql) {
		String []param = hql.split("\n");
		System.out.println(param[0]+"///"+param[1]);	
		Query query=getFactory().getCurrentSession().createQuery("from CUser where emailID=:emailID and password=:password")
		.setParameter("emailID", param[0])
		.setParameter("password", param[1]);
		return query.list();
	}
	
}
