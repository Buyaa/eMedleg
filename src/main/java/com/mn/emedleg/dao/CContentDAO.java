package com.mn.emedleg.dao;

import java.util.List;

import com.mn.emedleg.entity.cms.IContent;

public class CContentDAO extends AItemDAO<IContent>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CContentDAO() {
		super(IContent.class);
	}
	
	public CContentDAO(Class<IContent> clazz) {
		super(clazz);
	}

	@Override
	public List<IContent> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}
	//TODO: add published
	@SuppressWarnings("unchecked")
	@Override
	public List<IContent> listAll() {
		return (List<IContent>)getFactory().getCurrentSession().createQuery("from acontent a order by a.createdDate desc")
				.setFirstResult(0).setMaxResults(10).list();
	}

}
