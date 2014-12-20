package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * ��һ�׶Σ��������ݿ�ͱ����ڱ��ش洢��������ȡ������
 * �ڶ��׶Σ���model����Ϊ���ű���Դ���һ��ʵ����
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
	
	/** 
	 * Province�������
	 * ����id��������������privince_name��ʾʡ����province_code��ʾʡ������
	 */
	public static final String CREATE_PROVINCE = "create table Province ("
			+"id integer primary key autoincrement,"
			+"province_name text,"
			+"province_code text)";
	
	/** 
	 * City�������
	 * ����id��������������city_name��ʾ��������city_code��ʾ�м����ţ�
	 * province_id��City�����Province������
	 */
	public static final String CREATE_CITY  = "create table City ("
			+"id integer primary key autoincrement,"
			+"city_name text,"
			+"city_code text,"
			+"province_id integer)";
	
	/**
	 * Country�������
	 * ����id��������������country_name��ʾ������country_code��ʾ�ؼ�i���ţ�
	 * city_id��Country�����City������
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
		db.execSQL(CREATE_PROVINCE);// ����Province��
		db.execSQL(CREATE_CITY);// ����City��
		db.execSQL(CREATE_COUNTRY);//����Country��
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
