package com.study.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.study.entity.Category;

public class CategoryDaoImpl extends DAOAbstract<Category, Integer> {

	@Override
	public Category findById(Integer id) {
		Session session = factory.getCurrentSession();
		Category entity = session.get(Category.class, id);
		return entity;
	}

	@Override
	public List<Category> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FORM Category";
		TypedQuery<Category> query = session.createQuery(hql, Category.class);
		List<Category> list = query.getResultList();
		return list;
	}
	
}
