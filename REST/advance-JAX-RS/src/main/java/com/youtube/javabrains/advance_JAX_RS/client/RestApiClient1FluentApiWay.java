package com.youtube.javabrains.advance_JAX_RS.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.youtube.javabrains.RESTMessenger.model.Message;

public class RestApiClient1FluentApiWay {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/RESTMessenger/webapi/messages/1").request().get();
		Message message = response.readEntity(Message.class);
		System.out.println(message);
	}

}
