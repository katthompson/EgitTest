package com.kathy.egittest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
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
		Button myNotificationButton = (Button) findViewById(R.id.myNotificationButton);
		
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
		
		myNotificationButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				Context context = MainActivity.this;
				Intent intent = new Intent(context, MainActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
				NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
				
				builder.setSmallIcon(android.R.drawable.stat_notify_more)
					.setTicker("New Notification")
					.setContentTitle("New Message")
					.setContentText("You have a new message.")
					.setContentIntent(pendingIntent)
					.setWhen(System.currentTimeMillis());
				
				Notification note = builder.build();			
				nm.notify(0, note);
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
