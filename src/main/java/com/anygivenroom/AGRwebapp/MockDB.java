package com.anygivenroom.AGRwebapp;

import java.util.ArrayList;

import model.Item;

public class MockDB {
	
	ArrayList<Item> DB = new ArrayList<Item>();
		
	public ArrayList<Item> getItems() {
		
		DB.add(new Item(1, "Vintage Sticker", 3, "Fancy vintage style Any Given Room sticker.", false, false, false, false, false, false));
		DB.add(new Item(2, "Saxobeast T-Shirt", 20, "AGR T-Shirt featuring the boys.", true, true, true, true, true, true));
		
		ArrayList<Item> gottenItems = new ArrayList<Item>();
		
		for (Item i : DB)
		{	
			i.setVariants(i.checkForVariants());
			gottenItems.add(i);
		}
		return gottenItems;
	}

}
