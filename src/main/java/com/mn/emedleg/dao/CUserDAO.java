package com.mn.emedleg.dao;

import java.util.List;


import org.hibernate.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.mn.emedleg.entity.CUser;


public class CUserDAO extends AItemDAO<CUser> implements IUserDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CUserDAO() {
		super(CUser.class);
	}


	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CUser user = this.findByName(username);
		if (null == user) {
			throw new UsernameNotFoundException("The user with name " + username + " was not found");
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public CUser findByName(String name) {
		 List<CUser> users=null;
		try{
		Query query=getFactory().getCurrentSession().createQuery("from cuser where emailID = :email");
		query.setParameter("email", name);
		 users = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if (users.isEmpty()) {
			return null;
		}

		return users.iterator().next();
	}

    @SuppressWarnings("unchecked")
	@Override
	public List<CUser> find(String hql) {
		Query query=getFactory().getCurrentSession().createQuery(hql);
		return query.list();
	}
}
