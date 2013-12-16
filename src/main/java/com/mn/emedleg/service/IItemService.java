package com.mn.emedleg.service;

import java.util.List;

public interface IItemService<T> {
	public List<T> getAll(long parentID);
	public void delete(long id);
	public void delete(T entity);
	public void add(T entity);
}
