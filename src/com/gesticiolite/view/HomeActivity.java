package com.gesticiolite.view;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gesticiolite.R;
import com.gesticiolite.utils.Utils;
import com.gesticiolite.view.FragmentTypeCarouselActivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

public class HomeActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.home_activity);
	    Utils.hideNavigationButtons(this);
	    //Fragment fragment = new FragmentTypeCarouselActivity();
        Intent intent = new Intent(this, TypeCarouselActivity.class);
        startActivity(intent);
	}
}
