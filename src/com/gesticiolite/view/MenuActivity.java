package com.gesticiolite.view;

import java.util.List;

import com.gesticiolite.R;
import com.gesticiolite.gestures.*;
import com.gesticiolite.gestures.classifier.Distribution;

import com.gesticiolite.gestures.IGestureRecognitionListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

//help : 
// http://hmkcode.com/android-simple-recyclerview-widget-example/
//http://developer.android.com/tools/device.html

public class MenuActivity extends Activity{

	@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_menu);
			
//	        Intent bindIntent = new Intent("com.gesticiolite.gestures.GESTURE_RECOGNIZER");
//			bindService(bindIntent, serviceConnection, Context.BIND_AUTO_CREATE);
	        
	        // 1. get a reference to recyclerView 
	        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
	         
	        // this is data for recycler view
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
	
		@Override
		protected void onResume() {}
		
		
		@Override
		protected void onPause() {}
};
