package com.nadee.cbtls.util;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.google.gson.Gson;

public class JSONParser {

  static JSONObject jObj = null;
  static JSONArray jArr = null;
  static String json = "";
  public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

  // constructor
  public JSONParser() {

  }

  public JSONObject getJSONFromUrl(String url) {

    try {

      OkHttpClient client = new OkHttpClient();

      Request request = new Request.Builder().url(url).build();

      Response response = client.newCall(request).execute();

      json = response.body().string();

      System.out.println("json :" + json);

    } catch (Exception e) {
      Log.e("Buffer Error", "Error converting result " + e.toString());
    }

    // try parse the string to a JSON object
    try {
      jObj = new JSONObject(json);
    } catch (JSONException e) {
      Log.e("JSON Parser", "Error parsing data " + e.toString());
    }

    // return JSON String
    return jObj;

  }

  public JSONArray getJSONArrayFromUrl(String url) {

    try {

      OkHttpClient client = new OkHttpClient();

      Request request = new Request.Builder().url(url).build();

      Response response = client.newCall(request).execute();

      json = response.body().string();

      System.out.println("json :" + json);

    } catch (Exception e) {
      Log.e("Buffer Error", "Error converting result " + e.toString());
    }

    // try parse the string to a JSON array
    try {
      jArr = new JSONArray(json);
    } catch (JSONException e) {
      Log.e("JSON Parser", "Error parsing data " + e.toString());
    }

    // return JSON String
    return jArr;

  }

  public JSONArray postJSONArrayFromUrl(String url, Object object) {

    try {

      Gson gson = new Gson();

      String jsonPost = gson.toJson(object);
      RequestBody body = RequestBody.create(JSON, jsonPost);

      OkHttpClient client = new OkHttpClient();

      Request request = new Request.Builder().url(url).post(body).build();

      Response response = client.newCall(request).execute();

      json = response.body().string();

      System.out.println("json :" + json);

    } catch (Exception e) {
      Log.e("Buffer Error", "Error converting result " + e.toString());
    }

    // try parse the string to a JSON array
    try {
      jArr = new JSONArray(json);
    } catch (JSONException e) {
      Log.e("JSON Parser", "Error parsing data " + e.toString());
    }

    // return JSON String
    return jArr;

  }


  public JSONObject postJSONFromUrl(String url, Object object) {

    try {

      Gson gson = new Gson();

      String jsonPost = gson.toJson(object);
      RequestBody body = RequestBody.create(JSON, jsonPost);

      OkHttpClient client = new OkHttpClient();

      Request request = new Request.Builder().url(url).post(body).build();

      Response response = client.newCall(request).execute();

      json = response.body().string();

      System.out.println("post josn json :" + json);

    } catch (Exception e) {
      Log.e("Buffer Error", "Error converting result " + e.toString());
    }

    // try parse the string to a JSON array
    try {
      jObj = new JSONObject(json);
    } catch (JSONException e) {
      Log.e("JSON Parser", "Error parsing data " + e.toString());
    }

    // return JSON String
    return jObj;

  }
}
