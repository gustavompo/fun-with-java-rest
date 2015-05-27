package com.avenuecode.jchallenge.dao;

import java.util.List;

import com.avenuecode.jchallenge.domain.Order;

public class OrderDaoImpl extends PagedDao<Order> implements OrderDao {

	@Override
	public List<Order> listOrders(int limit, int offset) {
		return list(limit, offset);
	}

	@Override
	public Order getOrder(int orderId) {
		return get(orderId);
	}

	@Override
	public int saveOrder(Order order) {
		return save(order);
	}
	
	@Override
	public void updateOrder(Order order) {
		update(order);
	}

}
