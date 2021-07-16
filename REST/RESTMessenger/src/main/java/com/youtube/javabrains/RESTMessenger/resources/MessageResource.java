package com.youtube.javabrains.RESTMessenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.youtube.javabrains.RESTMessenger.model.Message;
import com.youtube.javabrains.RESTMessenger.service.MessageService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/messages")
public class MessageResource {

	MessageService messageService = new MessageService();	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size) {
		//http://localhost:8080/RESTMessenger/webapi/messages?year=198
		//http://localhost:8080/RESTMessenger/webapi/messages?start=2&size=2
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		if (start > 0 && size > 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessagesEnhance1();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	//though messageId at path is like a string, jersey convert to long
	public Message getMessage(@PathParam(value = "messageId") long id) {
		return messageService.getMessage(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	//specify the expected request body format
	public Message addMessage(Message message) {
		/* send this in postman
		 * {
		    "author": "mike",
		    "created": "2021-07-16T10:02:57.002",
		    "message": "mess3"
		}*/
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam(value = "messageId") long id, Message message) {
		/* send this in postman
		 * {
		    "author": "mike",
		    "created": "2021-07-16T10:02:57.002",
		    "message": "change content"
		}*/
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam(value = "messageId") long id) {
		messageService.removeMessage(id);
	}
	
	
	//----------below are for XML response
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessagesXmlResponse() {
		return messageService.getAllMessagesEnhance1();
	}
	
	@GET
	@Path("/xml/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	//though messageId at path is like a string, jersey convert to long
	public Message getMessageXmlResponse(@PathParam(value = "messageId") long id) {
		return messageService.getMessage(id);
	}
	
}
