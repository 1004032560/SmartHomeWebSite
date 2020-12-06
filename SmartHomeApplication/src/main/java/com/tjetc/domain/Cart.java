package com.tjetc.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	private double total;
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	
	public void addCart(CartItem cartItem) {
		Product product = cartItem.getProduct();
		Integer id = product.getId();
		CartItem item = map.get(id);
		if (item==null) {
			//购物车没有该购物项，直接添加
			map.put(id, cartItem);
		}else {
			item.setCount(item.getCount()+cartItem.getCount());
		}
		setTotal(getTotal()+cartItem.getSubtotal());
	}
	
	public void removeCart(int id) {
		CartItem cartItem = map.remove(id);
		setTotal(getTotal()-cartItem.getSubtotal());
	}
	
	public void clearCart() {
		map.clear();
		setTotal(0);
	}
	
}
