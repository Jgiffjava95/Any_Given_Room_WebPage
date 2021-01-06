package com.anygivenroom.AGRwebapp;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Item;

@Path("/agrapi")
public class Controller {
	
	AgrAws awsHandler = new AgrAws();
	MockDB dbHandler = new MockDB();

	@POST
	@Path("/sub")
	@Produces(MediaType.APPLICATION_JSON)
	public String sub(User subber) {
		System.out.println(subber.getEmail());
		awsHandler.subToSnsTopic(subber.getEmail());
		return Response.snsSubResponse;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Item> getInventory() {
		System.out.println("Get Called.");
		return dbHandler.getItems();		
	}
}
