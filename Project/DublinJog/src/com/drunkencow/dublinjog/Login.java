//Code by Patrick and Philip

package com.drunkencow.dublinjog;

import com.facebook.widget.LoginButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity{

	EditText name, pass;
	Button confirm, signup, fb;
	TextView text;
	DatabaseManager db = new DatabaseManager(this);
	
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		
    	text = (TextView) findViewById(R.id.enterLogin);
		signup = (Button) findViewById(R.id.signupBtn);
		confirm = (Button) findViewById(R.id.confirmBtn);
		name = (EditText) findViewById(R.id.nameTF);
		pass = (EditText) findViewById(R.id.passTF);
	

		db.open();
		
				
				
				
		
	
		confirm.setOnClickListener(new View.OnClickListener() {
			
			
			
			@Override
			public void onClick(View arg0) {
		
				// TODO Auto-generated method stub
				String userName = name.getText().toString();
				String word = pass.getText().toString();
				String storedPass = db.getUserPassword(userName);
				String userExist = db.findIfUserExists(userName);
				if(userName.equals(userExist)){
					if(word.equals(storedPass)){
						startActivity(new Intent("com.drunkencow.dublinjog.MENU"));
						finish();
					}
					else{
						Toast.makeText(Login.this, String.valueOf("Invalid Password"),Toast.LENGTH_SHORT).show();
					}
				}
				else{
					Toast.makeText(Login.this, String.valueOf("Please enter a valid username"),Toast.LENGTH_SHORT).show();
				}
				

				
			}
		});
		
		
		signup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.drunkencow.dublinjog.SIGNUP"));
				finish();
			}
		});
	
	
}
}

	
