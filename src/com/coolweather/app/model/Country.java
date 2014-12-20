package com.coolweather.app.model;

// Country的实体类
public class Country {
	
	private int id;
	private String cuntryName;
	private String countryCode;
	private int cityId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCuntryName() {
		return cuntryName;
	}
	public void setCuntryName(String cuntryName) {
		this.cuntryName = cuntryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}
