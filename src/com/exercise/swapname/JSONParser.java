package com.exercise.swapname;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

class JSONParser {

	ArrayList<JSONObject> pack(ArrayList<PersonModel> checkData) throws JSONException {
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		for(PersonModel model : checkData) {
			JSONObject obj = new JSONObject();
			obj.put(PersonModel.FNAME_TAG, model.getFName());
			obj.put(PersonModel.SNAME_TAG, model.getSName());
			list.add(obj);
		}
		return list;
	}
	
	PersonModel unpack(JSONObject data) throws JSONException {
		PersonModel result = null;
		result = new PersonModel(data.getString(PersonModel.FNAME_TAG), data.getString(PersonModel.SNAME_TAG));
		return result;
	}
}
