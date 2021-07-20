package com.youtube.javabrains.advance_JAX_RS.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.youtube.javabrains.RESTMessenger.model.Message;

public class RestApiClient3BestPractise {

	public static void main(String[] args) {
		//client want to be initialized once per application, this client instance can make multiple API call
		Client client = ClientBuilder.newClient();
		WebTarget baseWebTarget = client.target("http://localhost:8080/RESTMessenger/webapi");
		WebTarget messagesTarget = baseWebTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		Message message1 = singleMessageTarget.resolveTemplate("messageId", "1").
			request(MediaType.APPLICATION_JSON).get(Message.class);
		System.out.println(message1);
		
		Message message2 = singleMessageTarget.resolveTemplate("messageId", "2").
				request(MediaType.APPLICATION_JSON).get(Message.class);
		System.out.println(message2);
	}

}
