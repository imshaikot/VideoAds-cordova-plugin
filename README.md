# MediaBrix Cordova Plugin v0.9.1

  This Plugin will work with Cordova 3.4.0 (Fully tested) to 4.0.0 (Untested).

  
  INSTALLATION
  
  `$ cordova platform android`
  
  `$ cordova plugin add https://github.com/babysparks/VideoAds`
  
  
  API USECASE
  
  ```javascript
  window.plugins.MediaBrixCDVPlugin.loadAd([successCallback], [failureCallback]);
  ```
  
  ```javascript
  window.plugins.MediaBrixCDVPlugin.showAd([successCallback], [failureCallback]);
  ```
  
  `Success` and `Failure` callbacks are optional.
  
  EVENT BIND/LISTENERS
  
  ```javascript
  document.addEventListener("onInit", function(){
      //Basically your event listener will goes here
  }, false); 
  // Bind initialize event listeners
  ```
  
  ```javascript
  document.addEventListener("onAdReady", function(){}, false);
  ```
   
  ```javascript
  document.addEventListener("onAdUnavailable", function(){}, false);
  ```
    
  ```javascript
  document.addEventListener("onAdClosed", function(){}, false);
  ```
  
  ```javascript
  document.addEventListener("onAdRewardConfirmation", function(){}, false);
  ```
  
  
  
  
 Please go through the `example/index.html` to understand more properly the use case. That's the html file from test app.
  
  
  

  Note: This plugin will initialize automatically on the cordova device ready event. You'll never need to initialize it manually.
  In case you need to have initialize it manually you'll be requiring to modify `www/MediaBrixCDVPlugin.js`
