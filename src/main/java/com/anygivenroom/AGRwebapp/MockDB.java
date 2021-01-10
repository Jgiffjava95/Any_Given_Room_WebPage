package com.anygivenroom.AGRwebapp;

import java.util.ArrayList;

import model.Item;

public class MockDB {
	
	ArrayList<Item> DB = new ArrayList<Item>();
		
	public ArrayList<Item> getItems() {
		
		DB.add(new Item(1, "Vintage Sticker", 3, "Fancy vintage style Any Given Room sticker."));
		DB.add(new Item(2, "Saxobeast T-Shirt", 20, "AGR T-Shirt featuring the boys."));
		
		ArrayList<Item> gottenItems = new ArrayList<Item>();
		
		for (Item i : DB)
		{	
			gottenItems.add(i);
		}
		return gottenItems;
	}

}
