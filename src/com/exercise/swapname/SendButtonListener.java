package com.exercise.swapname;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

class SendButtonListener implements OnClickListener {
	
	private MainActivity activity = null;
	SparseBooleanArray checkedItems = null;

	SendButtonListener(MainActivity activity) {
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		JSONParser parser = new JSONParser();
		try {
			ArrayList<JSONObject> arr = parser.pack(checkData());
			ArrayList<PersonModel> persons = new ArrayList<PersonModel>();
			ExecutorService exec = Executors.newSingleThreadExecutor();
			for(JSONObject objToHandle : arr) {
				Future<?> result = exec.submit(new HttpRequestRunnable(objToHandle));
				JSONObject obj = (JSONObject) result.get();
				persons.add(parser.unpack(obj));
			}
			activity.updateList(persons);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	private ArrayList<PersonModel> checkData() {
		ListView list = activity.getListView();
		ArrayList<PersonModel> result = new ArrayList<PersonModel>();
		if(list.getCheckedItemCount() <= 0) {
			Toast.makeText(activity.getApplicationContext(), "No items selected!", Toast.LENGTH_SHORT).show();
		} else {
			checkedItems = list.getCheckedItemPositions();
			for(int i = 0; i < list.getCount(); i++) {
				if(checkedItems.get(i) == true) {
					result.add((PersonModel) list.getItemAtPosition(i));
				}
			}
		}
		activity.setLastChecked(result);
		return result;
	}
}
