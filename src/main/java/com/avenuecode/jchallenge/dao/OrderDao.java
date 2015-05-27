package com.avenuecode.jchallenge.dao;

import java.util.List;

import com.avenuecode.jchallenge.domain.Order;

public interface OrderDao {
	
	public List<Order> listOrders(int limit, int offset);
	
	public Order getOrder(int orderId);
	
	public int saveOrder(Order order);
	
	public void updateOrder(Order order);
}
