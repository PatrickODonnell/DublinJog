 /*
 
 * 
 * Facebook.java
 * 
 * Date e.g. 30/04/13
 * 
 * @reference https://developers.facebook.com/android/
 * @author Wayne Rochford, x11472332
 * 
 */
package com.drunkencow.dublinjog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Facebook extends FragmentActivity{
	
	
	
	private static final String TAG = "MainFragment";//constant for tag fragment
    private MainFragment mainFragment;
   
    
    

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facebook);
		
		
		
		
		if(savedInstanceState==null)
		{
			
			

		// Add the fragment on initial activity setup
		mainFragment = new MainFragment();
		getSupportFragmentManager()
		.beginTransaction()
		.add(android.R.id.content, mainFragment)
		.commit();

		}

		else
		{


			
		// Or set the fragment from restored state info
		mainFragment = (MainFragment) getSupportFragmentManager()
		.findFragmentById(android.R.id.content);
		

		}
		
	}
		
	
	}



	

	



