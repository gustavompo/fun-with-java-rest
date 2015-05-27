package com.avenuecode.jchallenge.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class PagedDao<T>{
	public static int MAXIMUM_LIMIT = 100;
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Lists items given a first index indicator and the page limit size
	 * @param limit - The limit of results
	 * @param offset - The starting point to return
	 * @return list of items of type T
	 */
	@SuppressWarnings("unchecked")
	protected List<T> list(int limit, int offset){
		return sessionFactory
				.getCurrentSession()
				.createCriteria(classFromGenerics())
				.setFirstResult(offset)
				.setMaxResults(fitLimit(limit))
				.list();
	}
	
	/**
	 * Returns the element with the informed id of type T
	 * @param id - The id of the element in the table
	 * @return the element with the informed id of type T
	 */
	@SuppressWarnings("unchecked")
	protected T get(int id){
		return (T) sessionFactory
				.getCurrentSession()
				.get(classFromGenerics(), id);
	}
	
	/**
	 * Saves the registry
	 * @param value - the item to be saved
	 * @return the id of the saved item
	 */
	protected int save(T value){
		return (int)sessionFactory
				.getCurrentSession()
				.save(value);
	}
	
	/**
	 * Updates the registry
	 * @param value - the item to be saved
	 * @return the id of the saved item
	 */
	protected void update(T value){
		sessionFactory
			.getCurrentSession()
			.update(value);
	}
	
	
	/**
	 * @return the class object of type T
	 */
	@SuppressWarnings("unchecked")
	private Class<T> classFromGenerics(){
		return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	private int fitLimit(int limit){
		return (limit == 0 || limit > MAXIMUM_LIMIT) ? MAXIMUM_LIMIT : limit;
	}
	
}
