package com.study.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.entity.Order;
import com.study.entity.OrderDetail;

@Repository
public class OrderDaoImpl extends DAOAbstract<Order, Integer>{
	@Autowired
	OrderDetailDaoImpl oddao;
	@Override
	public Order findById(Integer id) {
		Session session = factory.getCurrentSession();
		Order order = session.get(Order.class, id);
		return order;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Order> findByCustomerId(String id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Order WHERE customer.id ="+"'"+id+"'";
		TypedQuery<Order> query = session.createQuery(hql,Order.class);
		List<Order> list = query.getResultList();
		return list;
	}

	public void saveWithOrderDetail(Order order, List<OrderDetail> details) {
		this.save(order);
		for(OrderDetail detail: details) {
			oddao.save(detail);
		}
	}
}
