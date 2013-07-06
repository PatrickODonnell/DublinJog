package com.drunkencow.dublinjog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

//it is apparently common practice to initialise the database through it's own class although this could also be done through the DBManager class
public class DatabaseSetup extends SQLiteOpenHelper{

	public DatabaseSetup(Context context, String name, CursorFactory factory, int version){
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		//goes to DBManager class to find the intialisation SQL 
		db.execSQL(DatabaseManager.dbCreate);
	}

	@Override
	//code is required but most likely won't be used. Used to make a new version of the database and 
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//tells it to stop using the current database
		db.execSQL("DROP TABLE IF EXISTS");
		//and makes the new one
		onCreate(db);
	}

}