package com.study.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

@Transactional
abstract  public class AbstractDao<E,K> {
	SessionFactory factory;
	abstract public E findById(K id);
	abstract public  List<E> findAll();
}
