package com.avenuecode.jchallenge.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class PagedDao<T>{
	public static int PAGE_SIZE = 10;
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Lists items given a first index indicator and the page limit size
	 * @param first - The start index
	 * @return list of items of type T
	 */
	@SuppressWarnings("unchecked")
	protected List<T> list(int first){
		Session session = sessionFactory.openSession();
		
		return session
				.createCriteria(classFromGenerics())
				.setFirstResult(first)
				.setMaxResults(PAGE_SIZE)
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
		Session session = sessionFactory.getCurrentSession();
		int saved = (int)session.save(value);
		return saved;
	}
	
	/**
	 * @return the class object of type T
	 */
	@SuppressWarnings("unchecked")
	private Class<T> classFromGenerics(){
		return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
}
