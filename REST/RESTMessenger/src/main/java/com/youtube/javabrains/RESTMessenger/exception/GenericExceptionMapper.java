package com.youtube.javabrains.RESTMessenger.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.youtube.javabrains.RESTMessenger.model.ErrorMessage;

//@Provider	//to make this class discovered by JAV-RS when scanning
//this will catch all types of exceptions
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "http://RESTMessenger/doc.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(errorMessage).build();
	}
}
