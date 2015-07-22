package com.gesticiolite.view;

import com.gesticiolite.R;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.app.Activity;
import android.os.Bundle;

public class SelectDeviceActivity extends Activity{
	//http://stackoverflow.com/questions/28413977/use-same-recycler-adapter-for-inflating-different-activities <- check that 
	@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_menu);
	        // 1. get a reference to recyclerView 
	        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
	         
	        // IOLITE request
	        ItemData itemsData[] = { new ItemData("device 1",R.drawable.square),
	                new ItemData("device 2",R.drawable.square),
	                new ItemData("device 3",R.drawable.square)};
	        
	       //String ListType = extras.getString("class");
	        // 2. set layoutManger
	        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
	        recyclerView.setLayoutManager(layoutManager);
	        // 3. create an adapter 
	        
	        MenuAdapter mAdapter = new MenuAdapter(1);
	        // 4. set adapter
	        recyclerView.setAdapter(mAdapter);
	        // 5. set item animator to DefaultAnimator
	        recyclerView.setItemAnimator(new DefaultItemAnimator());
	 
	    }
}
