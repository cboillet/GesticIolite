//package com.gesticiolite.view;
//package view;
//
//import com.getisciolite.R;
//import com.digitalaria.gama.carousel.Carousel;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//
//
//public class carouselMain extends Activity {
//	
//	private Carousel carousel;
//	private ImageAdapter adapter;
//	private int[] types = { R.drawable.place, R.drawable.type,
//			R.drawable.state};
//
//	@Override
//	 public void onCreate(Bundle savedInstanceState) {
//	    super.onCreate(savedInstanceState);
//	    setContentView(R.layout.carousel_main);
//	    init();
//	    }
//
//	private void init() {
//	// create the carousel object.
//	carousel = (Carousel) findViewById(R.id.carousel);
//
//	// configurations for the carousel.
//	carousel.setType(Carousel.TYPE_COVERFLOW);
//	carousel.setOverScrollBounceEnabled(true);
//	carousel.setInfiniteScrollEnabled(false);
//	carousel.setItemRearrangeEnabled(true);
//
//	// set images for the carousel.
//	adapter = new ImageAdapter(this);
//	carousel.setAdapter(adapter);
//
//	// change the first selected position.
//	carousel.setCenterPosition(2);
//	}
//	public class ImageAdapter extends BaseAdapter {
//	    private Context mContext;
//
//	    public ImageAdapter(Context c) {
//	        mContext = c;
//	    }
//
//	    @Override
//	    public int getCount() {
//	        return types.length;
//	    }
//
//	    @Override
//	    public Object getItem(int position) {
//	        return null;
//	    }
//
//	    @Override
//	    public long getItemId(int position) {
//	        return types[position];
//	    }
//
//	    @Override
//	    public View getView(int position, View convertView, ViewGroup parent) {
//	        View view = convertView;
//	        if (view == null) {
//	        view = LayoutInflater.from(mContext).inflate(R.layout.carousel_item, parent, false);
//	        view.setLayoutParams(new Carousel.LayoutParams(450, 450));
//
//	        ViewHolder holder = new ViewHolder();
//	        holder.imageView = (ImageView) view.findViewById(R.id.itemImage);
//
//	        view.setTag(holder);
//	        }
//
//	        ViewHolder holder = (ViewHolder) view.getTag();
//	        holder.imageView.setImageResource(types[position]);
//
//	        return view;
//	    }
//
//	    private class ViewHolder {
//	        ImageView imageView;
//	    }
//	    }
//}
