package com.gesticiolite.view;

import java.util.ArrayList;
import java.util.List;

import com.gesticiolite.R;
import com.gesticiolite.gestures.*;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

	/*parameters to use for the request*/
	private int selectionLvl=-1;
	private int type=-1;
	private int subtype=-1;
	private int device=-1;
	
	ViewHolder viewHolder;
	private static List<String> parameters = new ArrayList<String>(); //list of the selected parameters main type, subtype

	private List<ItemData> itemsData = new ArrayList();
	List<ItemData> itemsData1 = new ArrayList();
	List<ItemData> itemsDataType = new ArrayList();
	List<ItemData> itemsDataState = new ArrayList();
	List<ItemData> itemsDataPlace = new ArrayList();
   List<ItemData> itemsDataDevice = new ArrayList();
	
    public MenuAdapter(int lvl){
		this.itemsData = itemsData1;
		this.selectionLvl= lvl;
		initiateData();
	}
	
	public void initiateData(){
		itemsData1.add(new ItemData("Type",R.drawable.type));
		itemsData1.add(new ItemData("Place",R.drawable.type));
		itemsData1.add(new ItemData("State",R.drawable.type));
		
		itemsDataType.add(new ItemData("Heat",R.drawable.square));
		itemsDataType.add(new ItemData("Light",R.drawable.square));
		itemsDataType.add(new ItemData("Sensor",R.drawable.square));
		itemsDataType.add(new ItemData("Actuator",R.drawable.square));
		

		itemsDataState.add(new ItemData("On",R.drawable.square));
		itemsDataState.add(new ItemData("Off",R.drawable.square));
		

		itemsDataPlace.add(new ItemData("Kitchen",R.drawable.square));
		itemsDataPlace.add(new ItemData("Livingroom",R.drawable.square));
		itemsDataPlace.add(new ItemData("Bathroom",R.drawable.square));
		
	}
    
	public static List<String> getParameters(){
		return parameters;
	}
	

	 // Create new views (invoked by the layout manager)
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, null);
        // create ViewHolder     
        viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }
    
    public static void setParameters(String parameter){
    	parameters.add(parameter);
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData     
        viewHolder.txtViewTitle.setText(itemsData.get(position).getTitle());
        viewHolder.imgViewIcon.setImageResource(itemsData.get(position).getImageUrl());
     }
    
    public void onBindViewHolder(ViewHolder viewHolder, int position, ItemData[] items) {   
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData     
        viewHolder.txtViewTitle.setText(items[position].getTitle());
        viewHolder.imgViewIcon.setImageResource(items[position].getImageUrl());
     }
    
 // inner class to hold a reference to each item of RecyclerView 
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {    
        public TextView txtViewTitle;
        public ImageView imgViewIcon;
        int selectionLvl;
        
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            //selectionLvl = Lvl;
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
            itemLayoutView.setOnClickListener(this);
        }

		@Override
		public void onClick(View itemLayoutView) {
//		    String parameter = txtViewTitle.getText().toString();
//		    setParameters(parameter);
//	
//		    //if (getParameters().get(1) == null) { //For the moment we just have no filters
//		    	 Intent intent = new Intent(itemLayoutView.getContext(), SelectDeviceActivity.class);
//		     	intent.putExtra("mainType", parameters.get(0));
//		    	//intent.putExtra("subType", parameters.get(1));
//		        itemLayoutView.getContext().startActivity(intent);
		    //}
		}
		
		public void updateView(String s, int imageID){
			txtViewTitle.setText(s);
			imgViewIcon.setImageResource(imageID);
		}

		public void updateView2(View itemLayoutView){
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
		}
		
    }
        
    public void updateRecyclerOnClick(ViewGroup parent, View itemLayout, int position){
    	System.out.println("selection lvl"+selectionLvl+"position"+position);
    	int boundary = getItemCount();
    	itemsData.clear();
    	notifyItemRangeRemoved(0, boundary);
    	
    	if (selectionLvl == 0){
	    	switch(position){	    	
	    		case 0: for(ItemData item: itemsDataType) itemsData.add(item);
	    			break;	    				
	    		case 1: for(ItemData item: itemsDataPlace) itemsData.add(item);
	    			break;
	    		case 2: for(ItemData item: itemsDataState) itemsData.add(item);
	    			break;
	    	}
	    	type=position;
    	}
	    if (selectionLvl == 1){	
	    		List<ItemData> itemDevices = generateItemDeviceOnRequest(); //c'est là que tu dois mettre ta requête Jimmy
	    		for(ItemData item: itemDevices) itemsData.add(item);
	    		System.out.println("selection lvl"+selectionLvl+"position"+position);
	    	    subtype=position;
    	}
	    
	    if (selectionLvl ==2){
	    	for(ItemData item: itemsDataState) itemsData.add(item);
	    	device = position;
	    }
    	notifyItemRangeInserted(0, getItemCount());
    	selectionLvl++;
    }
    
    
    @Override
    public int getItemCount() {
        return itemsData.size();
    } 
    
    public List<ItemData> generateItemDeviceOnRequest(){
    	List<ItemData> itemsDataDevice = new ArrayList();
    	itemsDataDevice.add(new ItemData("Device 1",R.drawable.square));
    	itemsDataDevice.add(new ItemData("Device 2",R.drawable.square));
    	itemsDataDevice.add(new ItemData("Device 3",R.drawable.square));
   
    	return itemsDataDevice;
    }

}
