package com.study.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.study.entity.Product;

@Repository
public class ProductDaoImpl extends AbstractDao<Product, Integer> {

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product ORDER BY productDate DESC";
		TypedQuery<Product> query = session.createQuery(hql,Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

}
