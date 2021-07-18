package com.youtube.javabrains.RESTMessenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.youtube.javabrains.RESTMessenger.model.ErrorMessage;

@Provider	//to make this class discovered by JAV-RS when scanning
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		//http://localhost:8080/RESTMessenger/webapi/messages/4000   to reach here
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 001, "http://RESTMessenger/doc.com");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}
}
