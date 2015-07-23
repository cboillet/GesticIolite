package com.gesticiolite.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.util.Log;
import android.view.View;

public class MyLayoutManager extends LinearLayoutManager{
	private Context mContext;

	public MyLayoutManager (Context context, int orientation, boolean reverseLayout){
		super(context, orientation, reverseLayout);
		mContext = context;
	}
	
	public void highlightView(int position, String color){
		View mView = findViewByPosition(position);
		mView.setBackgroundColor(Color.parseColor(color));
	}
		
	@Override
	public RecyclerView.LayoutParams generateDefaultLayoutParams() {
	    return new RecyclerView.LayoutParams(
	        RecyclerView.LayoutParams.WRAP_CONTENT,
	        RecyclerView.LayoutParams.WRAP_CONTENT);
	}
	

}
