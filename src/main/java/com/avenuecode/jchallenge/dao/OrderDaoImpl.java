package com.avenuecode.jchallenge.dao;

import java.util.List;

import com.avenuecode.jchallenge.domain.Order;

public class OrderDaoImpl extends PagedDao<Order> implements OrderDao {

	@Override
	public List<Order> listOrders(int start) {
		return list(start);
	}

	@Override
	public Order getOrder(int orderId) {
		return (Order)get(orderId);
	}

	@Override
	public int saveOrder(Order order) {
		return save(order);
	}

}
