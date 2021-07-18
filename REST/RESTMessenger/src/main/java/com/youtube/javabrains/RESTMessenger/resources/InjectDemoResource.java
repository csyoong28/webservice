package com.youtube.javabrains.RESTMessenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectDemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("/matrixParam")
	public String getMatrixParam(@MatrixParam("param") String matrixParam) {
		//http://localhost:8080/RESTMessenger/webapi/injectDemo/matrixParam;param=paramValue
		return "matrixParam: " + matrixParam;	//matrixParam: paramValue
	}
	
	@GET
	@Path("/header")
	public String getHeader(@HeaderParam("Host") String fromHost, @HeaderParam("customerHeader") String customerHeader) {
		//http://localhost:8080/RESTMessenger/webapi/injectDemo/header
		return "Host header: " + fromHost + ", customerHeader : " + customerHeader;
		//Host header: localhost:8080, customerHeader : customerHeaderValue
	}
	
	@GET
	@Path("/cookie")
	public String getCookie(@CookieParam("JSESSIONID") String jSessionId) {
		//http://localhost:8080/RESTMessenger/webapi/injectDemo/cookie
		//set at header, Cookie:JSESSIONID=111;loginName=john
		return "jSessionId: " + jSessionId;	//jSessionId: 111
	}
	
	@GET
	@Path("/context/{detailId}")
	public String getContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		//http://localhost:8080/RESTMessenger/webapi/injectDemo/context/5?year=1987&start=1&page=10
		System.out.println(uriInfo.getAbsolutePath());	//http://localhost:8080/RESTMessenger/webapi/injectDemo/context/5
		System.out.println(uriInfo.getBaseUri());	//http://localhost:8080/RESTMessenger/webapi/
		System.out.println(uriInfo.getPathSegments());	//[injectDemo, context, 5]
		System.out.println(uriInfo.getQueryParameters());	//{year=[1987], start=[1], page=[10]}
		System.out.println(uriInfo.getPathParameters());	//{detailId=[5]}
		System.out.println(headers.getRequestHeaders());	//{customerheader=[customerHeaderValue], cookie=[JSESSIONID=111;loginName=john],..
		System.out.println(headers.getAcceptableMediaTypes());	//[{*/*, q=1000}]
		System.out.println(headers.getCookies());	//{JSESSIONID=$Version=0;JSESSIONID=111, loginName=$Version=0;loginName=john}
		return "result";
	}
}
