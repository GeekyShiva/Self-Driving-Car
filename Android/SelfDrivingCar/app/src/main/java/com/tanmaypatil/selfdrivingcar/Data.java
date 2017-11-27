package com.tanmaypatil.selfdrivingcar;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONObject;

/**
 * Created by tanmaypatil on 15/11/17.
 */

public class Data {
    static float currentHeading;
    static float diffHeading;
    static LatLng currentLocation;
    static String direction;
    static JSONObject jsonObject;
    static double altitude;

    static

    public LatLng getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(LatLng c) {
        currentLocation = c;
    }

    public float getDiffHeading() {
        return diffHeading;
    }

    public void setDiffHeading(float d) {
        diffHeading = d;
    }


    public JSONObject getJsonObject() {
        makeJSON();
        return jsonObject;
    }


    public String getDirection() {
        return direction;
    }

    public void setDirection(String d) {
        direction = d;
    }

    public float getCurrentHeading() {

        return currentHeading;
    }

    public void setCurrentHeading(float c) {
        currentHeading = c;
        // makeJSON();
    }

    public void makeJSON() {

        // main jsonObject
        JSONObject json = new JSONObject();
        // location JSONObject
        JSONObject jsonData = new JSONObject();
        try {
            // put key-value in  jsonlocation JSONObject
            jsonData.put("compass", diffHeading);  //<< put lat
            jsonData.put("directions", direction);  //<< put lng

            // put jsonlocation in main json JSONObject

            json.put("Data", jsonData);
            jsonObject = json;
        } catch (Exception e) {
            Log.e("JSON", e.getMessage());
        }
    }

    public void setAltitude(double alt) {
        altitude = alt;
    }
}
