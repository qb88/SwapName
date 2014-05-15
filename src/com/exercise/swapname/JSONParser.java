package com.exercise.swapname;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {

	public void pack(ArrayList<PersonModel> checkData) throws JSONException {
		JSONArray arr = new JSONArray();
		for(PersonModel model : checkData) {
			JSONObject obj = new JSONObject();
			obj.put(PersonModel.FNAME_TAG, model.getFName());
			obj.put(PersonModel.SNAME_TAG, model.getSName());
			arr.put(obj);
		}
	}
	
	public ArrayList<PersonModel> unpack(String data) throws JSONException {
		ArrayList<PersonModel> result = new ArrayList<PersonModel>();
		JSONArray arr = new JSONArray(data);
		for(int i = 0; i < arr.length(); i++) {
			JSONObject obj = arr.getJSONObject(i);
			result.add(new PersonModel(obj.getString(PersonModel.FNAME_TAG), obj.getString(PersonModel.SNAME_TAG)));
		}
		return result;
	}
}
