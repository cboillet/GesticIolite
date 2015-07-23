package com.gesticiolite.gestures.trainer;

import java.util.List;

import com.gesticiolite.R;
import com.gesticiolite.gestures.*;
import com.gesticiolite.gestures.classifier.Distribution;
import com.gesticiolite.gestures.IGestureRecognitionListener;
import com.gesticiolite.view.MenuActivity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;

public class TrainerActivity extends Activity {

	String activeTrainingSet;
		
	public IGestureRecognitionService recognitionService;
	
	public final ServiceConnection serviceConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
		      recognitionService = IGestureRecognitionService.Stub.asInterface(service);
		      try {     
		         recognitionService.registerListener(IGestureRecognitionListener.Stub.asInterface(gestureListenerStub));
		      } catch (RemoteException e) {
		         e.printStackTrace();
		      }
			
		}
	
		@Override
		public void onServiceDisconnected(ComponentName name) {
			recognitionService = null;
			
		}
	};	
	
	IBinder gestureListenerStub = new IGestureRecognitionListener.Stub() {
		@Override
		public void onGestureLearned(String gestureName) throws RemoteException {
			Toast.makeText(TrainerActivity.this, String.format("Gesture %s learned", gestureName), Toast.LENGTH_SHORT).show();
			System.err.println("Gesture %s learned");
		}
	
		@Override
		public void onGestureRecognized(final Distribution distribution) throws RemoteException {
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(TrainerActivity.this, String.format("%s: %f", distribution.getBestMatch(), distribution.getBestDistance()), Toast.LENGTH_LONG).show();
					System.err.println(String.format("%s: %f", distribution.getBestMatch(), distribution.getBestDistance()));
				}
			});
		}
		
		@Override
		public void onTrainingSetDeleted(String trainingSet) throws RemoteException {
			Toast.makeText(TrainerActivity.this, String.format("Training set %s deleted", trainingSet), Toast.LENGTH_SHORT).show();
			System.err.println(String.format("Training set %s deleted", trainingSet));
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState){	
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.trainer);
		final TextView activeTrainingSetText = (TextView) findViewById(R.id.activeTrainingSet);
		final EditText trainingSetText = (EditText) findViewById(R.id.trainingSetName);
		activeTrainingSet = trainingSetText.getText().toString();
		
		final TextView gestureUp = (TextView) findViewById(R.id.gestureUp);
		final TextView gestureDown = (TextView) findViewById(R.id.gestureDown);
		final TextView gestureSelect = (TextView) findViewById(R.id.gestureSelect);
		final TextView gestureSelectAll = (TextView) findViewById(R.id.gestureSelectAll);
		final TextView gestureActivate = (TextView) findViewById(R.id.gestureActivate);
		final TextView gestureDeactivate = (TextView) findViewById(R.id.gestureDeactivate);
		final TextView gestureCancel = (TextView) findViewById(R.id.gestureCancel);

		final Button startTrainUp = (Button) findViewById(R.id.trainUp);
		final Button startTrainDown = (Button) findViewById(R.id.trainDown);
		final Button startTrainSelect = (Button) findViewById(R.id.trainSelect);
		final Button startTrainSelectAll = (Button) findViewById(R.id.trainSelectAll);
		final Button startTrainActivate = (Button) findViewById(R.id.trainActivate);
		final Button startTrainDeactivate = (Button) findViewById(R.id.trainDeactivate);
		final Button startTrainCancel = (Button) findViewById(R.id.trainCancel);
		
		final Button deleteTrainingSetButton = (Button) findViewById(R.id.deleteTrainingSetButton);
		final Button changeTrainingSetButton = (Button) findViewById(R.id.startNewSetButton);
		
		final Button launchButton = (Button) findViewById(R.id.launchApp);
		
		OnClickListener TrainListener = new OnClickListener() {
			@Override
			public void onClick(View v){
				String gesture = null;
				switch (v.getId()){
					case R.id.trainUp: gesture="Up"; break;
					case R.id.trainDown: gesture="Down"; break; 
					case R.id.trainSelect: gesture="Select"; break;
					case R.id.trainSelectAll: gesture="SelectAll"; break;
					case R.id.trainActivate: gesture="Activate"; break;
					case R.id.trainDeactivate: gesture="Deactivate"; break;
					case R.id.trainCancel: gesture="Cancel"; break;
					
				}
				
				if (recognitionService != null) {
					try {
						if (!recognitionService.isLearning()) {
							((TextView) v).setText("Stop Training");
							//editText.setEnabled(false);
							deleteTrainingSetButton.setEnabled(false);
							changeTrainingSetButton.setEnabled(false);
							trainingSetText.setEnabled(false);
							recognitionService.startLearnMode(activeTrainingSet, gesture);
						} else {
							((TextView) v).setText("Start Training");
							//editText.setEnabled(true);
							deleteTrainingSetButton.setEnabled(true);
							changeTrainingSetButton.setEnabled(true);
							trainingSetText.setEnabled(true);
							recognitionService.stopLearnMode();
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
			}
		};
		
		startTrainUp.setOnClickListener(TrainListener);
		startTrainDown.setOnClickListener(TrainListener);
		startTrainSelect.setOnClickListener(TrainListener);
		startTrainSelectAll.setOnClickListener(TrainListener);
		startTrainActivate.setOnClickListener(TrainListener);
		startTrainDeactivate.setOnClickListener(TrainListener);
		startTrainCancel.setOnClickListener(TrainListener);
		
		
		changeTrainingSetButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				activeTrainingSet = trainingSetText.getText().toString();
				activeTrainingSetText.setText(activeTrainingSet);

				if (recognitionService != null) {
					try {
						recognitionService.startClassificationMode(activeTrainingSet);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		

		deleteTrainingSetButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(TrainerActivity.this);
				builder.setMessage("You really want to delete the training set?").setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						if (recognitionService != null) {
							try {
								recognitionService.deleteTrainingSet(activeTrainingSet);
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
				builder.create().show();
			}
		});
		
	}
	
	public void onClick(View v){
			Intent gesticIolite = new Intent().setClass(v.getContext(), MenuActivity.class);
			gesticIolite.putExtra("trainingSetName", activeTrainingSet);
			startActivity(gesticIolite);		
	}
	
	@Override
	protected void onResume(){
		Intent bindIntent = new Intent(this, GestureRecognitionService.class);
		bindService(bindIntent, serviceConnection, Context.BIND_AUTO_CREATE);
		startService(bindIntent);
		super.onResume();
	}
	
	@Override 
	protected void onPause(){
//		try {
//			recognitionService.unregisterListener(IGestureRecognitionListener.Stub.asInterface(gestureListenerStub));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		recognitionService = null;
//		unbindService(serviceConnection);
		super.onPause();
	}
	
	@Override
	protected void onStop(){
		try {
			recognitionService.unregisterListener(IGestureRecognitionListener.Stub.asInterface(gestureListenerStub));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		recognitionService = null;
		unbindService(serviceConnection);
		super.onStop();
	}
}
