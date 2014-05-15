package com.exercise.swapname;

import java.util.ArrayList;

import org.json.JSONException;

import android.app.ListActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

class SendButtonListener implements OnClickListener {
	
	private ListActivity activity;

	SendButtonListener(ListActivity activity) {
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		JSONParser parser = new JSONParser();
		try {
			parser.pack(checkData());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	private ArrayList<PersonModel> checkData() {
		ListView list = activity.getListView();
		ArrayList<PersonModel> result = new ArrayList<PersonModel>();
		if(list.getCheckedItemCount() <= 0) {
			Toast.makeText(activity.getApplicationContext(), "No items selected!", Toast.LENGTH_SHORT).show();
		} else {
			SparseBooleanArray checkedItems = list.getCheckedItemPositions();
			for(int i = 0; i < list.getCount(); i++) {
				if(checkedItems.get(i) == true) {
					result.add((PersonModel) list.getItemAtPosition(i));
				}
			}
		}
		return result;
	}
}
