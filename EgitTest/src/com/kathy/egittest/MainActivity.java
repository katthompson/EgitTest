package com.kathy.egittest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button myImageGalleryButton = (Button)findViewById(R.id.myImageGalleryButton);
		Button myCallLogButton = (Button)findViewById(R.id.myCallLogButton);
		Button myContactBookButton = (Button)findViewById(R.id.myContactBookButton);
		
		//accesses Image Gallery
		myImageGalleryButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent();
				myIntent.setAction(Intent.ACTION_VIEW);
				myIntent.setData(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
				startActivity(myIntent);
			}
		});
		
		myCallLogButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent();
				myIntent.setAction(Intent.ACTION_CALL_BUTTON);
				startActivity(myIntent);
			}
		});
		
		myContactBookButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent();
				myIntent.setAction(Intent.ACTION_VIEW);
				myIntent.setData(android.provider.ContactsContract.Contacts.CONTENT_URI);
				startActivity(myIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
