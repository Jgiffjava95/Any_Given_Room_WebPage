package com.anygivenroom.AGRwebapp;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/agrapi")
public class Controller {
	
	AgrAws awsHandler = new AgrAws();

	@POST
	@Path("/sub")
	@Produces(MediaType.APPLICATION_JSON)
	public String sub(User subber) {
		System.out.println(subber.getEmail());
		awsHandler.subToSnsTopic(subber.getEmail());
		return Response.snsSubResponse;
	}
}
