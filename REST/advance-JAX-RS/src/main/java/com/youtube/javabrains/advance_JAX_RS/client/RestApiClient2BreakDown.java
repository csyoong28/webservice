package com.youtube.javabrains.advance_JAX_RS.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.youtube.javabrains.RESTMessenger.model.Message;

public class RestApiClient2BreakDown {

	public static void main(String[] args) {
		// client want to be initialized once per application, this client instance can make multiple API call
		Client client = ClientBuilder.newClient();
		// can create multiple webTarget from client
		WebTarget webTarget = client.target("http://localhost:8080/RESTMessenger/webapi/messages/1");
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON); // tell the accept header
		Message message = builder.get(Message.class); // can tell the response entity type.
		// Message message = response.readEntity(Message.class);
		System.out.println(message);
	}

}
