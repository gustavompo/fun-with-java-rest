package com.avenuecode.jchallenge.rest;

import java.util.List;

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

import com.avenuecode.jchallenge.dao.ProductDao;
import com.avenuecode.jchallenge.domain.Product;

@Component
@Path("/products")
public class ProductResource {

	@Autowired
	private ProductDao productDao; 

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Transactional
	public Response get() {
		List<Product> products = productDao.listProducts(0);
		if(products == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build(); 
		} else {
			return Response
					.ok(products)
					.build();
		}	
	}
	
	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	@Transactional
	public Response get(@PathParam("id") int id) {
		Product product = productDao.getProduct(id);
		if(product == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build(); 
		} else {
			return Response
					.ok(product)
					.build();
		}	
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Transactional
	public Response save(Product product) {
		int saved = productDao.saveProduct(product);
		return Response
				.ok(saved)
				.build();
		
	}	
}
