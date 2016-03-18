/*global cordova, module*/

module.exports = {
    test: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "VideoAds", "test", [name]);
    },
    loadAd: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "VideoAds", "loadAd", [name]);
    },
};
