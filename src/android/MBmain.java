package com.babysparks.plugins;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Dialog

import java.util.HashMap;

import com.mediabrix.android.api.IAdEventsListener;
import com.mediabrix.android.api.MediabrixAPI;


public class MBmain extends Activity implements IAdEventsListener {
	// These 5 string values will be provided by MediaBrix
	public final static String BASE_URL = "https://mobile.mediabrix.com/v2/manifest";
	public final static String APP_ID = "9uhMvwnULw";

	private TextView labelFlexStatus;
	private TextView labelViewsStatus;
	private TextView labelRewardsStatus;
	private TextView labelMBStatus;

	private Button buttonFlexStart;
	private Button buttonViewsStart;
	private Button buttonRewardStart;

	private Button buttonFlexLoad;
	private Button buttonViewsLoad;
	private Button buttonRewardLoad;

	private EditText txtFlexTitle;
	private EditText txtFlexLoading;
	private EditText txtViewsEntice;
	private EditText txtViewsRescueTitle;
	private EditText txtViewsRescueText;
	private EditText txtViewsRewardText;
	private EditText txtViewsRewardItem;
	private EditText txtViewsOptInText;
	private EditText txtRewardsReward;
	private EditText txtRewardsRewardItem;
	private EditText txtRewardsAchieve;

	private Long flexTime;
	private Long viewsTime;
	private Long rewardsTime;
	private Long manifestTime;
	
	private boolean viewsRewarded;
	private boolean rewardsRewarded;

  HashMap<String, String> vars = new HashMap<String, String>();
  vars.put("rewardText", "MediaBrix2015");
         
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  
    MediabrixAPI.getInstance().initialize(MBmain.this, BASE_URL, APP_ID, this);
  }
  
  
  @Override 
  public void onResume() {
    MediaBrixAPI.getInstance().onResume(this) ;
  
    /* only required when loading/showing ads from second activity */
    MediabrixAPI.getInstance().initialize(MBmain.this, BASE_URL, APP_ID, this);
  
    super.onResume();
  } 
  
  @Override
    protected void onPause() {
    MediabrixAPI.getInstance().onPause(this);
    
    super.onPause();
  }
  
  @Override
  public void onDestroy() { 
  
    /* Only call onDestroy if this is the last or only activity for loading/showing an ad */
  
    MediabrixAPI.getInstance().onDestroy(this);
    super.onDestroy();
  }



  //MediaBrix IAdEventsListener Callbacks
  
  @Override
  public void onStarted(String status) {
    // MediaBrix SDK has been initialized successfully

    MediabrixAPI.getInstance().load(MBmain.this, "Android_Rescue", vars);
    
    //AlertDialog alertDialog = alertDialogBuilder.create();
    //alertDialog.show();
    
  }
   
  @Override
  public void onAdReady(String target) {
    Log.d("MBmain", "onAdReady(" + target + ")");
    if (AD_TARGET_FLEX.equals(target)) {
      // do something specific to the target Zone 
      
      MediabrixAPI.getInstance().show(MBmain.this, String target);
    }
  }
   
  @Override
  public void onAdUnavailable(String target) {
    Log.d("MBmain", "onAdUnavailable(" + target + ")");
    if (AD_TARGET_FLEX.equals(target)) {
      // do something here when the Ad load  fails
    }
  }
  
  @Override
  public void onRewardConfirmation(String target) {
    // your user should be granted some credit or features unlocked. 
  }
  
  @Override
  public void onAdClosed(String target) {
    Log.d("MBmain", "onAdClosed(" + target + ")");
    if (AD_TARGET_FLEX.equals(target)) {
      // do something after the ad is closed
    }
    

 
} 



}