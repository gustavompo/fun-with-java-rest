package com.avenuecode.jchallenge.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import com.avenuecode.jchallenge.dao.ProductDao;
import com.avenuecode.jchallenge.domain.Product;
import com.avenuecode.jchallenge.dto.ProductDto;

@Component
@Path("/products")
public class ProductResource {

	private ProductDao productDao; 
	private ModelMapper modelMapper;
	
	@Inject
	public ProductResource(ProductDao productDao, ModelMapper modelMapper){
		this.productDao = productDao;
		this.modelMapper = modelMapper;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Transactional
	public Response list(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
		List<Product> products = productDao.listProducts(limit, offset);
		if(products == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build(); 
		} else {
			return Response
					.ok(modelMapper.map(products, new TypeToken<List<ProductDto>>() {}.getType()))
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
					.ok(modelMapper.map(product, ProductDto.class))
					.build();
		}	
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Transactional
	public Response create(ProductDto productInDto) {
		Product product = modelMapper.map(productInDto, Product.class);
		productDao.saveProduct(product);
		return Response
				.status(Response.Status.CREATED)
				.build();
		
	}
	
}
