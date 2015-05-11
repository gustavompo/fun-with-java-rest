package com.avenuecode.jchallenge.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.avenuecode.jchallenge.dao.OrderDao;
import com.avenuecode.jchallenge.domain.Order;

@Component
@Path("/orders")
public class OrderResource {

	@Autowired
	private OrderDao orderDao; 

	@POST 
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_HTML})	
	@Transactional
	public Response create(Order order) {
		int created = orderDao.saveOrder(order);
		return Response
				.status(Response.Status.CREATED)
				.entity(created)
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
					.ok(order)
					.build();
		}	
	}	
}
