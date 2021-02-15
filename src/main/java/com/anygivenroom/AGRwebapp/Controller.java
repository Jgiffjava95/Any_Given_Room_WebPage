package com.anygivenroom.AGRwebapp;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Item;
import model.Show;

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
	
	@Path("/item")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Item> getInventory() {
		return dbHandler.getItems();		
	}
	
	@Path("/show")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Show> getShowList() {
		return dbHandler.getShows();		
	}
}
