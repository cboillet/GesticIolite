package com.gesticiolite.type;

import java.util.HashSet;
import java.util.Iterator;

import com.gesticiolite.type.ItemList;

public class TypeList {
	protected HashSet typeL;
	TypeList() 
	{
		//To DO faire une belle requete IOLITE pour receveroi les types de manières dynamique
		ItemList ItemToAdd1 = new ItemList("Light");
		typeL.add(ItemToAdd1);
		ItemList ItemToAdd2 = new ItemList("Heat");
		typeL.add(ItemToAdd2);
		ItemList ItemToAdd3 = new ItemList("Power");
		typeL.add(ItemToAdd3);
		ItemList ItemToAdd4 = new ItemList("Water");
		typeL.add(ItemToAdd4);
		ItemList ItemToAdd5 = new ItemList("Fenster");
		typeL.add(ItemToAdd5);
		ItemList ItemToAdd6 = new ItemList("Sensor");
		typeL.add(ItemToAdd6);
		
	}
	public int getSize()
	{
		return typeL.size();
	}
	
	public ItemList getItem(int position)
	{
		ItemList item;
		Iterator iterator = typeL.iterator(); 
		for(int i=0; i<(position-1); i++)
		{
			iterator.next();
		}
		return (ItemList) iterator.next();
	}
}
