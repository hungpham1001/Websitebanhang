package com.study.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
@Transactional
public abstract class DAOAbstract<E,K> {
	@Autowired
	SessionFactory factory;
	abstract public E findById (K id);
	abstract public List<E> findAll();
}
