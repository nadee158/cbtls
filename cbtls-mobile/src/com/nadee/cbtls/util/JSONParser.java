package com.nadee.cbtls.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONParser {

	static JSONObject jObj = null;
	static String json = "";

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
}
