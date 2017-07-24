package com.dachuang.iresponse;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

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
			if (admistor == null) {
				admistor = new Register_admistor();
				transaction.add(R.id.fragment_container, admistor);
			} else {
				transaction.show(admistor);
			}
			break;
		case R.id.radio_teacher:
			if (teacher == null) {
				teacher = new Register_teacher();
				transaction.add(R.id.fragment_container, teacher);
			} else {
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
			checkRegister();
		//	finish();
		}
	}

	private boolean checkRegister() {
		// TODO Auto-generated method stub
		if (radio_teacher.isChecked()) {
			Log.i("radio", "教师");
			LayoutInflater layout = teacher.getActivity().getLayoutInflater();
			View view = layout.inflate(R.layout.register_teacher, null);
			EditText userName = (EditText) view.findViewById(R.id.userName);
			EditText pswd = (EditText) view.findViewById(R.id.pswd);
			EditText college = (EditText) view.findViewById(R.id.college);
			EditText school = (EditText) view.findViewById(R.id.school);
			EditText eMail = (EditText) view.findViewById(R.id.eMail);
			EditText phone = (EditText) view.findViewById(R.id.phone);
			EditText identity = (EditText) view.findViewById(R.id.identity);
			Log.i("userName", userName.getText().toString());
			Toast.makeText(this, userName.getText().toString(), Toast.LENGTH_LONG).show();
			Log.i("pswd", pswd.getText().toString());
			Log.i("college", college.getText().toString());
			Log.i("school", school.getText().toString());
			Log.i("eMail", eMail.getText().toString());
			Log.i("phone", phone.getText().toString());
			Log.i("identity", identity.getText().toString());
		} else {
			Log.i("radio", "学校1");
			LayoutInflater layout = this.getLayoutInflater();
			View view = layout.inflate(R.layout.register_admistor, null);
			EditText schoolName = (EditText) view.findViewById(R.id.schoolName);
			EditText pswd = (EditText) view.findViewById(R.id.pswd);
			EditText eMail = (EditText) view.findViewById(R.id.eMail);
			EditText phone = (EditText) view.findViewById(R.id.phone);
			Log.i("schoolName", (String)schoolName.getText().toString());
			Log.i("pswd", pswd.getText().toString());
			Log.i("eMail", eMail.getText().toString());
			Log.i("phone", phone.getText().toString());
		}
		return true;
	}

}
