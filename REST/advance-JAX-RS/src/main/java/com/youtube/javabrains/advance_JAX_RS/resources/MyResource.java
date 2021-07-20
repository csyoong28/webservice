package com.youtube.javabrains.advance_JAX_RS.resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Singleton		//remove this annotation and will see count always 1, because default scope is request, not singleton
public class MyResource {
	
	private int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		//http://localhost:8080/advance-JAX-RS/webapi/test
		count = count + 1;
		return "this method is called " + count + " times";
	}
}
