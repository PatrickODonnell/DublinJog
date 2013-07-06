/*
 * The layout of this class is the xml layout of the eventslayout.xml as seen below 
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
 * 
 * 
 */

/* 
 * Classname e.g. Events.java
 * 
 * Version information e.g. Rev 1
 * 
 * Date e.g. 14/03/13
 * 
 * @author x11472332 Wayne Rochford
 * 
 */ 
package com.drunkencow.dublinjog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Events extends Activity {
	
	ImageButton im;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eventslayout);
		
		addListenerOnButton();//Calls method
	}
	
	public void addListenerOnButton()
	{
		
		im =(ImageButton) findViewById(R.id.imageButton1);
		
		im.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent("com.drunkencow.dublinjog.MENU"));//Starts menu activity
				finish();//kills activity
			}
		});
	}
}
