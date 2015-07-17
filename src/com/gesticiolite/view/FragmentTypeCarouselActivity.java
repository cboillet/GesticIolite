package com.gesticiolite.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gesticiolite.R;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/*Not used for the moment*/

public class FragmentTypeCarouselActivity extends Fragment {
    private static Logger log = LoggerFactory.getLogger(FragmentTypeCarouselActivity.class);

    private Point _screenDimention = new Point();
    private View _rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        _rootView = inflater.inflate(R.layout.fragment_activity_type_carousel, container, false);
        getScreenSize();
        return _rootView;
    }

	private void getScreenSize() 
	{
		
	}
}
