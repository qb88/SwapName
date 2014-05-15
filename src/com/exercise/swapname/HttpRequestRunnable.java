package com.exercise.swapname;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

class HttpRequestRunnable implements Callable<JSONObject> {

	private JSONObject data;
	HttpRequestRunnable(JSONObject arr) {
		this.data = arr;
	}

	@Override
	public JSONObject call() throws Exception {
		try {
			EntityHandler handler = new EntityHandler();
			DefaultHttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost("http://10.0.2.2:8881");
			
			StringEntity entity = new StringEntity(data.toString());
			post.setEntity(entity);
			
			HttpResponse response = client.execute(post);
			HttpEntity responseEntity = response.getEntity();
			
			return handler.handle(responseEntity);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
