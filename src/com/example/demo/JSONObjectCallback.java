package com.example.demo;

import org.json.JSONObject;

import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

public abstract class JSONObjectCallback extends Callback<JSONObject> {
	@Override
	public void onError(Call arg0, Exception arg1) {
		System.out.println("onError");
	}
	@Override
	public abstract void onResponse(JSONObject arg0);
	@Override
	public JSONObject parseNetworkResponse(Response arg0) throws Exception {
		System.out.println("parseNetworkResponse");
		JSONObject obj = new JSONObject(arg0.body().string());
		return obj;
	}
}
