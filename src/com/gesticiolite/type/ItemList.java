package com.gesticiolite.type;

import android.R.string;

public class ItemList {
	protected int logoResource = -1;
	public String name;

	ItemList(String n)
	{
		name = n;
	}
	
	public int getLogoResource()
	{
		return logoResource;
	}
}
