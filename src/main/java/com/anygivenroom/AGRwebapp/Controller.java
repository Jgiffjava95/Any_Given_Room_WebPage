package com.anygivenroom.AGRwebapp;

import java.util.ArrayList;
import java.util.List;
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
	MockDB mockDBHandler = new MockDB();
	AgrDao dbHandler = new AgrDao();

	@POST
	@Path("/sub")
	@Produces(MediaType.APPLICATION_JSON)
	public void sub(User subber) {
		System.out.println(subber.getEmail());
	}
	
	@Path("/item")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Item> getInventory() {
		return mockDBHandler.getItems();		
	}
	
	@Path("/show")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Show> getShowList() {
		return dbHandler.getAllShows();		
	}
}
