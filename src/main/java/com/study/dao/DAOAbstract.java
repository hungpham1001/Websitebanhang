package com.study.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
@Transactional
public abstract class DAOAbstract<E,K> {
	@Autowired
	SessionFactory factory;
	abstract public E findById (K id);
	abstract public List<E> findAll();
	public void save(E entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
	};
	public void update(E entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	};
	public void delete(E entity) {
		Session session = factory.getCurrentSession();
		session.delete(entity);
	};
}
