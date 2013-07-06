/*
 * The layout of this class is the xml layout of the trophielayout.xml as seen below 
 * 
 * 
 * Still more work need to be added. 
 * 
 * The home button does not do anything atm
 * 
 * Any questions please ask
 * 
 * - Wayne
 * 
 * /* 
 * Classname Trophies.java
 * 
 * Version information 
 * 
 * Date e.g. 20/03/13
 * 
 * @author Wayne Rochford x11472332
 * 
 * 
 * @author Shane Chambers x11452352
 * 
 * 
 * 
 */ 


package com.drunkencow.dublinjog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Trophies extends Activity {
	
	ImageButton im;//Declears ImageButton
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trophielayout);
		
		addListenerOnButton();//Calls the method
	}
	
	public void addListenerOnButton()
	{
		
		im =(ImageButton) findViewById(R.id.imageButton1);
		
		//Logic for the listener
		im.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent("com.drunkencow.dublinjog.MENU"));//Starts the menu activity
				finish();//kills the activity
			}
		});
	}
	

}
