package com.gesticiolite.view;

import java.util.List;

import com.gesticiolite.R;
import com.gesticiolite.gestures.*;
import com.gesticiolite.gestures.classifier.Distribution;
import com.gesticiolite.gestures.IGestureRecognitionListener;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
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

	String trainingSet;
	private IGestureRecognitionService recognitionService;
	private final ServiceConnection serviceConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName className, IBinder service) {
			recognitionService = IGestureRecognitionService.Stub.asInterface(service);
		      try {     
		    	    recognitionService.startClassificationMode("default");
		    	  	recognitionService.registerListener(IGestureRecognitionListener.Stub.asInterface(gestureListenerStub));
			      } catch (RemoteException e) {
			         e.printStackTrace();
			      }
		}

		@Override
		public void onServiceDisconnected(ComponentName className) {
			recognitionService = null;
		}
	};
	
	IBinder gestureListenerStub = new IGestureRecognitionListener.Stub() {
		@Override
		public void onGestureRecognized(final Distribution distribution) throws RemoteException {
			System.out.println("gesture recognized");
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(MenuActivity.this, String.format("%s: %f", distribution.getBestMatch(), distribution.getBestDistance()), Toast.LENGTH_LONG).show();
					System.err.println(String.format("%s: %f", distribution.getBestMatch(), distribution.getBestDistance()));
				}
			});
		}

		@Override
		public void onGestureLearned(String gestureName) throws RemoteException {
		}

		@Override
		public void onTrainingSetDeleted(String trainingSet)
				throws RemoteException {}
	};
	
	@Override
	protected void onResume() {
		trainingSet = getIntent().getStringExtra("trainingSetName");
		Intent bindIntent = new Intent(this, GestureRecognitionService.class);
		bindService(bindIntent, serviceConnection, Context.BIND_AUTO_CREATE);
		super.onResume();
	}

	@Override
	protected void onPause() {
		try {
			recognitionService.unregisterListener(IGestureRecognitionListener.Stub.asInterface(gestureListenerStub));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		recognitionService = null;
		unbindService(serviceConnection);
		super.onPause();
	}
	
	
	@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_menu);        
	        trainingSet = getIntent().getStringExtra("trainingSetName");
			
	        final Button start = (Button) findViewById(R.id.startClassifying);

			start.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
						if (recognitionService != null) {
						try {
							recognitionService.startClassificationMode(trainingSet);
							System.out.println("starting classifying");
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
	        
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
	

};
