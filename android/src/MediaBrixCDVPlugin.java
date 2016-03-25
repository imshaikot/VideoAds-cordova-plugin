package com.babysparks.plugins;

import java.text.MessageFormat;
import java.util.HashMap;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.app.Activity;

import com.mediabrix.android.api.IAdEventsListener;
import com.mediabrix.android.api.MediabrixAPI;

public class MediaBrixCDVPlugin extends CordovaPlugin implements IAdEventsListener {
    private static final String LOGTAG = "videoads";

 	public final static String BASE_URL = "https://mobile.mediabrix.com/v2/manifest";
 	public final static String APP_ID = "9uhMvwnULw";
 	public final static String AD_TARGET_VIEWS = "Android_Rescue";


 	public static CallbackContext cordovaCallback = null;
	JSONObject results = new JSONObject();
	public Boolean declearedInit = false;

	long closedTime;
	long readyTime;
	long unavailableTime = 0;
	long rewardTime;



 	private HashMap<String, String> createRewardsMbrixVars() {
		HashMap<String, String> vars = new HashMap<String, String>();
		vars.put("rewardText", "A BabySparks Activity");
		vars.put("useMBbutton", "false");
		vars.put("rewardIcon", "???");
		return vars;
	}

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

    	cordovaCallback = callbackContext;

        if (action.equals("init") && !declearedInit) {


            MediabrixAPI.getInstance().initialize(getActivity().getApplicationContext(), BASE_URL, APP_ID,
        			(IAdEventsListener) this);


    		MediabrixAPI.getInstance().onResume(getActivity().getApplicationContext());

        } else if (action.equals("loadAd")) {

            MediabrixAPI.getInstance().load(getActivity().getApplicationContext(), AD_TARGET_VIEWS,
            		createRewardsMbrixVars());
        } else if (action.equals("showAd")) {

        	MediabrixAPI.getInstance().show(getActivity(), AD_TARGET_VIEWS);
        }
        else
        {
            Log.d(LOGTAG, "execute:false");
            return false;

        }

		cordovaCallback.success("API call succeeded");
        return true;
    }

    String javaScriptEventTemplate =
            "var e = document.createEvent(''Events'');\n" +
            "e.initEvent(''{0}'');\n" +
            "e.tag = {1};\n" +
            "document.dispatchEvent(e);";

             @Override
                public void onPause(boolean multitasking) {

                    super.onPause(multitasking);
                    MediabrixAPI.getInstance().onPause(getActivity().getApplicationContext());
                }

                @Override
                public void onResume(boolean multitasking) {

                    super.onResume(multitasking);
                    MediabrixAPI.getInstance().onResume(getActivity().getApplicationContext());
                }


	@Override
	public void onAdClosed(String arg0) {

//		Log.v("Hola", "Shariar: Ad Closed");
//
//		this.webView.sendJavascript("");
//
//		try {
//			results.put("type", "onAdClosed");
//			results.put("message", "onAdClosed event fired");
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		cordovaCallback.success(results);

		if (closedTime == 0) {
			closedTime = System.currentTimeMillis();
			String command = MessageFormat.format(javaScriptEventTemplate, "onAdClosed", "''");
	        Log.v("Shariar", command);
	        this.webView.sendJavascript(command);
		} else {
			long isGet = System.currentTimeMillis() - closedTime;
			if (isGet > 1000) {
				closedTime = System.currentTimeMillis();
				String command = MessageFormat.format(javaScriptEventTemplate, "onAdClosed", "''");
		        Log.v("Shariar", command);
		        this.webView.sendJavascript(command);
			}
		}
	}

	@Override
	public void onAdReady(String arg0) {

//		try {
//			results.put("type", "onAdReady");
//			results.put("message", "onAdReady event fired");
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		cordovaCallback.success(results);
		if (readyTime == 0) {
			readyTime = System.currentTimeMillis();
			String command = MessageFormat.format(javaScriptEventTemplate, "onAdReady", "''");
	        Log.v("Shariar", command);
	        this.webView.sendJavascript(command);
		} else {
			long isGet = System.currentTimeMillis() - readyTime;
			if (isGet > 1000) {
				readyTime = System.currentTimeMillis();
				String command = MessageFormat.format(javaScriptEventTemplate, "onAdReady", "''");
		        Log.v("Shariar", command);
		        this.webView.sendJavascript(command);
			}
		}

	}

	@Override
	public void onAdRewardConfirmation(String arg0) {

//		try {
//			results.put("type", "onAdRewardConfirmation");
//			results.put("message", "onAdRewardConfirmation event fired");
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		cordovaCallback.success(results);
		if (rewardTime == 0) {
			rewardTime = System.currentTimeMillis();
			String command = MessageFormat.format(javaScriptEventTemplate, "onAdRewardConfirmation", "''");
	        Log.v("Shariar", command);
	        this.webView.sendJavascript(command);
		} else {
			long isGet = System.currentTimeMillis() - rewardTime;
			if (isGet > 1000) {
				rewardTime = System.currentTimeMillis();
				String command = MessageFormat.format(javaScriptEventTemplate, "onAdRewardConfirmation", "''");
		        Log.v("Shariar", command);
		        this.webView.sendJavascript(command);
			}
		}
	}

	@Override
	public void onAdUnavailable(String arg0) {
//		try {
//
//			results.put("type", "onAdUnavailable");
//			results.put("message", "Owa Snap, no ad available");
//
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		cordovaCallback.success(results);

		if (unavailableTime == 0) {
			unavailableTime = System.currentTimeMillis();
			String command = MessageFormat.format(javaScriptEventTemplate, "onAdUnavailable", "''");
	        Log.v("Shariar", command);
	        this.webView.sendJavascript(command);
		} else {
			long isGet = System.currentTimeMillis() - unavailableTime;
			if (isGet > 1000) {
				unavailableTime = System.currentTimeMillis();
				String command = MessageFormat.format(javaScriptEventTemplate, "onAdUnavailable", "''");
		        Log.v("Shariar", command);
		        this.webView.sendJavascript(command);
			}
		}



	}

	@Override
	public void onStarted(String arg0) {

		if (!declearedInit) {

        	declearedInit = true;

			String command = MessageFormat.format(javaScriptEventTemplate, "onInit", "''");
	        Log.v("Shariar", command);
	        this.webView.sendJavascript(command);
		}

	}

    private Activity getActivity() {
        return this.cordova.getActivity();
    }

}
