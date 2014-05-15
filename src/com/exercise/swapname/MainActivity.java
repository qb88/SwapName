package com.exercise.swapname;

import java.util.ArrayList;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	private static final int SIZE_LIMIT = 5;
	private Button btnSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayAdapter<PersonModel> adapter = new ArrayAdapter<PersonModel>(this, android.R.layout.simple_list_item_multiple_choice, getLocalContacts());
		setListAdapter(adapter);
		setContentView(R.layout.activity_main);
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		btnSend = (Button)findViewById(R.id.btnSend);
		btnSend.setOnClickListener(new SendButtonListener(this));
	}

	private PersonModel[] getLocalContacts() {
		ArrayList<PersonModel> tmp = new ArrayList<PersonModel>();
		ContentResolver contacts = getContentResolver();
		Cursor cursor = contacts.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		int counter = 0;
		if(cursor.getCount() > 0) {
			cursor.moveToFirst();
			do {
				String str = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				PersonModel person = new PersonModel(str);
				tmp.add(person);
				counter++;
			} while(cursor.moveToNext() && counter < SIZE_LIMIT);
		} else {
			Toast.makeText(getApplicationContext(), "Contacts not found!", Toast.LENGTH_SHORT).show();
		}
		cursor.close();
		
		PersonModel[] result = new PersonModel[tmp.size()];
		tmp.toArray(result);
		return result;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
