package com.mn.emedleg.dao;

import java.util.List;

import com.mn.emedleg.entity.cms.AContent;

public class CContentDAO extends AItemDAO<AContent>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CContentDAO() {
		super(AContent.class);
	}
	
	public CContentDAO(Class<AContent> clazz) {
		super(clazz);
	}

	@Override
	public List<AContent> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}
	//TODO: add published
	@SuppressWarnings("unchecked")
	@Override
	public List<AContent> listAll() {
		return (List<AContent>)getFactory().getCurrentSession().createQuery("from AContent a order by a.createdDate desc")
				.setFirstResult(0).setMaxResults(10).list();
	}

}
