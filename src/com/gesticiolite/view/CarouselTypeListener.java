package com.gesticiolite.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.digitalaria.gama.carousel.Carousel;
import com.digitalaria.gama.carousel.Carousel.OnItemSelectionUpdatedListener;


public class CarouselTypeListener implements  OnItemClickListener
{

    Carousel carousel;
    TypeCarouselActivity activity;

    public CarouselTypeListener(Carousel c, TypeCarouselActivity typeSelectActivity)
    {
        carousel = c;
        activity = typeSelectActivity;
    }


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
	    activity.setTypeToLaunch(position);
        activity.launchSelectedType();
		
	}

}

//public class CarouselTypeListener implements OnItemSelectionUpdatedListener, OnItemClickListener
//{
//
//    Carousel carousel;
//    TypeCarouselActivity activity;
//
//    public CarouselTypeListener(Carousel c, TypeCarouselActivity typeSelectActivity)
//    {
//        carousel = c;
//        activity = typeSelectActivity;
//    }
//
////    public void onItemSelectionUpdated(View view, int index)
////    {
////        activity.setTypeToLaunch(index);
////        activity.launchSelectedType();
////    }
//
//	@Override
//	public void onItemSelectionUpdated(AdapterView<?> parent, View view, int index) 
//	{
//		// TODO Auto-generated method stub
//	    activity.setTypeToLaunch(index);
//        activity.launchSelectedType();
//	}
//
//	@Override
//	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//		// TODO Auto-generated method stub
//	    activity.setTypeToLaunch(position);
//        activity.launchSelectedType();
//		
//	}
//
//}
