package com.avenuecode.jchallenge.dao;

import java.util.List;

import com.avenuecode.jchallenge.domain.Order;

public interface OrderDao {
	
	public List<Order> listOrders(int start);
	
	public Order getOrder(int orderId);
	
	public int saveOrder(Order order);
}
