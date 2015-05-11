package com.avenuecode.jchallenge.application;



import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.avenuecode.jchallenge.rest.OrderResource;
import com.avenuecode.jchallenge.rest.ProductResource;

public class ServiceApplication  extends ResourceConfig {

	public ServiceApplication(){
		register(RequestContextFilter.class);
		register(OrderResource.class);
		register(ProductResource.class);
	}
}
