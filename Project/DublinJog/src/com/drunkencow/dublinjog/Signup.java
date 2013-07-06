package com.drunkencow.dublinjog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends Activity{

	TextView etext;
	EditText name, pass, email, conPass;
	Button confirm;
	DatabaseManager db = new DatabaseManager(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
		confirm = (Button)findViewById(R.id.confirmBtn);
		name = (EditText)findViewById(R.id.nameTF);
		pass = (EditText) findViewById(R.id.passTF);
		email = (EditText) findViewById(R.id.emailTF);
		conPass = (EditText) findViewById(R.id.confirmPass);
		etext = (TextView) findViewById(R.id.eText);
		
		
		db.open();

		confirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String mail = email.getText().toString();
				String user = name.getText().toString();
				String word = pass.getText().toString();
				String confirm = conPass.getText().toString();
				String exist = db.findIfUserExists(user);
				
				db.getAllRecords();
				checkEmailValid();
				boolean valid = checkEmailValid();
				
				if(valid == false){
					Toast.makeText(Signup.this, String.valueOf("Please enter a valid email"),Toast.LENGTH_SHORT).show();
				}
				else if (user.length() < 4 || user.length() > 12){
					Toast.makeText(Signup.this, String.valueOf("Please enter a username"),Toast.LENGTH_SHORT).show();
				}
				else if(user.equals(exist)){
					Toast.makeText(Signup.this, String.valueOf("Username already taken"),Toast.LENGTH_SHORT).show();
				}
				else if(word.length() < 6 || word.length() > 20){
					Toast.makeText(Signup.this, String.valueOf("Your password must be between 6 to 20 characters"),Toast.LENGTH_SHORT).show();
				}
				else if(!word.equals(confirm)){
					Toast.makeText(Signup.this, String.valueOf("Passwords don't match"),Toast.LENGTH_SHORT).show();
				}
				else{
					db.open();
					long id = db.insertEntry(email.getText().toString(), name.getText().toString(), pass.getText().toString(),null,null, 
							null, null, null);
					db.close();
					//Toast.makeText(Signup.this, String.valueOf("User Created"),Toast.LENGTH_SHORT).show();
					startActivity(new Intent("com.drunkencow.dublinjog.LOGIN"));
					finish();
				}
			}
		});
	}
	
	public boolean checkEmailValid(){
		String mail = email.getText().toString();
		boolean valid = false;
		//sets the valid characters as 'a-z & 0-9' '@' 'a-z' '.' 'a-z' 
		//which returns valid if email is like "me@hotmail.com"
		String validChar = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
		CharSequence inputStream = mail;
		
		Pattern pattern = Pattern.compile(validChar, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStream);
		
		if(matcher.matches()){
			valid = true;
		}

		return valid;
	}
	
	//test database is working
	public void displayRecord(Cursor c){
		Toast.makeText(this, "id: " + c.getString(0) + "\n"
									+"Email: " + c.getString(1) + "\n"
									+"User: " + c.getString(2) + "\n"
									+"Password: " + c.getString(3) + "\n", Toast.LENGTH_LONG).show();
	}
	

}
