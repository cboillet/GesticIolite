package com.gesticiolite.type;

import java.util.HashSet;
import java.util.Iterator;

import com.gesticiolite.type.ItemList;

public class StateList {
	protected HashSet stateL;

	StateList()
	{
		//To DO faire une belle requete IOLITE pour receveroi les lieux de manières dynamique
		ItemList ItemToAdd1 = new ItemList("ON");
		stateL.add(ItemToAdd1);
		ItemList ItemToAdd2 = new ItemList("OFF");
		stateL.add(ItemToAdd2);
	}
	
	public int getSize()
	{
		return stateL.size();
	}
	
	public ItemList getItem(int position)
	{
		ItemList item;
		Iterator iterator = stateL.iterator(); 
		for(int i=0; i<(position-1); i++)
		{
			iterator.next();
		}
		return (ItemList) iterator.next();
	}
}
