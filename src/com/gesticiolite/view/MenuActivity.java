package com.gesticiolite.view;

import com.gesticiolite.R;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.app.Activity;
import android.os.Bundle;

//help : 
// http://hmkcode.com/android-simple-recyclerview-widget-example/
//http://developer.android.com/tools/device.html

public class MenuActivity extends Activity{

	  @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_menu);
	        // 1. get a reference to recyclerView 
	        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
	         
	        // this is data fro recycler view
	        ItemData itemsData[] = { new ItemData("Type",R.drawable.type),
	                new ItemData("Place",R.drawable.place),
	                new ItemData("state",R.drawable.state)};
	        
	        // 2. set layoutManger
	        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
	        recyclerView.setLayoutManager(layoutManager);
	        // 3. create an adapter 
	        
	        MenuAdapter mAdapter = new MenuAdapter(itemsData);
	        // 4. set adapter
	        recyclerView.setAdapter(mAdapter);
	        // 5. set item animator to DefaultAnimator
	        recyclerView.setItemAnimator(new DefaultItemAnimator());
	 
	    }
};
