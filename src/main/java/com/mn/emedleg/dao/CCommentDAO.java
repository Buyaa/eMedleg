package com.mn.emedleg.dao;

import java.util.List;

import com.mn.emedleg.entity.cms.CComment;

public class CCommentDAO extends AItemDAO<CComment> {

	static final long serialVersionUID = 1L;
	public CCommentDAO() {
		super(CComment.class);
	}
	
	public CCommentDAO(Class<CComment> clazz) {
		super(clazz);
	}

	@Override
	public List<CComment> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}
}
