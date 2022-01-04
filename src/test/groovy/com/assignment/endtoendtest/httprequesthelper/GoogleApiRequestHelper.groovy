package com.assignment.endtoendtest.httprequesthelper

import com.assignment.endtoendtest.configuration.ConfigPropertiesUtil
import com.assignment.endtoendtest.endpoints.ApiEndPoints
import com.assignment.endtoendtest.helper.ExceptionHelper
import com.assignment.endtoendtest.utils.Constants
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovyx.net.http.RESTClient
import jodd.json.JsonSerializer
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class GoogleApiRequestHelper {
    private static Logger logger = LoggerFactory.getLogger(GoogleApiRequestHelper.class)

    static def restClient = new RESTClient(ConfigPropertiesUtil.GOOGLE_MAPS_BASE_URL)
    static def jsonSlurper = new JsonSlurper()

    static def contentType = "application/json"

    static def getDirections(def destination, def origin) {
        Connection.Response response
        try {
            def path = Constants.BASE_URL + ApiEndPoints.DIRECTIONS

            def request = [
                    key        : Constants.API_KEY,
                    destination: destination,
                    origin     : origin
            ]

//            logger.info("\nRequest URL: " + path + "\nRequest data : " + JsonOutput.toJson(request))
            logger.info("\nRequest URL: " + path + "\nRequest data : " + JsonSerializer.create().serialize(request))

            response = Jsoup.connect(path)
                    .ignoreContentType(true)
                    .data("key", Constants.API_KEY)
                    .data("destination", destination)
                    .data("origin", origin)
                    .method(Connection.Method.GET)
                    .execute()

            return response
        } catch (Exception ex) {
            return ExceptionHelper.handleException(ex)
        }
    }

    static def getPlaceFromText(String placeName) {
        Connection.Response response
        try {
            def path = Constants.BASE_URL + ApiEndPoints.FIND_PLACE_FROM_TEXT

            def request = [
                    key      : Constants.API_KEY,
                    input    : placeName,
                    inputtype: "textquery",
                    fields   : "formatted_address,name"
            ]

            //logger.info("\nRequest URL: " + path + "\nRequest data : " + JsonOutput.toJson(request))
            logger.info("\nRequest URL: " + path + "\nRequest data : " + JsonSerializer.create().serialize(request))

            response = Jsoup.connect(path)
                    .ignoreContentType(true)
                    .data("key", Constants.API_KEY)
                    .data("input", placeName)
                    .data("inputtype", "textquery")
                    .data("fields", "formatted_address,name")
                    .method(Connection.Method.GET)
                    .execute()

            return response
        } catch (Exception ex) {
            return ExceptionHelper.handleException(ex)
        }
    }

    static def geolocate() {
        Connection.Response response
        try {
            def path = Constants.BASE_URL + ApiEndPoints.GEOLOCATE

            def wifiAccessPoints = [
                    "macAddress"        : "84:d4:7e:09:a5:f1",
                    "signalStrength"    : -43,
                    "signalToNoiseRatio": 0
            ]

            def request = [
                    "considerIp"      : "false",
                    "wifiAccessPoints": wifiAccessPoints
            ]

            //logger.info("\nRequest URL: " + path + "\nRequest data : " + JsonOutput.toJson(request))
            logger.info("\nRequest URL: " + path + "\nRequest data : " + JsonSerializer.create().serialize(request))

            response = Jsoup.connect(path)
                    .ignoreContentType(true)
                    .data("key", Constants.API_KEY)
                    .data("considerIp", false as String)
                    .data("wifiAccessPoints", wifiAccessPoints as String)
                    .method(Connection.Method.POST)
                    .execute()

            return response
        } catch (Exception ex) {
            return ExceptionHelper.handleException(ex)
        }
    }
}
