package com.mn.emedleg.dao;

import java.util.List;

import com.mn.emedleg.entity.cms.IComment;

public class CCommentDAO extends AItemDAO<IComment> {

	static final long serialVersionUID = 1L;
	public CCommentDAO() {
		super(IComment.class);
	}
	
	public CCommentDAO(Class<IComment> clazz) {
		super(clazz);
	}

	@Override
	public List<IComment> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}
}
