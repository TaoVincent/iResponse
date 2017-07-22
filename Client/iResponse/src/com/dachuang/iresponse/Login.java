package com.dachuang.iresponse;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	private Button btn_login;
	private Button btn_register;
	private EditText text_username;
	private EditText text_password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		btn_login = findViewById(R.id.button1);
		btn_register = findViewById(R.id.button2);
		text_username = findViewById(R.id.editText1);
		text_password = findViewById(R.id.editText2);
		
		
		btn_login.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				//获取eidttext的值
				String name = text_username.getText().toString();
				String pswd = text_password.getText().toString();
					if(name.equals("LNNU") && pswd.equals("123")) {
						Log.i("Tag", "OK");
						Intent intent = new Intent(Login.this,Main.class);
						startActivity(intent);
					}
					else {
						Toast.makeText(Login.this, "帐号或密码错误", Toast.LENGTH_LONG).show();
					}
			}
		});
		
		btn_register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this,Register.class);
				startActivity(intent);
			}
		});
		
	}

}
