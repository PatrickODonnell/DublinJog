/*
 * THIS CODE IS A MODIFIED VERSION OF AN EXAMPLE FROM THE INTERNET
 * HERE IS A LINK TO THE ORGINIAL SOURCE
 * http://www.mkyong.com/android/android-spinner-drop-down-list-example/
 * 
 *
 * 
 * Please read the original source , it is not that difficult to understand
 * 
 * Any question, please ask
 * 
 * - Wayne
 * 
 * 
 * 
 * 
 * /* 
 * Classname Start.java
 * 
 * Version information e.g. Rev 2
 * 
 * Date e.g. 20/04/2013
 * 
 * @reference http://www.mkyong.com/android/android-spinner-drop-down-list-example/
 * @author Wayne Rochford, x11472332
 * 
 */



package com.drunkencow.dublinjog;


import com.google.android.gms.maps.model.LatLng;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Selection;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;



public class Start extends Activity {
	
	
	  private Spinner spinner1;//Holds value of spinner
	  private Button nextbut;
	  MediaPlayer buttonSound;
	 
	  
	  int choice;//Holds value of selection from spinner
	  
	  

	  public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.routelayout);
			
			
	  		//Buttons sounds
			buttonSound = MediaPlayer.create(Start.this, R.raw.button_click);
			
			addListenerOnButton();//Calls method
			
			
			
		  }
		  
	
		  
		  // get the selected dropdown list value
		  
		   public void addListenerOnButton() {
			 
			 
			
			spinner1 = (Spinner) findViewById(R.id.spinner1);
			nextbut = (Button) findViewById(R.id.btnSubmit);
			//Logic for listener
			nextbut.setOnClickListener(new OnClickListener() {
				
			
			
			
			  @Override
			  public void onClick(View v) {
				
				if (spinner1.getSelectedItemPosition()==0){
					
					
				
					choice = 0;
					
					Intent y = new Intent(Start.this, Maps.class);
					y.putExtra("Messenger", choice);//Packages the choice value to pass it over to the intent which is directed at the Maps class
					startActivityForResult(y, 0);
					finish();//kills activity
					//Displays message
					Toast.makeText(Start.this,
					String.valueOf(spinner1.getSelectedItem() + " selected. "),Toast.LENGTH_SHORT).show();
					buttonSound.start();
					
					
					
				
				}
				
				else if (spinner1.getSelectedItemPosition()==1){
					
					choice = 1;
					
					Intent y = new Intent(Start.this, Maps.class);
					y.putExtra("Messenger", choice);//Packages the choice value to pass it over to the intent which is directed at the Maps class
					startActivityForResult(y, 0);
					finish();//kills activity
					//Displays message
					Toast.makeText(Start.this,
					String.valueOf(spinner1.getSelectedItem() + " selected. "),Toast.LENGTH_SHORT).show();
					buttonSound.start();
					
		
					
				
					
				
				}
				
				else if (spinner1.getSelectedItemPosition()==2){
					
					choice = 2;
					
					Intent y = new Intent(Start.this, Maps.class);
					y.putExtra("Messenger", choice);//Packages the choice value to pass it over to the intent which is directed at the Maps class
					startActivityForResult(y, 0);
					finish();//kills activity
					//Displays message
					Toast.makeText(Start.this,
					String.valueOf(spinner1.getSelectedItem() + " selected. "),Toast.LENGTH_SHORT).show();
					buttonSound.start();
					
		
					
				
					
				
				}
				
				else if (spinner1.getSelectedItemPosition()==3){
	
					choice = 3;
	
					Intent y = new Intent(Start.this, Maps.class);
					y.putExtra("Messenger", choice);//Packages the choice value to pass it over to the intent which is directed at the Maps class
					startActivityForResult(y, 0);
					finish();//kills activity
					//Displays message
					Toast.makeText(Start.this,
					String.valueOf(spinner1.getSelectedItem() + " selected. "),Toast.LENGTH_SHORT).show();
					buttonSound.start();
	

	

				}
				
				
				
				
			  }
			  
			 
		 
			});
			

	
		   }

	
}

	
		
		
		
	
		  	  


