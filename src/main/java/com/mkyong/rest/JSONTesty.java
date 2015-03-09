package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json/testy")
public class JSONTesty {

	@GET
	@Path("/znajdzZgube")
	@Produces(MediaType.APPLICATION_JSON)
	public String znajdzZgube() {
		return "Twoja zguba przepad³a";
	}

	@POST
	@Path("/przybadzJednorozcu")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response przybadzJednorozcu() {
		String result = "Krwio¿erczy jednoro¿ec przyby³ na Twoje ¿adanie, zw¹ go Pszczo³ek.....";
		return Response.status(201).entity(result).build();
	}
	
}
