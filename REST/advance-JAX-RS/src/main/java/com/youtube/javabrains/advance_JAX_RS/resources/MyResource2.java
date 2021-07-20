package com.youtube.javabrains.advance_JAX_RS.resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test2")
//@Singleton
public class MyResource2 {
	@PathParam("pathParam")
	private String pathParamExample;
	@QueryParam("queryParam")
	private String queryParamExample;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "it works, pathParam: " + pathParamExample + ", QueryParam: " + queryParamExample;
	}

	public String getPathParamExample() {
		return pathParamExample;
	}

	public void setPathParamExample(String pathParamExample) {
		this.pathParamExample = pathParamExample;
	}

	public String getQueryParamExample() {
		return queryParamExample;
	}

	public void setQueryParamExample(String queryParamExample) {
		this.queryParamExample = queryParamExample;
	}
	
}
