 package com.study.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.study.entity.Category;
import com.study.entity.Product;

@Repository
public class ProductDaoImpl extends DAOAbstract<Product, Integer> {

	@Override
	public Product findById(Integer id) {
		Session session = factory.getCurrentSession();
		Product p = session.get(Product.class, id);
		return p;
	}

	@Override
	public List<Product> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product ORDER BY productDate DESC";
		TypedQuery<Product> query = session.createQuery(hql,Product.class);
		List<Product> list = query.getResultList();
		return list;
	}
	public List<String> findByIds(String Ids){
		Session session = factory.getCurrentSession();
		String hql = "SELECT DISTINCT p.image FROM Product AS p WHERE p.id IN("+Ids+")";
		TypedQuery<String> query = session.createQuery(hql, String.class);
		List<String> list = query.getResultList();
		return list;
	}
	public List<Product> findByCategoryId(Category cate){
		Session session = factory.getCurrentSession();
		String hql = "FROM Product WHERE categoryId = "+cate.getId();
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setMaxResults(8);
		List<Product> list = query.getResultList();
		return list;
	}
	public List<Product> findTheSameProducts(){
		Session session = factory.getCurrentSession();
		String hql = "FROM Product ORDER BY productDate DESC";
		TypedQuery<Product> query = session.createQuery(hql,Product.class);
		query.setFirstResult((int)(Math.random()*(this.findAll().size()-5)));
		query.setMaxResults(5);
		List<Product> list = query.getResultList();
		return list;
	}

	public List<Product> findTop10() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product ORDER BY productDate DESC";
		TypedQuery<Product> query = session.createQuery(hql,Product.class);
		query.setMaxResults(10);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public int  pageSize() {
		List<Product> list = this.findAll();
		return list.size();
	}
}
