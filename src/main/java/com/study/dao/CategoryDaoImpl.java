package com.study.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.study.entity.Category;

@Repository
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
		String hql = "FROM Category";
		TypedQuery<Category> query = session.createQuery(hql, Category.class);
		List<Category> list = query.getResultList();
		return list;
	}

	@Override
	public void save(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		
	}

}