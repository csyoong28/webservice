package com.youtube.javabrains.advance_JAX_RS.resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.youtube.javabrains.advance_JAX_RS.model.MyDate;

@Path("/date/{dateString}")
public class MyResource3ParamConverter {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestDate(@PathParam("dateString") MyDate myDate) {
		//http://localhost:8080/advance-JAX-RS/webapi/date/yesterday
		return myDate.toString();
	}
}
