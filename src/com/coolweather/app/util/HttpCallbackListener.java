package com.coolweather.app.util;

/**
 * HttpUtil类中使用到了HttpCallbackListener接口来回调返回的结果，
 * 因此我们还要在util包下添加这个接口，如下所示：
 */
public interface HttpCallbackListener {
	
	void onFinish (String response);
	
	void onError (Exception e);

}
