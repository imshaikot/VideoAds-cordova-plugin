package com.babysparks.plugins;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//import android.app.Activity;

import com.mediabrix.android.api.IAdEventsListener;
import com.mediabrix.android.api.MediabrixAPI;

public class VideoAds extends CordovaPlugin {
    private static final String LOGTAG = "videoads";

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        Log.d(LOGTAG, "execute");
        if (action.equals("test")) {
            Log.d(LOGTAG, "execute:test");
            String name = data.getString(0);
            String message = "Loaded ( " + name + ")";
            callbackContext.success(message);

            return true;

        } else if (action.equals("loadAd")) {
            Log.d(LOGTAG, "execute:loadAd");
            
            MediabrixPlugin.Resume(); 
            MediabrixPlugin.Initialize ("https://mobile.mediabrix.com/v2/manifest", "9uhMvwnULw", this);
            
            //MediabrixAPI.getInstance().show(MBmain.this, "TEST");
            
            String name = data.getString(0);
            String message = "Will load ( " + name + ")";
            callbackContext.success(message);

            return true;

        } else {
            Log.d(LOGTAG, "execute:false");
            return false;

        }
    }

}
