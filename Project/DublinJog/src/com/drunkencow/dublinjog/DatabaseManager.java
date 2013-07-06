/*
 * Based from database tutorials found at
 * http://www.anotherandroidblog.com/2010/08/04/android-database-tutorial/#title
 * and
 * http://techblogon.com/android-login-registration-screen-with-sqlite-database-example/
 */

package com.drunkencow.dublinjog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
	private static final String DB_NAME = "user";
	private static final int DB_VERSION = 1;
	
	public static final String TABLE_NAME = "userdetails";
	public static final String ROW_ID = "id";
	public static final String ROW_EMAIL = "email";
	public static final String ROW_USER = "username";
	public static final String ROW_PASS = "password";
	public static final String ROW_PHOENIX_PARK = "phoenixpark";
	public static final String ROW_ISOLDES_TOWER = "isoldestower";
	public static final String ROW_NATIONAL_BOTANIC_GARDENS = "nationalbotanicgardens";
	public static final String ROW_CHRISTCHURCH = "christchurch";
	public static final String ROW_TIME = "time";
	
	//string of SQL commands to setup database
	static final String dbCreate = "create table if not exists" + " userdetails " + "(" 
													+ " id integer primary key autoincrement, " 
													+ " email VARCHAR, username VARCHAR, password VARCHAR, phoenixpark VARCHAR," 
													+" isoldestower VARCHAR, nationalbotanicgardens VARCHAR, christchurch VARCHAR, time VARCHAR);";
	
	public SQLiteDatabase db;
	private final Context context;
	private DatabaseSetup dbSet;
	
	public DatabaseManager(Context _context){
		context = _context;
		dbSet = new DatabaseSetup(context, DB_NAME, null, DB_VERSION);
	}
	
	//opens writable version of database ready to read or edit
	public DatabaseManager open() throws SQLException{
		db = dbSet.getWritableDatabase();
		return this;
	}
	
	public void close(){
		db.close();
	}
	
	public SQLiteDatabase getDatabaseInstance(){
		return db;
	}
	
	//for creating a user. Needs to be a long as database only accepts certain data entries
	public long insertEntry(String mail, String user, String word, String phoenixpark, String isoldestower, String nationalbotanicgardens, String christchurch, String time){
		//used to parse the strings to values SQL db can understand
		ContentValues value = new ContentValues();
		
		value.put(ROW_EMAIL, mail);
		value.put(ROW_USER, user);
		value.put(ROW_PASS, word);
		value.put(ROW_PHOENIX_PARK, phoenixpark);
		value.put(ROW_ISOLDES_TOWER, isoldestower);
		value.put(ROW_NATIONAL_BOTANIC_GARDENS, nationalbotanicgardens);
		value.put(ROW_CHRISTCHURCH, christchurch);
		value.put(ROW_TIME, time);
	
		
		return db.insert(TABLE_NAME, null, value);
	}
	
	public Cursor getAllRecords(){
		return db.query(TABLE_NAME, new String[] {ROW_ID, ROW_EMAIL, ROW_USER, ROW_PASS,ROW_PHOENIX_PARK,ROW_ISOLDES_TOWER,ROW_NATIONAL_BOTANIC_GARDENS,ROW_CHRISTCHURCH, ROW_TIME}, null, null, null, null, null);
	}

	//used to test if the password entered is correct
	public String getUserPassword(String userName){
		Cursor cursor = db.query(TABLE_NAME, null, ROW_USER +"=?", new String[]{userName}, null, null, null);
		if(cursor.getCount()<1){
			cursor.close();
			return "NOT EXIST";
		}
		cursor.moveToFirst();
		String password = cursor.getString(cursor.getColumnIndex(ROW_PASS));
		cursor.close();
		return password;
	}
	
	//used to ensure the user exists
	public String findIfUserExists(String userName){
		Cursor cursor = db.query(TABLE_NAME, null, ROW_USER +"=?", new String[]{userName}, null, null, null);
		if(cursor.getCount()<1){
			cursor.close();
			return "NOT EXIST";
		}
		cursor.moveToFirst();
		String use = cursor.getString(cursor.getColumnIndex(ROW_USER));
		cursor.close();
		return use;
	}

}