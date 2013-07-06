package com.drunkencow.dublinjog;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.y;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Chronometer;
import android.os.SystemClock;

/* 
 * Classname e.g. Maps.java
 * 
 * Version information e.g. Rev 1
 * 
 * Date e.g. 28/04/13
 * 
 * @reference http://www.vogella.com/articles/AndroidGoogleMaps/article.html
 * @author Wayne Rochford, x11472332
 * 
 */

public class Maps extends Activity implements LocationListener{
	
	Button stop; //Declares stop
	ImageButton im;//Declares im
	DatabaseManager db = new DatabaseManager(this);//Declears database
	Chronometer myChrono;//Declares Chronometer
	TextView t;//Declears t
	
	 //Declares Variable
	  private GoogleMap m; 
	  private int choice;
	  final LatLng SPIRE = new LatLng(53.349822,-6.260351);	//Latitude + longitude variables
	  final LatLng PPARK = new LatLng(53.356111,-6.328889);	
	  final LatLng ITOWER = new LatLng(53.345227,-6.268074);
	  final LatLng NBG = new LatLng(53.372367,-6.272716);
	  final LatLng CHC = new LatLng(53.343397,-6.271262);
	  private boolean isArrived;
      long TimeTaken;
      String comp ="Route Complete";
      long Completion;

	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mapslayout);
	
	   //////////////////////////////////////////
	    Bundle extras = getIntent().getExtras();
	    final int choice = extras.getInt("Messenger");
	    addStopButton();
	    addListenerOnImageButton();
	    
	    /////////////////////////////////////////

	    //^^^Gets the value from the choice variable from the Start class, which was packaged 

	    
		
		 m = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		.getMap(); //Finds the MapFragment
		 
		 
		 //If the selection is the first option
		 if(choice==0){
	
			 
	    m.moveCamera(CameraUpdateFactory.newLatLngZoom(SPIRE, 16));
		// Zoom in, animating the camera.
	    
		m.animateCamera(CameraUpdateFactory.zoomTo(11), 2000, null); 
	    
		m.setMapType(GoogleMap.MAP_TYPE_NORMAL);//Sets the map type
		
		//Properties for the location
	      Marker spire = m.addMarker(new MarkerOptions().position(SPIRE)
	          .title("The Spire")
	         .snippet("You are here")
	      .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
	    //Properties for the location
	      Marker itower = m.addMarker(new MarkerOptions().position(ITOWER)
	    	.title("Isoldes Tower")
	    	.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
	      //Displays message
	      Toast.makeText(getApplicationContext(), "Please use the controls on the right to zoom in", Toast.LENGTH_LONG).show();
	      //Draws the polygon
	      Polygon polygon = m.addPolygon(new PolygonOptions()
	      .add(new LatLng(53.349822,-6.260351), new LatLng(
	    		  53.345227,-6.268074))
	      .strokeColor(Color.RED)
	      .fillColor(Color.BLUE));
	      
	      
	      	
		 }
		 
		 //If selection is the second option
		 
		 else if(choice==1){
			 
			    m.moveCamera(CameraUpdateFactory.newLatLngZoom(SPIRE, 16));
				// Zoom in, animating the camera.
			    
				m.animateCamera(CameraUpdateFactory.zoomTo(11), 2000, null); 
			    //Map type is normal
				m.setMapType(GoogleMap.MAP_TYPE_NORMAL);
				
				//Properties for the location
			      Marker spire = m.addMarker(new MarkerOptions().position(SPIRE)
			          .title("The Spire")
			         .snippet("You are here")
			      .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
			    //Properties for the location
			      Marker ppark = m.addMarker(new MarkerOptions().position(PPARK)
			    	.title("Phoenix Park")
			    	.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
			      
			      Toast.makeText(getApplicationContext(), "Please use the controls on the right to zoom in", Toast.LENGTH_LONG).show();
			    //Draws polygon
			      Polygon polygon = m.addPolygon(new PolygonOptions()
			      .add(new LatLng(53.349822,-6.260351), new LatLng(
			    		  53.356111,-6.328889))
			      .strokeColor(Color.RED)
			      .fillColor(Color.BLUE));
			      	
				 }
		 
		 //
		 
		 
	  
		 //If selection is the third option
	 
	 else if(choice==2){
		 m.moveCamera(CameraUpdateFactory.newLatLngZoom(SPIRE, 16));
			// Zoom in, animating the camera.
		    
			m.animateCamera(CameraUpdateFactory.zoomTo(11), 2000, null); 
		    
			m.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			
			//Properties for the location
		      Marker spire = m.addMarker(new MarkerOptions().position(SPIRE)
		          .title("The Spire")
		         .snippet("You are here")
		      .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
		    //Properties for the location
		      Marker chc = m.addMarker(new MarkerOptions().position(CHC)
		    	.title("Christ Church")
		    	.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
		      
		      Toast.makeText(getApplicationContext(), "Please use the controls on the right to zoom in", Toast.LENGTH_LONG).show();
		    //Draws polygon
		      Polygon polygon = m.addPolygon(new PolygonOptions()
		      .add(new LatLng(53.349822,-6.260351), new LatLng(
		    		  53.343397,-6.271262))
		      .strokeColor(Color.RED)
		      .fillColor(Color.BLUE));
		   
	 //
	 }
		 
	//If selection is the forth option
	 else if(choice==3){
	 
	 
	 //
	 m.moveCamera(CameraUpdateFactory.newLatLngZoom(SPIRE, 16));
		// Zoom in, animating the camera.
	    
		m.animateCamera(CameraUpdateFactory.zoomTo(11), 2000, null); 
	    
		m.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
	   //Properties for location
	      Marker spire = m.addMarker(new MarkerOptions().position(SPIRE)
	          .title("The Spire")
	         .snippet("You are here")
	      .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
	      //Properties for location
	      Marker nbg = m.addMarker(new MarkerOptions().position(NBG)
	    	.title("National Botanic Gardens")
	    	.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
	      //Displays message
	      Toast.makeText(getApplicationContext(), "Please use the controls on the right to zoom in", Toast.LENGTH_LONG).show();
	      //Draws polygon
	      Polygon polygon = m.addPolygon(new PolygonOptions()
	      .add(new LatLng(53.349822,-6.260351), new LatLng(
	    		  53.372367,-6.272716))
	      .strokeColor(Color.RED)
	      .fillColor(Color.BLUE));
	      	
		 }
		
		 /*Patrick's Code : Largely influenced by http://developer.android.com/guide/topics/location/strategies.html for the GPS 
		 and http://www.shawnbe.com/index.php/tutorial/tutorial-3-a-simple-stopwatch-lets-add-the-code/ for the stopwatch*/
		
		 myChrono = (Chronometer) findViewById(R.id.StopWatch);
		 myChrono.start();

		 final LocationManager myLM=
					(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		 
		  //Specifies I want to use a GPS and the rate of updates on location
			myLM.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 2, this);
			
		 // Listener for the location updates 
			LocationListener myLL = new LocationListener(){
				
				public void onProviderDisabled(String provider) {
					//Make a toast to tell user GPS is disabled
					Toast.makeText( getApplicationContext(),"GPS Disabled. Please enable GPS tracking in Settings", Toast.LENGTH_LONG).show();
				}
				
			

				public void onProviderEnabled(String provider) {
					
					
				
				}

				public void onStatusChanged(String provider, int status, Bundle extras) {
				
					
				}
				

				// method to get the current location in Latitude and longitude and to check to see if the user has completed the route.
				public void onLocationChanged(Location location) {
					 double lat = (double) (location.getLatitude());
					 double lng = (double) (location.getLongitude());
					
					//compare the current location against the selected routes end point.
					 if(choice==0){
						 if(lat == 53.345227 && lng ==-6.268074){
							 isArrived=true;
							 
						//Stops the GPS from updating the current position
							 myLM.removeUpdates(this);
						 	}
					 	}
					 else if(choice==1){
						 if(lat == 53.356111 && lng == -6.328889){
							 isArrived=true;
							 myLM.removeUpdates(this);
						 	}
					 	}
					 
					 else if(choice==2){
						 if(lat ==53.343397 && lng==-6.271262){
							 isArrived=true;
							 myLM.removeUpdates(this);
							 
						 	}
					 	}
					 
					 else if(choice==3){
						 if(lat == 53.372367 && lng == -6.272716){
							 isArrived=true;
							 myLM.removeUpdates(this);
						 	}
					 	}
					}
				
				};    	
			        
			      //The stopwatch will stop when the route is finished
					if( isArrived==true){	
					myChrono.stop();
					
					// save time taken and which course was completed to the database.
					    db.open();
						
						if(choice==0){
							Completion = db.insertEntry(null, null, null,null,comp,null,null,((Chronometer)findViewById(R.id.StopWatch)).getText().toString());
						 	}
						 else if(choice==1){
						    Completion = db.insertEntry(null, null, null,comp,null,null,null,((Chronometer)findViewById(R.id.StopWatch)).getText().toString());
						 	}
						 
						 else if(choice==2){
						    Completion = db.insertEntry(null, null, null,null,null,null,comp,((Chronometer)findViewById(R.id.StopWatch)).getText().toString());
						 	}
						 
						 else if(choice==3){
							  Completion = db.insertEntry(null, null, null,null,null,comp,null,((Chronometer)findViewById(R.id.StopWatch)).getText().toString());
						 	}
						db.close();
					}

			        
			}
			//Patricks stop button, slighty modified by Wayne
	public void addStopButton()
	{
		
		myChrono = (Chronometer) findViewById(R.id.StopWatch);
		t = (TextView) findViewById(R.id.textView3);
		
		stop =(Button) findViewById(R.id.stop);
		
		stop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			
				
				
			 myChrono.stop();
			 stop.setVisibility(View.INVISIBLE);//Sets stop button invisible
			 t.setVisibility(View.VISIBLE);//Sets the text button visible
			 
			
				
			}
		});
		
	
		
		
	}
    
			//Patricks code for the home button, slightly  changed by Wayne
			
	public void addListenerOnImageButton()
		{
			
		  
		  
			im =(ImageButton) findViewById(R.id.imageButton1);
			
			im.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					startActivity(new Intent("com.drunkencow.dublinjog.MENU"));//Starts the menu activity
					finish();//kills activity
					
				}
			});
			
			
			
		}
	
	 
	


	


	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	
	}

	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}

	
	

}
		




		



