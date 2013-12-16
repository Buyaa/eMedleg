package com.mn.emedleg.dao;

import java.io.Serializable;
import java.util.List;

public interface IItemDAO<T> extends Serializable{
    public T save(T entity);
    public void delete(T entity);
    public void delete(long id);
    public T get(long id);
    public List<T> find(String hql);
    public void update(T entity);
    public List<T> listAll(long parentID);
    public List<T> listAll();
}
