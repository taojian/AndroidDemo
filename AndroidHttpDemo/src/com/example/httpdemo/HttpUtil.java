/*
 * @Title HttpUtil.java
 * @Copyright Copyright 2010-2015 Careland Software Co,.Ltd All Rights Reserved.
 * @author taojian
 * @date 2017-1-12 下午3:58:35
 * @version 1.0
 */
package com.example.httpdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.util.Log;

/**
 * HttpUrlConnection/HttpClient
 * 
 * @author taojian
 * @date 2017-1-12 下午3:58:35
 */
public class HttpUtil {

	/**
	 * HttpUrlConnection GET 目前处理的是字符流,如果处理字节流数据,需用字节流方式处理
	 * 
	 * @param url
	 * @return void
	 * @author taojian
	 * @date 2017-1-16 下午3:18:06
	 */
	private static void doHttpUrlConnectionGet(String url) {
		HttpURLConnection mUrlConnection = null;
		try {
			URL mUrl = new URL(url);
			mUrlConnection = (HttpURLConnection) mUrl.openConnection();
			mUrlConnection.setRequestMethod("GET");
			mUrlConnection.setConnectTimeout(8000);
			mUrlConnection.setReadTimeout(8000);
			mUrlConnection.connect();
			if (mUrlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream in = mUrlConnection.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				reader.close();
				in.close();
				Log.i("TJ", sb.toString());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mUrlConnection.disconnect();
		}

	}

	private static void doHttpUrlConnectionPost(String url, String name, int age) {
		HttpURLConnection mUrlConnection = null;
		try {
			URL mUrl = new URL(url);
			mUrlConnection = (HttpURLConnection) mUrl.openConnection();
			mUrlConnection.setRequestMethod("POST");
			mUrlConnection.setConnectTimeout(5000);
			mUrlConnection.setReadTimeout(5000);
			mUrlConnection.connect();
			OutputStream os = mUrlConnection.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			bw.write("name=" + name + "&age=" + age);
			bw.close();
			os.close();
			if (mUrlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream is = mUrlConnection.getInputStream();
				BufferedReader br = new BufferedReader(
						new InputStreamReader(is));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				Log.i("TJ", sb.toString());
				br.close();
				is.close();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mUrlConnection.disconnect();
		}
	}

	/**
	 * HttpClient POST
	 * 
	 * @param url
	 * @param name
	 * @param age
	 * @return void
	 * @author taojian
	 * @date 2017-1-16 下午3:25:03
	 */
	private static void doHttpClientPost(String url, String name, int age) {
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			List<NameValuePair> mList = new ArrayList<NameValuePair>();
			mList.add(new BasicNameValuePair("name", name));
			mList.add(new BasicNameValuePair("age", Integer.toString(age)));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(mList,
					"utf-8");
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity2 = response.getEntity();
				String content = EntityUtils.toString(entity2);
				Log.i("TJ", content);
				parseJSONWithJSONObject(content);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * HttpClient GET
	 * 
	 * @param url
	 * @return void
	 * @author taojian
	 * @date 2017-1-16 下午3:25:18
	 */
	private static void doHttpClientGet(String url) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				String content = EntityUtils.toString(entity);
				Log.i("TJ", content);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 函数注释
	 * 
	 * @param url
	 * @param name
	 * @param age
	 * @return void
	 * @author taojian
	 * @date 2017-1-12 下午4:09:34
	 */
	public static void doUrlConnectionGet(final String url, final String name,
			final int age) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				doHttpUrlConnectionGet(url + "?name=" + name + "&age=" + age);
			}
		}).start();
	}

	/**
	 * 函数注释
	 * 
	 * @param url
	 * @param name
	 * @param age
	 * @return void
	 * @author taojian
	 * @date 2017-1-12 下午4:09:38
	 */
	public static void doUrlConnectionPost(final String url, final String name,
			final int age) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				doHttpUrlConnectionPost(url, name, age);
			}
		}).start();
	}

	public static void doClientGet(final String url, final String name,
			final int age) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				doHttpClientGet(url + "?name=" + name + "&age=" + age);
			}
		}).start();
	}

	public static void doClientPost(final String url, final String name,
			final int age) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				doHttpClientPost(url, name, age);
			}
		}).start();
	}

	private static void parseJSONWithJSONObject(String jsonData) {
		try {
			JSONObject jsonObject = new JSONObject(jsonData);
			String type = jsonObject.getString("name");
			Log.i("TJ", "type---" + type);
			JSONArray jsonArray = jsonObject.getJSONArray("version");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				String id = object.getString("id");
				String version = object.getString("version");
				String name = object.getString("name");
				Log.i("TJ", "--id--" + id + "--version--" + version
						+ "--name--" + name);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void parseJSONWithGSON(String jsonData) {
		try {

			Gson gson = new Gson();
			gson.fromJson(jsonData, new TypeToken<List<String>>() {
			}.getType());
			JSONObject jsonObject = new JSONObject(jsonData);
			String type = jsonObject.getString("name");
			Log.i("TJ", "type---" + type);
			JSONArray jsonArray = jsonObject.getJSONArray("version");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				String id = object.getString("id");
				String version = object.getString("version");
				String name = object.getString("name");
				Log.i("TJ", "--id--" + id + "--version--" + version
						+ "--name--" + name);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
