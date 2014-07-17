/**  
 * Copyright © 2014ENGC. All rights reserved.
 * @Title: AbstractAppActivity.java
 * @Package: com.engc.jlcollege.ui.interfaces
 * @Description: TODO
 * @author: Administrator  
 * @date: 2014-7-7 下午6:49:35
 */
package com.engc.oamobile.ui.interfaces;

import java.util.ArrayList;

import com.engc.oamobile.support.asyncdrawable.BitmapDownloader;
import com.engc.oamobile.support.utils.GlobalContext;



import android.app.Activity;
import android.os.Bundle;

/**
 * Copyright © 2014ENGC. All rights reserved.
 * 
 * @Title: AbstractAppActivity.java
 * @Package: com.engc.jlcollege.ui.interfaces
 * @Description: Activity 父类
 * @author: wutao
 * @date: 2014-7-7 下午6:49:35
 */
public class AbstractAppActivity extends Activity {
	public static ArrayList<BackPressHandler> mListeners = new ArrayList<BackPressHandler>();
	protected BitmapDownloader commander = null;

	@Override
	protected void onResume() {
		super.onResume();
		GlobalContext.getInstance().setActivity(this);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// outState.putInt("theme", theme);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/*
		 * if (savedInstanceState == null) { theme =
		 * SettingUtility.getAppTheme(); } else { theme =
		 * savedInstanceState.getInt("theme"); } setTheme(theme);
		 */
		super.onCreate(savedInstanceState);

		commander = new BitmapDownloader();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		commander.totalStopLoadPicture();
		commander = null;
	}

	public BitmapDownloader getBitmapDownloader() {
		return commander;
	}

	public static abstract interface BackPressHandler {

		public abstract void activityOnResume();

		public abstract void activityOnPause();

	}

}
