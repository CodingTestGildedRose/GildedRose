package com.gildedrose.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gildedrose.model.Item;
import com.gildedrose.model.User;



@Component
public class ItemDAO {

	private static ArrayList<Item> items;
	{
		items = new ArrayList<Item>();
		items.add(new Item("shoes", "black shoes", 34));
		items.add(new Item("pants", "blue pants", 40));
		items.add(new Item("jacket", "black jacket", 23));
	}
	

	/**
	 * Returns list of items from  database.
	 * 
	 * @return list of items
	 */
	public static ArrayList<Item> list() {
		return items;
	}
	
	/**
	 * Buy an item and remove it from inventory
	 * 
	 * @param String name item name
	 * @return String name item name
	 */
	public String buy(String name) {

		for (Item item : items) {
			if (item.getName().equals(name)) {
				items.remove(item);
				return name;
			}
		}
		return null;
	}
	


}
