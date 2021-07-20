package com.youtube.javabrains.advance_JAX_RS.resources;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.youtube.javabrains.advance_JAX_RS.model.MyDate;

@Path("/test/messageBodyWriter")
public class MyResource4messageBodyWriter {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date getRequestDate() {
		//http://localhost:8080/advance-JAX-RS/webapi/test/messageBodyWriter
		//return date in plain text, jersey don't know how to do by default. have to create one MessageBodyWriter
		return Calendar.getInstance().getTime();
	}
}
