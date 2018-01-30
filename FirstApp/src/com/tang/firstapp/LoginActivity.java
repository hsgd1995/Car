package com.tang.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener{

	private TextView username;
	private TextView password;
	private Button login;
	private Button regist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		username = (TextView) findViewById(R.id.username);
		password = (TextView) findViewById(R.id.password);
		login = (Button) findViewById(R.id.login_btn_login);
		login.setOnClickListener(this);
	}



	@Override
	public void onClick(View v) {
		Intent intent;
		switch(v.getId()){
		case R.id.login_btn_login:
			if("admin".equals(username.getText().toString())&&"admin".equals(password.getText().toString())){
				intent = new Intent(LoginActivity.this,MainActivity.class);
				startActivity(intent);
			}else{
				Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
			}
			break;
		
		}
		
	}

}
