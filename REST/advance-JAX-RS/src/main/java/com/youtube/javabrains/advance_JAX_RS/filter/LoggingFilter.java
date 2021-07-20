package com.youtube.javabrains.advance_JAX_RS.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class LoggingFilter implements ContainerResponseFilter, ContainerRequestFilter{
	//http://localhost:8080/advance-JAX-RS/webapi/test, will see the header added
	//this is for ContainerResponseFilter
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("response filters: " + responseContext.getHeaders());		
	}
	
	//this is for ContainerRequestFilter
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("request filters: " + requestContext.getHeaders());
	}
}
