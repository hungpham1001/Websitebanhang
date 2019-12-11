package com.study.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.study.entity.Product;
@Repository
public class ProductDaoImpl2 extends DAOAbstract<Product, Integer> {

	@Override
	public Product findById(Integer id) {
		Session session = factory.getCurrentSession();
		Product entity = session.get(Product.class, id);
		return entity;
	}

	@Override
	public List<Product> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product";
		TypedQuery<Product> query = session.createQuery(hql,Product.class);
		List<Product> list = query.getResultList();
		return list;
	}
}
