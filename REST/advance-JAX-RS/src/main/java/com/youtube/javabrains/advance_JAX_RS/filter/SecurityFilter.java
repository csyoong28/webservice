package com.youtube.javabrains.advance_JAX_RS.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		//only applied for /secured path
		if (requestContext.getUriInfo().getPath().equals("secured")) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if (authHeader!= null && !authHeader.isEmpty()) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = Base64.decodeAsString(authToken); // should be username:password
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				if ("user".equals(username) && "password".equals(password)) {
					return;
				}
			}
			Response response = Response.status(Status.UNAUTHORIZED).entity("user cannot access the resource").build();
			requestContext.abortWith(response); // this will abort the request from filter, will not go to resource
		}
	}

}
