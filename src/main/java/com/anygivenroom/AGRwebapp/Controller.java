package com.anygivenroom.AGRwebapp;

//import java.util.ArrayList;
import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.ApiResponse;
//import model.Item;
import model.Show;

@Path("/agrapi")
public class Controller {
	
	AgrAws awsHandler = new AgrAws();
	MockDB mockDBHandler = new MockDB();
	AgrDao dbHandler = new AgrDao();
	ApiResponse responder = new ApiResponse();

	@POST
	@Path("/sub")
	@Produces(MediaType.APPLICATION_JSON)
	public ApiResponse sub(User subber) {
		
		
		if (subber.getEmail() == null) {
			responder.setResponse("Sent email is invalid");
			return responder;
		}
		//awsHandler.subToSnsTopic(subber.getEmail());
		System.out.println(subber.getEmail());
		responder.setResponse("Sent email is valid");
		return responder;
	}
	
	@Path("/show")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Show> getShowList() {
		return dbHandler.getAllShows();		
	}
	
	/*
	@Path("/item")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Item> getInventory() {
		return mockDBHandler.getItems();		
	}
	*/
}
