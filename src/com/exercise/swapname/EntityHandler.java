package com.exercise.swapname;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;

class EntityHandler {

	JSONObject handle(HttpEntity entity) throws IllegalStateException, IOException, JSONException {
		BufferedReader input = new BufferedReader(new InputStreamReader(entity.getContent()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = input.readLine()) != null) {
			sb.append(line);
		}
		input.close();
		return new JSONObject(sb.toString());
	}
}
