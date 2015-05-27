package com.avenuecode.jchallenge.domain;

import java.util.Date;
import java.util.Set;

public class Order {
	
	private int orderId;
	private Date orderDate;
	private Set<OrderItem> orderItems;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


}
