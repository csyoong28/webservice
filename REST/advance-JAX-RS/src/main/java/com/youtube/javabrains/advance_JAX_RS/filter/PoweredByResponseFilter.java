package com.youtube.javabrains.advance_JAX_RS.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		//http://localhost:8080/advance-JAX-RS/webapi/test, will see the header added
		responseContext.getHeaders().add("X-Powered-By", "java brains");		
	}
}
