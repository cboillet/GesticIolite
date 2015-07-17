package com.gesticiolite.type;

import java.util.HashSet;
import java.util.Iterator;

import com.gesticiolite.type.ItemList;

public class PlaceList {
	protected HashSet placeL;
	
	PlaceList() 
	{
		//To DO faire une belle requete IOLITE pour receveroi les lieux de manières dynamique
		ItemList ItemToAdd1 = new ItemList("Kitchen");
		placeL.add(ItemToAdd1);
		ItemList ItemToAdd2 = new ItemList("Bathroom");
		placeL.add(ItemToAdd2);
		ItemList ItemToAdd3 = new ItemList("Livingroom");
		placeL.add(ItemToAdd3);
		ItemList ItemToAdd4 = new ItemList("Bedroom");
		placeL.add(ItemToAdd4);
		ItemList ItemToAdd5 = new ItemList("Fitness room");
		placeL.add(ItemToAdd5);

	}
	
	public int getSize()
	{
		return placeL.size();
	}
	public ItemList getItem(int position)
	{
		ItemList item;
		Iterator iterator = placeL.iterator(); 
		for(int i=0; i<(position-1); i++)
		{
			iterator.next();
		}
		return (ItemList) iterator.next();
	}
}
