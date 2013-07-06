/*
 * This is the main menu of our app
 * 
 * Very straight forward, It's basically linking all four buttons to all of there Individual activity's
 * 
 * The sound of the buttons and on the intro were all done by the videos I posted on the moodle page.
 * 
 * 
 * Any questions please ask
 * 
 * - Wayne
 * 
 * /* 
 * Classname  menu.java
 * 
 * Version information e.g. Rev 1
 * 
 /* 
 * Classname e.g. menu.java
 * 
 * Version information e.g. Rev 1
 * 
 * Date e.g. 18/03/13
 * 
 * @author Wayne Rochford, x11472332
 * 
 */ 

 
 

package com.drunkencow.dublinjog;

import com.facebook.*;
import com.facebook.model.*;
import com.facebook.android.Facebook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class menu extends Activity implements OnClickListener{
	
	
	ImageButton fb;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		setContentView(R.layout.main);
		super.onCreate(savedInstanceState);
		
		
		//Buttons sounds
		final MediaPlayer buttonSound = MediaPlayer.create(menu.this, R.raw.button_click);
	
		// Creates the button and sets layout
		Button but1 = (Button) findViewById(R.id.button1);
		Button but2 = (Button) findViewById(R.id.button2);
		Button but3 = (Button) findViewById(R.id.button3);
		Button but4 = (Button) findViewById(R.id.button4);
		Button exitBtn = (Button) findViewById(R.id.btnExit);
		
		
		//alert used to warn before exit
		final AlertDialog.Builder alert = new AlertDialog.Builder(this);
	    alert.setTitle("Exit");
	    alert.setMessage("Are you sure you want to exit the system?");
	    //sets confirmation button
	    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int end) { 
	            System.exit(0);
	        }
	     });
	    //sets cancel button
	    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int end) { 
	            dialog.cancel();
	        }
	     });
	     
		//Logic for button
		but1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonSound.start();
				startActivity(new Intent("com.drunkencow.dublinjog.START"));//stars activity
				finish();//kills activity
				
			}
		});
		//Logic for button
		but2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonSound.start();
				startActivity(new Intent("com.drunkencow.dublinjog.TROPHIES"));//Start activity
				finish();//kills activity
			}
		});
		//Logic for button
		but3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonSound.start();
				startActivity(new Intent("com.drunkencow.dublinjog.EVENTS"));//starts activity 
				finish();//kills activity
			}
		});
		//Logic for button
		but4.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {
		// TODO Auto-generated method stub
				buttonSound.start();
				startActivity(new Intent("com.drunkencow.dublinjog.LEADERBOARDS"));//starts activity
				finish();//kills activity
			}	
		});
		
		
		exitBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		// TODO Auto-generated method stub
				buttonSound.start();
				alert.show();
				finish();
				
			}	
		});
		

		
fb =(ImageButton) findViewById(R.id.fbb);
		//logic for facebook button
		fb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent("com.drunkencow.dublinjog.FACEBOOK"));//starts activity
				finish();//kills activity
			}
		});
		
		
		
	
	}
	
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
	}


	

	
	
	
}
