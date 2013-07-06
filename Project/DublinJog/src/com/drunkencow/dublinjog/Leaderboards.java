/*
 * The layout of this class is the xml layout of the button2.xml as seen below 
 * 
 * 
 * It displays the page correctly, but atm it seems to be crashing once I try add a button, to link back to the home page
 * 
 * 
 * The intent as seen below is trying to access the menu class, but this is not working
 * 
 * 
 * Any questions please ask
 * 
 * - Wayne
 * 
 * 
 * 
 */

package com.drunkencow.dublinjog;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Leaderboards extends Activity implements OnClickListener{
	
	ImageButton im;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.leaderboardlayout);
		
		addListenerOnButton();
	
	}
	
	
	public void addListenerOnButton()
	{
		
		im =(ImageButton) findViewById(R.id.imageButton12);
		
		im.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent("com.drunkencow.dublinjog.MENU"));
				finish();
			}
		});
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}




}
	

