package com.tang.firstapp;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	String responseMsg = "";
	private TextView textView;

	Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            if(what == 0){
                //在主线程中需要执行的操作，一般是UI操作
            	textView.setText(responseMsg);
            }
        }
    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("进入MainActivity");

		Thread loginThread = new Thread(new LoginThread());
		loginThread.start();

		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.testView);
		
	}

	// 发送请求的主要方法
	private boolean loginServer() {
		boolean loginValidate = false;

		// servlet服务器地址是
		String urlStr = "http://192.168.3.177:8080/Test/servlet/TestServlet";
		HttpPost request = new HttpPost(urlStr);

		try {
			HttpClient client = getHttpClient();
			// 执行请求
			HttpResponse response = client.execute(request);
			// response是servlet给出的返回结果
			// if(response.getStatusLine().getStatusCode() == 200){
			loginValidate = true;
			responseMsg = EntityUtils.toString(response.getEntity());
			System.out.println("11111111111111responseMsg-------------"+responseMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginValidate;
	}

	public HttpClient getHttpClient() {
		BasicHttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 3 * 1000);
		HttpConnectionParams.setSoTimeout(httpParams, 5 * 1000);
		HttpClient client = new DefaultHttpClient(httpParams);
		return client;
	}

	class LoginThread implements Runnable {
		public void run() {
			boolean loginValidate = loginServer();
			System.out.println("======================bool is :"
					+ loginValidate + "----------------response: "
					+ responseMsg);
			//在子线程中执行任务，执行完成或需要通知UI线程时调用以下方法
            mHandler.sendEmptyMessage(0);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
