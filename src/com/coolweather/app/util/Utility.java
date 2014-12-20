package com.coolweather.app.util;

import android.text.TextUtils;

import com.coolweather.app.model.City;
import com.coolweather.app.model.CoolWeatherDB;
import com.coolweather.app.model.Country;
import com.coolweather.app.model.Province;

/**
 * ���ڷ��������ص�ʡ�������ݶ��ǡ�����|���У�����|���С����ָ�ʽ�ģ� 
 * ��������������ṩһ���������������ʹ����������ݡ�
 * ��util���½���һ��Utility��
 */
public class Utility {

	// �����ʹ������������ص�ʡ������
	public synchronized static boolean handleProvincesResponse(
			CoolWeatherDB coolWeatherDB, String response) {
		if (!TextUtils.isEmpty(response)) {
			String[] allProvinces = response.split(",");
			if (allProvinces != null && allProvinces.length > 0) {
				for (String p : allProvinces) {
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					// ���������������ݴ洢��Province��
					coolWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}

	// �����ʹ������������ص��м�����
	public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,
			String response, int provinceId) {
		if (!TextUtils.isEmpty(response)) {
			String[] allClities = response.split(",");
			if (allClities != null && allClities.length > 0) {
				for (String c : allClities) {
					String[] array = c.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					// ���������������ݴ洢��City��
					coolWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}

	// �����ʹ������������ص��ؼ�����
	public static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB,
			String response, int cityId) {
		if (!TextUtils.isEmpty(response)) {
			String[] allCounties = response.split(",");
			if (allCounties != null && allCounties.length > 0) {
				for (String c : allCounties) {
					String[] array = c.split("\\|");
					Country country = new Country();
					country.setCountryCode(array[0]);
					country.setCuntryName(array[1]);
					country.setCityId(cityId);
					// ���������������ݴ洢��Country��
					coolWeatherDB.saveCountry(country);
				}
				return true;
			}
		}
		return false;
	}

}