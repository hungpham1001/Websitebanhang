package com.study.Services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.study.dao.ProductDaoImpl;
import com.study.entity.Product;

@SessionScope
@Service
public class CartServices {
	@Autowired
	ProductDaoImpl pdao;
	Map<Integer, Product>  map = new HashMap<Integer, Product>();
	public void minus(int key) {
		Product item = map.get(key);
		int quantity = item.getQuantity()-1;
		item.setQuantity(quantity);
		map.replace(key, item);
	}
	public void plus(int key) {
		Product item = map.get(key);
		int quantity = item.getQuantity()+1;
		item.setQuantity(quantity);
		map.replace(key, item);
	}
	public void add(int id) {
		Product p = map.get(id);
		if(p == null) {
			p = pdao.findById(id);
			p.setQuantity(1);
		} else {
			int quantity = p.getQuantity();
			p.setQuantity(++quantity);
		}
		map.put(id, p);
	}
	public int getCountOfCart() {
		Collection<Product> products = this.getAllItems();
		int count = 0;
		for(Product p : products) {
			count += p.getQuantity();
		}
		return count;
	}
	public double getTotal() {
		Collection<Product> products = this.getAllItems();
		double total = 0;
		for(Product p : products) {
			total += p.getQuantity()*p.getUnitPrice()*(1-p.getDiscount());
		}
		return total;
	}
	public Collection<Product> getAllItems(){
		return map.values();
	}
	public void remove(Integer key) {
		map.remove(key);
	}
	public void clearBasket(){
		map.clear();
	}
}
