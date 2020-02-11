package com.study.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.study.entity.Customer;

@Repository
public class CustomerDaoImpl extends DAOAbstract<Customer, String>{

	public Customer findByEmail(String email) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Customer WHERE email LIKE :c";
		try {
			TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
			query.setParameter("c", email);
			Customer cust = query.getSingleResult();
			return cust;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<Customer> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Customer";
		TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
		List<Customer> list = query.getResultList();
		return list;
	}
	@Override
	public Customer findById(String id) {
		Session session = factory.getCurrentSession();
		try {
			Customer cus = session.get(Customer.class, id);
			return cus;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public void save(Customer entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
	}
	@Override
	public void update(Customer entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	@Override
	public void delete(Customer entity) {
		// TODO Auto-generated method stub
		
	}
	
}
