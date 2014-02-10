package com.mn.emedleg.dao;

import java.util.List;

import com.mn.emedleg.entity.cms.IMenu;

public class CMenuDAO extends AItemDAO<IMenu>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CMenuDAO() {
		super(IMenu.class);
	}
	public CMenuDAO(Class<IMenu> clazz) {
		super(clazz);
	}

	@Override
	public List<IMenu> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<IMenu> listAll() {
		return (List<IMenu>)getFactory().getCurrentSession().createQuery("from amenu where parent is null").list();
	}
}
