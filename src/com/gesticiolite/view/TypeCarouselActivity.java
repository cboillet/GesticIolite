package com.gesticiolite.view;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gesticiolite.R;
import com.gesticiolite.utils.Utils;
import com.gesticiolite.view.CarouselTypeListener;
import com.digitalaria.gama.carousel.Carousel;
import com.gesticiolite.type.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class TypeCarouselActivity extends Activity {
	private Carousel carousel;
	private Resources res;
	private ImageAdapter adapter;
	private ArrayList<ItemList> _types;
	private int _selectedType = -1;
 	private int[] types = { R.drawable.place, R.drawable.type,
			R.drawable.state};
 	private Point screenDimention = new Point();
 	private static Logger log = LoggerFactory.getLogger(TypeCarouselActivity.class);
 	  
 	
	@Override
	 public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.carousel_type_select);
	    Utils.hideNavigationButtons(this);
	    drawCarousel();
	    }
	
	public void launchSelectedType()
	{
        int selectedType = getSelectedType();
        System.out.println();
        if (selectedType != -1)
        {
            log.debug("launchSelectedType");
            //HostModel.Instance().setGame(selectedGame);
            Intent intent = new Intent(this, LaunchTypeActivity.class);
            switch (_selectedType)
            {
            	case 0: intent.putExtra("class", "PlaceList");
            	 		break;
            	case 1: intent.putExtra("class", "TypeList"); 
            			break;
            	case 2: intent.putExtra("class", "StateList");
            			break;
            
            }
            startActivity(intent);
        }
	}
	
	private int getSelectedType()
	{
		return _selectedType;
	}
	
    @SuppressLint("NewApi")
	private void getScreenSize()
    {
        Display display = getWindowManager().getDefaultDisplay();
        display.getSize(screenDimention);
    }
	
    private void drawCarousel() 
    {
    	res = getApplicationContext().getResources();
    	int diameter = (int) (screenDimention.x / 1.3);
    	
    	//set linear layout
        LinearLayout l = (LinearLayout) findViewById(R.id.carouselContainer);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lp.addRule(RelativeLayout.ALIGN_BOTTOM);
        lp.bottomMargin = (int) (- screenDimention.y);
        l.setLayoutParams(lp);

        // create the carousel object.
    	carousel = (Carousel) findViewById(R.id.carousel_horizontal);

    	// configurations for the carousel.
    	carousel.setType(Carousel.TYPE_COVERFLOW);
    	carousel.setOverScrollBounceEnabled(true);
    	carousel.setInfiniteScrollEnabled(false);
    	carousel.setItemRearrangeEnabled(true);

    	// set images for the carousel.
    	adapter = new ImageAdapter(this);    	
    	carousel.setAdapter(adapter);
    	CarouselTypeListener cl = new CarouselTypeListener(carousel, this);
//    	carousel.setOnItemClickListener(new OnItemClickListener() {
//    		@Override 
//    		public void OnItemClick(CarouselAdapter<?> parent, View view, int position, long id){
//    		}
//    	});
//    	
    	carousel.setOnItemClickListener(cl);

    	
    	
    	// change the first selected position.
    	carousel.setCenterPosition(2);	
    }
    
    
	private void updateTypeToLaunchLabel(String name)
	{
	}
	
    public void setTypeToLaunch(int index)
    {
        _selectedType = index;//_types.get(index);
        //updateTypeToLaunchLabel(_selectedType.getName());
    }
	
	public class ImageAdapter extends BaseAdapter {
	    private Context mContext;

	    public ImageAdapter(Context c) {
	        mContext = c;
	    }

	    @Override
	    public int getCount() {
	        return types.length;
	    }

	    @Override
	    public Object getItem(int position) {
	        return null;
	    }

	    @Override
	    public long getItemId(int position) {
	        return types[position];
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        View view = convertView;
	        if (view == null) {
	        view = LayoutInflater.from(mContext).inflate(R.layout.carousel_item, parent, false);
	        view.setLayoutParams(new Carousel.LayoutParams(450, 450));

	        ViewHolder holder = new ViewHolder();
	        holder.imageView = (ImageView) view.findViewById(R.id.itemImage);

	        view.setTag(holder);
	        }

	        ViewHolder holder = (ViewHolder) view.getTag();
	        holder.imageView.setImageResource(types[position]);

	        return view;
	    }

	    private class ViewHolder {
	        ImageView imageView;
	    }
	    }
}
