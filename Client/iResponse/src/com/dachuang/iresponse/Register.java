package com.dachuang.iresponse;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Register extends Activity implements OnClickListener, OnCheckedChangeListener {

	private Register_admistor admistor;
	private Register_teacher teacher;
	private Button btn_back;
	private Button btn_next;
	private RadioButton radio_admistor;
	private RadioButton radio_teacher;
	private RadioGroup radio;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		btn_back = findViewById(R.id.button_left);
		btn_next = findViewById(R.id.button_right);

		radio = findViewById(R.id.radioGroup1);
		radio_admistor = findViewById(R.id.radio_superAdmistor);
		radio_teacher = findViewById(R.id.radio_teacher);

		btn_back.setOnClickListener(this);
		btn_next.setOnClickListener(this);

		radio.setOnCheckedChangeListener(this);
		
		

	}

	public void hideAllFragment(FragmentTransaction transaction) {
		if (admistor != null) {
			transaction.hide(admistor);
		}
		if (teacher != null) {
			transaction.hide(teacher);
		}
	}



	@Override
	public void onCheckedChanged(RadioGroup v, int id) {
		// TODO Auto-generated method stub
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		hideAllFragment(transaction);
		
		switch (id) {
		case R.id.radio_superAdmistor:	          
            if(admistor == null) {
            	admistor = new Register_admistor();
            	transaction.add(R.id.fragment_container,admistor);
            }
            else {
            	transaction.show(admistor);
            }
			break;
		case R.id.radio_teacher:
            if(teacher == null) {
            	teacher = new Register_teacher();
            	transaction.add(R.id.fragment_container,teacher);
            }
            else {
            	transaction.show(teacher);
            }
			break;
		}
		transaction.commit();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button_left:
			finish();
		case R.id.button_right:
			if (checkRegister()) {
				finish();
			}
		}
	}

	private boolean checkRegister() {
		// TODO Auto-generated method stub
		return false;
	}

}
