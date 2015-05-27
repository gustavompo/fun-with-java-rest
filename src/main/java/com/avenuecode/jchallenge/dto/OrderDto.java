package com.avenuecode.jchallenge.dto;

import java.util.Date;
import java.util.List;

public class OrderDto {
	
	private int id;
	private List<OrderItemDto> orderItems;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}
	
}
