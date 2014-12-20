package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 第一阶段：创建数据库和表，用于本地存储服务器获取的数据
 * 第二阶段：在model包下为三张表各自创建一个实体类
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
	
	/** 
	 * Province表建表语句
	 * 其中id是自增长主键，privince_name表示省名，province_code表示省级代号
	 */
	public static final String CREATE_PROVINCE = "create table Province ("
			+"id integer primary key autoincrement,"
			+"province_name text,"
			+"province_code text)";
	
	/** 
	 * City建表语句
	 * 其中id是自增长主键，city_name表示城市名，city_code表示市级代号，
	 * province_id是City表关联Province表的外键
	 */
	public static final String CREATE_CITY  = "create table City ("
			+"id integer primary key autoincrement,"
			+"city_name text,"
			+"city_code text,"
			+"province_id integer)";
	
	/**
	 * Country建表语句
	 * 其中id是自增长主键，country_name表示县名，country_code表示县级i代号，
	 * city_id是Country表关联City表的外键
	 */
	public static final String CREATE_COUNTRY = "create table Country ("
			+"id integer primary autoincrement,"
			+"country_name text,"
			+"country_code text,"
			+"city_id integer)";

	public CoolWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE);// 创建Province表
		db.execSQL(CREATE_CITY);// 创建City表
		db.execSQL(CREATE_COUNTRY);//创建Country表
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
