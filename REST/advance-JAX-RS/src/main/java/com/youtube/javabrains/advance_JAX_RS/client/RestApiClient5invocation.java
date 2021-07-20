package com.youtube.javabrains.advance_JAX_RS.client;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.youtube.javabrains.RESTMessenger.model.Message;

public class RestApiClient5invocation {

	public static void main(String[] args) {
		RestApiClient5invocation restApiClient5invocation = new RestApiClient5invocation();		
		Invocation invocation = restApiClient5invocation.prepareRequestForMessageByYear(1987);
		Response response = invocation.invoke();
		//when involve generic, need to handle it
		ArrayList<Message> messages = response.readEntity(new GenericType<ArrayList<Message>>() {});
		System.out.println(messages);
	}

	public Invocation prepareRequestForMessageByYear(int year) {
		Client client = ClientBuilder.newClient();
		WebTarget baseWebTarget = client.target("http://localhost:8080/RESTMessenger/webapi");
		WebTarget messagesTarget = baseWebTarget.path("messages");
		Invocation invocation = messagesTarget.queryParam("year", year).request(MediaType.APPLICATION_JSON).buildGet();
		return invocation;
	}

}
