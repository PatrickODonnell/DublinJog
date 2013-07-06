/*
 * All of this code was done by the help of the videos I posted on the moodle page
 * 
 * Should be ok to understand 
 * 
 * Any questions please ask
 * 
 * - Wayne
 * 
 * 
 * main.java
 * 
 * Date e.g. 20/03/13 
 * 
 * @reference http://http://thenewboston.org/
 * @author Wayne Rochford, x11472332
 * 
 */


package com.drunkencow.dublinjog;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class main extends Activity{

	MediaPlayer song;//declears song

	@Override
	protected void onCreate(Bundle var) {
		// TODO Auto-generated method stub
		super.onCreate(var);
		setContentView(R.layout.splash);//sets layout view to splash
		song = MediaPlayer.create(main.this, R.raw.u2);
		song.start();//song starts
		Thread timer = new Thread (){
		public void run(){
			
			try{
				
				sleep(5000);//Five second delay
				
			}catch (InterruptedException e){
			
			e.printStackTrace();	
				
			}finally{
				
				Intent menuIntent = new Intent("com.drunkencow.dublinjog.LOGIN");//starts login activity
				startActivity(menuIntent);
				finish();//kills activity
				
			}
			
		}
			
		};
		
		timer.start();//starts timer
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
		finish();//kills activity
		
	}
	
}
