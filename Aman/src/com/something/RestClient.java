package com.something;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

@Path("/rest")
public class RestClient {

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray testing() {
		JSONArray json = new JSONArray();
		PlainJava test = new PlainJava();
		test.setId("213213123");
		test.setName("Plain Java JSON testing");
		json.put(test);
		return json;
	}
	
	@GET
	@Path("/something")
	@Produces(MediaType.APPLICATION_JSON)
	public Response something() {
		return Response.status(200).entity("something").build();
	}
	
	@GET
	@Path("/test/xml")
	@Produces(MediaType.APPLICATION_XML)
	public PlainJava testingXML() {
		PlainJava test = new PlainJava();
		test.setId("213213123");
		test.setName("Plain Java JSON testing");
		return test;
	}
	
	@GET
	@Path("/test/json")
	@Produces(MediaType.APPLICATION_JSON)
	public PlainJava testingJSON() {
		PlainJava test = new PlainJava();
		test.setId("213213123");
		test.setName("Plain Java JSON testing");
		return test;
	}
	
	@GET
	@Path("/test/str")
	@Produces(MediaType.TEXT_PLAIN)
	public String testingStr() {
		PlainJava test = new PlainJava();
		test.setId("213213123");
		test.setName("Plain Java JSON testing");
		return test.toString();
	}
}
