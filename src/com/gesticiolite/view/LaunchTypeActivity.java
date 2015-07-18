package com.gesticiolite.view;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gesticiolite.R;
import com.gesticiolite.utils.Utils;
import com.gesticiolite.type.ItemList;
import com.gesticiolite.type.PlaceList;
import com.gesticiolite.type.StateList;
import com.gesticiolite.type.TypeList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LaunchTypeActivity extends Activity {
	
 	private Point screenDimention = new Point();
	private Resources res;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
	 	getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
 	    //private static Logger log = LoggerFactory.getLogger(TypeCarouselActivity.class);
		setContentView(R.layout.launch_type_activity);
		Utils.hideNavigationButtons(this);
		String ListType = extras.getString("class");
//		if (ListType == "PlaceList") {CarouselRendering carouselRendering = new LaunchTypeActivity.CarouselRendering(PlaceList.class, this); carouselRendering.drawCarousel();}
//		if (ListType == "StateList") {CarouselRendering carouselRendering = new LaunchTypeActivity.CarouselRendering(StateList.class, this); carouselRendering.drawCarousel();}
//		if (ListType == "TypeList") {CarouselRendering carouselRendering = new LaunchTypeActivity.CarouselRendering(TypeList.class, this); carouselRendering.drawCarousel();}

	}
	

//	
//	public class CarouselRendering<T> {
//		private Carousel carousel;
//		public Context crContext;
//		private Resources res;
//		private Button _button;
//		private ImageAdapter adapter;
//		private T subtypeList;
//		private int selectedSubType = -1;
//	 	//private int[] types = { R.drawable.place, R.drawable.type,
//		//		R.drawable.state};x
//	 	private Point screenDimention = new Point();
//
//	 	public CarouselRendering(T classTypeObject, Context c)
//	 	{
//	 		this.subtypeList = classTypeObject;
//	 		this.crContext = c;
//	 	}
//	 	
//	 	public void drawCarousel(){
//	    	res = getApplicationContext().getResources();
//	    	int diameter = (int) (screenDimention.x / 1.3);
//	    	//set linear layout
//	        LinearLayout l = (LinearLayout) findViewById(R.id.carouselContainer);
//	        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//	        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//	        lp.addRule(RelativeLayout.ALIGN_BOTTOM);
//	        lp.bottomMargin = (int) (- screenDimention.y);
//	        l.setLayoutParams(lp);
//
//	        // create the carousel object.
//	    	carousel = (Carousel) findViewById(R.id.carousel_vertical);
//
//	    	// configurations for the carousel.
//	    	carousel.setType(Carousel.TYPE_COVERFLOW);
//	    	carousel.setOverScrollBounceEnabled(true);
//	    	carousel.setInfiniteScrollEnabled(false);
//	    	carousel.setItemRearrangeEnabled(true);
//
//	    	// set images for the carousel.
//	    	adapter = new ImageAdapter(subtypeList,crContext);    	
//	    	carousel.setAdapter(adapter);
//	    	//CarouselTypeListener cl = new CarouselTypeListener(carousel, this);
//	    	// change the first selected position.
//	    	carousel.setCenterPosition(2);
//	 	}
//		public class ImageAdapter<T> extends BaseAdapter {
//		    private Context mContext;
//		    //public Class<T> subtypeList; 
//		    public T subtypeList;
//		    public ImageAdapter(T classTypeObject, Context c) {
//		        this.subtypeList = classTypeObject; 
//		    	this.mContext = c; //context de LaunchTypeActivity
//		    }
//
//		    @Override
//		    public int getCount() {
//		        //return subtypeList.getSize();
//		    	return -1;
//		    }
//
//		    @Override
//		    public Object getItem(int position) {
//		        return null;
//		    }
//
//		    @Override
//		    public long getItemId(int position) {
//		        //return types[position];
//		    	return -1;
//		    }
//		    class ViewHolder {
//		        ImageView imageView;
//		        TextView textView;
//		    }
//		    
//		    public T getSubtypeList(){return subtypeList;}
//		    
//		    @Override
//		    public View getView(int position, View convertView, ViewGroup parent) {
//		    	ViewHolder holder;
//			        if (convertView == null) {
//			            holder = new ViewHolder();
//			            convertView = LayoutInflater.from(mContext).inflate(R.layout.carousel_item, null);      
//			            holder.imageView = (ImageView) convertView.findViewById(R.id.itemImage);   
//			            holder.textView = (TextView) convertView.findViewById(R.id.itemText);
//			            convertView.setTag(holder);
//			        } else {
//			            holder = (ViewHolder) convertView.getTag();
//			        }           
//			       // holder.textView.setText(subtypeList. .getName()); TO DO a corriger
//			        //ItemList item = (ItemList) ((PlaceList) getSubtypeList()).getItem(position);
//			        //holder.textView.setText(getSubtypeList().getItem(position).getName());
//			        holder.imageView.setImageResource(R.drawable.square);
//			        
//			    return convertView;
//		        
//		    }
//			};
//	};
};
