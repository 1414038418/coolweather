package com.coolweather.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.xml.sax.InputSource;

/**
 *  第二阶段：我们准备把遍历全国市县的工功能加入
 *  全国所有省市县的数据都是从服务器端获取到的，因此这里和服务器的交互是必不可少的，
 *  所以我们可以在util包中先增加一个HttpUtil类
 *	
 */
/** HttpUtil是网络操作公共类 */
public class HttpUtil {
	
	/** 这是一个静态方法，当想要发起网络请求时候只需简单的调用一下这个方法 */
	public static void sendHttpRequest (final String address,final HttpCallbackListener listener) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				HttpURLConnection connection = null;
				try {
					URL url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}
					if (listener != null) {
						// 回调onFinish()方法
						listener.onFinish(response.toString());
					}
				} catch (IOException e) {
					// 回调onError()方法
					listener.onError(e);
				} finally {
					if (connection != null) {
						connection.disconnect();
					}
				}
			}
		}).start();
	}

}
