/* 
 * Classname MainFragment.java
 * 
 * Version information e.g. Rev 1
 * 
 * Date e.g. 26/04/2013
 * 
 * @reference https://developers.facebook.com/docs/howtos/androidsdk/3.0/login-with-facebook/
 * @author Wayne Rochford, x11472332
 * 
 */

package com.drunkencow.dublinjog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.LoginButton;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.OnCompleteListener;

//@reference https://developers.facebook.com/docs/howtos/androidsdk/3.0/login-with-facebook/
//Sightly modified
public class MainFragment extends Fragment{
        private static final String TAG = "MainFragment";//Constant declared for debugging
        
        private Button publishButton;//Button decleared in order to start publish function, this is initially set to be invisible by default.
        
        
      //@reference https://developers.facebook.com/docs/howtos/androidsdk/3.0/login-with-facebook/
        private Session.StatusCallback callback = new Session.StatusCallback() {
            @Override
            public void call(Session session, SessionState state, Exception exception) {
                onSessionStateChange(session, state, exception);
            }
        };
  
      //@reference https://developers.facebook.com/docs/howtos/androidsdk/3.0/login-with-facebook/
		private void publishFeedDialog() {
            Bundle params = new Bundle();
           // String test = "Yes I can";
            
            //Below is what will be posted when the user publishes
            params.putString("name", "Check out Dublin Jog for Android");
            params.putString("caption", "Making jogging more interesting.");
            params.putString("description", "An application that will increase your fitness in a new way.");
            params.putString("picture", "http://www.sligotoday.ie/images/1336378116.jpg");
            
            

            WebDialog feedDialog = (
                new WebDialog.FeedDialogBuilder(getActivity(),
                    Session.getActiveSession(),
                    params))
                .setOnCompleteListener(new OnCompleteListener() {

                    @Override
                    public void onComplete(Bundle values,
                        FacebookException error) {
                        if (error == null) {
                            // When the story is posted, echo the success
                            // and the post Id.
                            final String postId = values.getString("post_id");
                            if (postId != null) {
                                Toast.makeText(getActivity(),
                                    "Posted story, id: "+postId,
                                    Toast.LENGTH_SHORT).show();
                            } else {
                                // User clicked the Cancel button
                                Toast.makeText(getActivity().getApplicationContext(), 
                                    "Publish cancelled", 
                                    Toast.LENGTH_SHORT).show();
                            }
                        } else if (error instanceof FacebookOperationCanceledException) {
                            // User clicked the "x" button
                            Toast.makeText(getActivity().getApplicationContext(), 
                                "Publish cancelled", 
                                Toast.LENGTH_SHORT).show();
                        } else {
                            // Generic, ex: network error
                            Toast.makeText(getActivity().getApplicationContext(), 
                                "Error posting story", 
                                Toast.LENGTH_SHORT).show();
                        }
                    }

                })
                .build();
            feedDialog.show();
        }
		//@reference https://developers.facebook.com/docs/howtos/androidsdk/3.0/login-with-facebook/
        private UiLifecycleHelper uiHelper;
        @Override
        public View onCreateView(LayoutInflater inflater, 
                ViewGroup container, 
                Bundle savedInstanceState) {
        	
                
            View view = inflater.inflate(R.layout.facebook, container, false);
            uiHelper = new UiLifecycleHelper(getActivity(), callback);
            uiHelper.onCreate(savedInstanceState);
            

        	publishButton = (Button) view.findViewById(R.id.publishButton);
        	publishButton.setOnClickListener(new View.OnClickListener() {
        	    @Override
        	    public void onClick(View v) {
        	        publishFeedDialog();        
        	    }
        	});
            
            LoginButton authButton = (LoginButton) view.findViewById(R.id.authButton);
            authButton.setFragment(this);
            return view;
        }
        
       
      //@reference https://developers.facebook.com/docs/howtos/androidsdk/3.0/login-with-facebook/
        private void onSessionStateChange(Session session, SessionState state, Exception exception) {
            if (state.isOpened()) {
           
                Log.i(TAG, "Logged in...");
               
            } else if (state.isClosed()) {
           
			
                Log.i(TAG, "Logged out...");
                //if the user is logged out start the MENU activity
				startActivity(new Intent("com.drunkencow.dublinjog.MENU"));
				
				
                
                
            }
            
            if (state.isOpened()) {
            	//IF the user is logged in, set the publish button to be visible
                publishButton.setVisibility(View.VISIBLE);
            } else if (state.isClosed()) {
            	//IF the user is not logged in, set the publish button to be invisible
                publishButton.setVisibility(View.INVISIBLE);
                
				
            }
            
          
        		
        	
        }
        
     
  

      //@reference https://developers.facebook.com/docs/howtos/androidsdk/3.0/login-with-facebook/
		@Override
        public void onResume() {
            super.onResume();
            // For scenarios where the main activity is launched and user
            // session is not null, the session state change notification
            // may not be triggered. Trigger it if it's open/closed.
            Session session = Session.getActiveSession();
            if (session != null &&
                   (session.isOpened() || session.isClosed()) ) {
                onSessionStateChange(session, session.getState(), null);
            }
            uiHelper.onResume();
        }
		//@reference https://developers.facebook.com/docs/howtos/androidsdk/3.0/login-with-facebook/
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            uiHelper.onActivityResult(requestCode, resultCode, data);
         
			
        }
        
        
        
      
      //@reference https://developers.facebook.com/docs/howtos/androidsdk/3.0/login-with-facebook/
        @Override
        public void onPause() {
            super.onPause();
            uiHelper.onPause();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
           
            uiHelper.onDestroy();
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            uiHelper.onSaveInstanceState(outState);
            
            
        }




}
