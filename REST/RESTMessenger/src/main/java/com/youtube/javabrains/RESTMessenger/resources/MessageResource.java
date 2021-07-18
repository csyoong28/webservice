package com.youtube.javabrains.RESTMessenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.youtube.javabrains.RESTMessenger.model.Message;
import com.youtube.javabrains.RESTMessenger.resources.beans.MessageFilterBean;
import com.youtube.javabrains.RESTMessenger.service.MessageService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/messages")
@Produces(value= {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {

	MessageService messageService = new MessageService();	
	
	@GET
	@Produces(value= {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size) {
		//http://localhost:8080/RESTMessenger/webapi/messages
		//http://localhost:8080/RESTMessenger/webapi/messages?year=1987
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
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesAll(@BeanParam MessageFilterBean messageFilterBean) {
		//http://localhost:8080/RESTMessenger/webapi/messages/all
		//http://localhost:8080/RESTMessenger/webapi/messages/all?year=1987
		//http://localhost:8080/RESTMessenger/webapi/messages/all?start=2&size=2
		if (messageFilterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(messageFilterBean.getYear());
		}
		if (messageFilterBean.getStart() > 0 && messageFilterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(messageFilterBean.getStart(), messageFilterBean.getSize());
		}
		return messageService.getAllMessagesEnhance1();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	//though messageId at path is like a string, jersey convert to long
	public Message getMessage(@PathParam(value = "messageId") long id, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(id);		
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(getUriForComments(uriInfo, message), "comments");
		return message;
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(Long.toString(message.getId())).build().toString();
	}
	
	private String getUriForProfile(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder().path(ProfileResource.class)
				.path(message.getAuthor()).build().toString();
	}
	
	private String getUriForComments(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", message.getId())
				.build().toString();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	//specify the expected request body format
	public Response addMessage(Message message, @Context UriInfo uriInfo){
		/* send this in postman
		 * {
		    "author": "mike",
		    "created": "2021-07-16T10:02:57.002",
		    "message": "mess3"
		}*/
		Message createdMessage = messageService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(createdMessage.getId())).build();
		return Response.created(uri).entity(createdMessage).build();
		//when begin to learn is below
		//return messageService.addMessage(message);
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
	
	//not to tell the HTTP method, so that it can handle all HTTP method like post, get etc
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
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
