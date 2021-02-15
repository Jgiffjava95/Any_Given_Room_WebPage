package com.anygivenroom.AGRwebapp;

import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Item;
import model.Show;

public class MockDB {

	ArrayList<Item> itemDB = new ArrayList<Item>();
	ArrayList<Show> showDB = new ArrayList<Show>();

	public ArrayList<Item> getItems() {

		itemDB.add(new Item(1, "Vintage Sticker", 2.99, "Fancy vintage style Any Given Room sticker.",
				"./images/vintageLogo.jpg", false, false, false, false, false, false));
		itemDB.add(new Item(2, "Saxobeast T-Shirt", 19.99, "AGR T-Shirt featuring the boys.",
				"./images/91dd87bab705470b87bcc90d8fe1a129.jpeg", true, false, true, true, true, true));

		ArrayList<Item> gottenItems = new ArrayList<Item>();

		for (Item i : itemDB) {
			i.setVariants(i.checkForVariants());
			gottenItems.add(i);
		}
		return gottenItems;
	}

	public ArrayList<Show> getShows() {

		showDB.add(new Show(1, "Vino's", "new show.jpg", "Little Rock, Arkansas 1000 Some Street", 19.99,
				"2/15/2021 7:00pm"));
		showDB.add(new Show(2, "Vino's", "new show.jpg", "Little Rock, Arkansas 1000 Some Street", 19.99,
				"2/15/2021 7:00pm"));

		ArrayList<Show> gottenShows = new ArrayList<Show>();

		for (Show s : showDB) {
			gottenShows.add(s);
		}
		return gottenShows;
	}

}
