/**
 * @constructor
 */
var MediaBrixCDVPlugin= function () {};

/**
 * @type {{initialize: Function, loadAd: Function, showAd: Function}}
 */
MediaBrixCDVPlugin.prototype = {
	initialize: function() {
		cordova.exec(function(){}, function() {}, 'MediaBrixCDVPlugin', 'init', []);
	},

	// Load the add
	// Make sure you didn't load ad before initializing MediaBrix SDK
	loadAd: function(successCB, errorCB) {
		successCB = typeof successCB == 'undefined' ? function() {} : successCB;
		errorCB = typeof errorCB == 'undefined' ? function() {} : errorCB;

		cordova.exec(successCB, errorCB, 'MediaBrixCDVPlugin', 'loadAd', []);
	},

	// Show the loaded ad
	// Make sure you don't hit this before loaded or initiate
	// If you call this method initialize your app will crash since there is no exception handler
	// in this case on SDK.
	showAd: function(successCB, errorCB) {
		successCB = typeof successCB == 'undefined' ? function() {} : successCB;
		errorCB = typeof errorCB == 'undefined' ? function() {} : errorCB;

		cordova.exec(successCB, errorCB, 'MediaBrixCDVPlugin', 'showAd', []);
	}
};

/**
 * @returns {MediaBrixCDVPlugin|*}
 */
MediaBrixCDVPlugin.install = function() {
	if (!window.plugins) {
		window.plugins = {};
	}

	window.plugins.MediaBrixCDVPlugin = new MediaBrixCDVPlugin();

	return window.plugins.MediaBrixCDVPlugin;
};

cordova.addConstructor(MediaBrixCDVPlugin.install);

document.addEventListener('deviceready', function() {
	// Auto Initialize the plugin
	// It'll force to fire the init event
	window.plugins.MediaBrixCDVPlugin.initialize();
}, false);