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
	private ItemData[] itemsData;
	private static List<String> parameters = new ArrayList<String>(); //list of the selected parameters main type, subtype
	
	public MenuAdapter(ItemData[] itemsData){
		this.itemsData = itemsData;
	}
	
	public void updateItemData(ItemData[] itemsData){
		this.itemsData = null;
		this.itemsData = itemsData;
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
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
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
        viewHolder.txtViewTitle.setText(itemsData[position].getTitle());
        viewHolder.imgViewIcon.setImageResource(itemsData[position].getImageUrl());
     }
    
 // inner class to hold a reference to each item of RecyclerView 
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {    
        public TextView txtViewTitle;
        public ImageView imgViewIcon;
         
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
            itemLayoutView.setOnClickListener(this);
        }

		@Override
		public void onClick(View itemLayoutView) {
		    String parameter = txtViewTitle.getText().toString();
		    setParameters(parameter);
		    //if (getParameters().get(1) == null) { //For the moment we just have no filters
		    	 Intent intent = new Intent(itemLayoutView.getContext(), SelectDeviceActivity.class);
		     	intent.putExtra("mainType", parameters.get(0));
		    	//intent.putExtra("subType", parameters.get(1));
		        itemLayoutView.getContext().startActivity(intent);
		    //}
			
		}
    }
    
    
    @Override
    public int getItemCount() {
        return itemsData.length;
    } 
}
