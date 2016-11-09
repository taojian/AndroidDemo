/*
 * @Title CldHudSqlHelper.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author taojian
 * @date 2016-3-30 上午9:37:18
 * @version 1.0
 */
package com.cld.cm.misc.hud.extend;

import com.cld.db.utils.CldDbUtils;
import com.cld.nv.env.CldNvBaseEnv;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库助手类
 * 
 * @author taojian
 * @date 2016-3-30 上午9:37:18
 */
public class CldHudSqlHelper extends SQLiteOpenHelper {
	/** 数据库名称 */
	private static final String DATABASE_NAME = "jvdownload.db";
	/** 数据库版本号 */
	private static final int DATABASE_VERSION = 6;
	/** 下载jv文件状态表*/
	private static final String TABLE_NAME = "jvStatus";

	private static final String CREATE_SQL = "CREATE TABLE jvStatus ("
			+ "id integer primary key autoincrement, " + "name text, "
			+ "status integer, " + "progress real)";

	private static CldHudSqlHelper mHudSqlHelper = null;

	public static synchronized CldHudSqlHelper getInstance() {
		if (mHudSqlHelper == null) {
			mHudSqlHelper = new CldHudSqlHelper(CldNvBaseEnv.getAppContext());
		}
		return mHudSqlHelper;
	}

	/**
	 * 私有构造器
	 *@param context
	 */
	private CldHudSqlHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_SQL);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS jvStatus");
		onCreate(db);
	}

	/**
	 * 插入数据
	 * @param name 文件名称
	 * @return void
	 * @author taojian
	 * @date 2016-4-1 下午6:19:48
	 */
	public void add(String name) {
		SQLiteDatabase db = getWritableDatabase();
		String strAdd = "insert into " + TABLE_NAME + " (name) values(?)";
		db.execSQL(strAdd, new Object[]{name});
		db.close();
	}

	/**
	 * 删除数据
	 * @param id 文件id
	 * @return void
	 * @author taojian
	 * @date 2016-4-1 下午6:21:16
	 */
	public void delete(int id) {
		SQLiteDatabase db = getWritableDatabase();
		String strDel = "delete from " + TABLE_NAME + " where id=?";
		db.execSQL(strDel, new Object[]{id});
		db.close();
	}

	/**
	 * 更新文件下载状态
	 * @param id
	 * @param status
	 * @return void
	 * @author taojian
	 * @date 2016-4-1 下午6:22:58
	 */
	public void updateStatus(int id, int status) {
		SQLiteDatabase db = getWritableDatabase();
		String strUpdate = "update " + TABLE_NAME + " set status=? where id=?";
		db.execSQL(strUpdate, new Object[]{status, id});
		db.close();
	}

	/**
	 * 更新文件下载进度
	 * @param id
	 * @param progress
	 * @return void
	 * @author taojian
	 * @date 2016-4-1 下午6:23:21
	 */
	public void updateProgress(int id, float progress){
		SQLiteDatabase db = getWritableDatabase();
		String strUpdate = "update " + TABLE_NAME + " set progress=? where id=?";
		db.execSQL(strUpdate, new Object[]{progress, id});
		db.close();
	}
	
	/**
	 * 更新jv文件名称
	 * @param id
	 * @param name
	 * @return void
	 * @author taojian
	 * @date 2016-4-6 下午5:38:06
	 */
	public void updateJvName(int id, String name){
		SQLiteDatabase db = getWritableDatabase();
		String strUpdate = "update " + TABLE_NAME + " set name=? where id=?";
		db.execSQL(strUpdate, new Object[]{name, id});
		db.close();
	}
	
	/**
	 * 查询文件下载状态
	 * @param id 文件id
	 * @return
	 * @return int
	 * @author taojian
	 * @date 2016-4-1 下午6:23:50
	 */
	public int queryStatus(int id) {
		int status = 0;
		SQLiteDatabase db = getReadableDatabase();
		String strFind = "select status from "+ TABLE_NAME + " where id=?";
		Cursor cursor = db.rawQuery(strFind, new String[]{String.valueOf(id)});
		int index = cursor.getColumnIndex("status");
		for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
			status = cursor.getInt(index);
			break;
		}
		cursor.close();
		db.close();
		return status;
	}
	
	/**
	 * 查询文件名称
	 * @param id 文件id
	 * @return
	 * @return String
	 * @author taojian
	 * @date 2016-4-1 下午6:24:20
	 */
	public String queryName(int id){
		String fileName = null;
		SQLiteDatabase db = getReadableDatabase();
		String strFind = "select name from "+ TABLE_NAME + " where id=?";
		Cursor cursor = db.rawQuery(strFind, new String[]{String.valueOf(id)});
		int index_name  = cursor.getColumnIndex("name");
		for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
			fileName = cursor.getString(index_name);
			break;
		}
		cursor.close();
		db.close();
		return fileName;
	}
	
	/**
	 * 判断数据表是否为空
	 * @return
	 * @return boolean
	 * @author taojian
	 * @date 2016-4-1 下午6:25:02
	 */
	public boolean isTabEmpty(){
		SQLiteDatabase db = getReadableDatabase();
		String strQuery = "select * from " + TABLE_NAME;
		Cursor cursor = db.rawQuery(strQuery, null);
		if(cursor.moveToFirst()){
			cursor.close();
			db.close();
			return false;
		}else{
			cursor.close();
			db.close();
			return true;
		}
	}


}
