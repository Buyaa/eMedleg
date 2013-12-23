package com.mn.emedleg.service;

import java.util.List;

import com.mn.emedleg.dao.IItemDAO;

public abstract class AItemService <T> implements IItemService<T> {
	private IItemDAO<T> itemDAO;
	public void setItemDAO(IItemDAO<T> itemDAO){
		this.itemDAO=itemDAO;
	}
	public IItemDAO<T> getDAO(){
		return itemDAO;
	} 
	@Override
	public List<T> getAll(long parentID) {
		return itemDAO.listAll(parentID);
	}
	@Override
	public void delete(long id) {
		itemDAO.delete(id);
	}
	@Override
	public void delete(T entity) {
		itemDAO.delete(entity);	
	}
	@Override
	public void add(T entity) {
		itemDAO.save(entity);
	}
}
