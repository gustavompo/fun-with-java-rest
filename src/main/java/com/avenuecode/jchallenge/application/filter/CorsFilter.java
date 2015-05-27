package com.avenuecode.jchallenge.application.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		MultivaluedMap<String, Object> headersCtx = responseContext.getHeaders();
		headersCtx.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headersCtx.add("Access-Control-Allow-Origin", "*");		
	}
}
