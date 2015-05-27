package com.avenuecode.jchallenge.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.avenuecode.jchallenge.dao.OrderDao;
import com.avenuecode.jchallenge.domain.Order;
import com.avenuecode.jchallenge.dto.OrderDto;

@Component
@Path("/orders")
public class OrderResource {

	private OrderDao orderDao; 
	
	private ModelMapper modelMapper;
	
	@Inject
	public OrderResource(OrderDao orderDao, ModelMapper modelMapper){
		this.orderDao = orderDao;
		this.modelMapper = modelMapper;
	}

	@POST 
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_HTML})	
	@Transactional
	public Response create(Order order) {
		orderDao.saveOrder(order);
		return Response
				.status(Response.Status.CREATED)
				.build(); 		
	}
	
	@PUT @Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_HTML})	
	@Transactional
	public Response alter(@PathParam("id") int id, Order order) {
		order.setOrderId(id);
		orderDao.updateOrder(order);
		return Response
				.status(Response.Status.OK)
				.build(); 		
	}
	
	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	@Transactional
	public Response get(@PathParam("id") int id) {
		Order order = orderDao.getOrder(id);
		if(order == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build(); 
		} else {
			return Response
					.ok(modelMapper.map(order, OrderDto.class))
					.build();
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Transactional
	public Response list(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
		List<Order> orders = orderDao.listOrders(limit, offset);
		if(orders == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build(); 
		} else {
			return Response
					.ok(modelMapper.map(orders, new TypeToken<List<OrderDto>>() {}.getType()))
					.build();
		}	
	}
}
