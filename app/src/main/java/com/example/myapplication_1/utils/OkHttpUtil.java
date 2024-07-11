package com.example.myapplication_1.utils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpUtil {

	// 创建OkHttp客户端OkHttpClient对象
	public static OkHttpClient client = new OkHttpClient();
	// 媒体类型
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	public static String tbToken = "";// thingsboard访问令牌


	/**
	 * get请求，异步
	 *
	 * @param url      字符串URL地址
	 * @param callback 回调接口
	 * @return 响应结果
	 * @throws IOException
	 */
	public static void get(String url, okhttp3.Callback callback) {
		// 构建请求
		Request.Builder builder = new Request.Builder();
		if (!"".equals(tbToken)) {
			builder.addHeader("X-Authorization", "bearer " + tbToken);
		}
		Request request = builder
				.url(url)
				.get() // 省略。。
				.build();
		// 异步方式
		client.newCall(request).enqueue(callback);
	}

	/**
	 * Post请求，异步
	 *
	 * @param url      字符串URL地址
	 * @param json     json字符串
	 * @param callback 回调接口
	 * @return 响应结果
	 * @throws IOException
	 */
	public static void post(String url, String json, okhttp3.Callback callback) {
		// 请求包体
		RequestBody requestBody = RequestBody.create(JSON, json);
		// 构建请求
		Request.Builder builder = new Request.Builder();
//		builder.addHeader("Content-Type", "application/json");
//		builder.addHeader("Accept", "application/json");
//		// token不为空，加入到header
		if (!"".equals(tbToken)) {
			builder.addHeader("X-Authorization", "bearer " + tbToken);
		}
		Request request = builder
				.url(url)
				.post(requestBody)
				.build();
		// 异步方式
		client.newCall(request).enqueue(callback);
	}

}
