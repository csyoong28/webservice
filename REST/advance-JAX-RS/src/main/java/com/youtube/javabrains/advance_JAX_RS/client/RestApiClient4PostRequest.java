package com.youtube.javabrains.advance_JAX_RS.client;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.youtube.javabrains.RESTMessenger.model.Message;

public class RestApiClient4PostRequest {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget baseWebTarget = client.target("http://localhost:8080/RESTMessenger/webapi");
		WebTarget messagesTarget = baseWebTarget.path("messages");
		Message message = new Message(5L, "happy birthday lai", new Date(57, 10, 15), "cli");
		//need to wrap the object into entity, and the body type eg JSON, XML etc
		Response postResponse = messagesTarget.request().post(Entity.json(message));
		//can examine the cookie, header, statusCode from Response object
		System.out.println(postResponse.readEntity(Message.class));
	}

}
