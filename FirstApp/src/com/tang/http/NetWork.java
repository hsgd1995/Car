package com.tang.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class NetWork {
	String responseMsg = "";

	public String getMessage() {
		String response = "";
		System.out.println("getMessage，获取网络");
		try {
			String url = "http://localhost:8080/Test/servlet/TestServlet";
			
			

			
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("出现异常");
			e.printStackTrace();
		}
		return response;
	}

	

	

}
