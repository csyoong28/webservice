package com.youtube.javabrains.advance_JAX_RS.resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/secured")
public class MyResource6SecuredResource {

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testSecuredMethod() {
		//http://localhost:8080/advance-JAX-RS/webapi/secured
		return "this secured method is called";
	}
}
