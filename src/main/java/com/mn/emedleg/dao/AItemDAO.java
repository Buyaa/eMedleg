package com.mn.emedleg.dao;

import java.util.List;

import org.hibernate.SessionFactory;

public abstract class AItemDAO<T> implements IItemDAO<T> {

	private static final long serialVersionUID = 1L;
	private SessionFactory  factory; 
	private Class<T> clazz;
	public AItemDAO(){
	}
	public void setClazz(Class<T> clazz){
		this.clazz = clazz;
	}
	public AItemDAO(Class<T> clazz) {
        this.clazz = clazz;
    }
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	protected SessionFactory getFactory(){
		return this.factory;
	}
	@Override
	public T save(T entity) {
		factory.getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		factory.getCurrentSession().delete(entity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void delete(long id) {
		T entity =(T)factory.getCurrentSession().load(clazz, id);
		factory.getCurrentSession().delete(entity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public T get(long id) {
		return (T)factory.getCurrentSession().get(clazz, id);
//		factory.getCurrentSession().delete(entity);
	}

//	@Override
//	public List<T> find(String hql) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void update(T entity) {
		factory.getCurrentSession().update(entity);
	}
	//TODO
	//@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll(long parentID) {
		return null;//(List<T>)factory.getCurrentSession().createQuery("from "+clazz.getSimpleName()).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
		return (List<T>)factory.getCurrentSession().createQuery("from "+clazz.getSimpleName()).list();
	}
}
