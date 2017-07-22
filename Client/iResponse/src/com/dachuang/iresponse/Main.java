package com.dachuang.iresponse;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener{
	
	private Button msg;
	private Button course;
	private Button teach;
	private Button myself;
	private Button exit;
	private Button more;
	

    private Fragement f1,f2,f3,f4;
 	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		msg = findViewById(R.id.btn_msg);
		course = findViewById(R.id.btn_course);
		teach = findViewById(R.id.btn_teach);
		myself = findViewById(R.id.btn_myself);
		exit = findViewById(R.id.button_left);
		more = findViewById(R.id.button_right);
		

		msg.setOnClickListener(this);
		course.setOnClickListener(this);
		teach.setOnClickListener(this);
		myself.setOnClickListener(this);
		exit.setOnClickListener(this);
		more.setOnClickListener(this);
		
	}



	  //���������ı���ѡ��״̬
    public void selected(){
    	msg.setSelected(false);
    	course.setSelected(false);
    	teach.setSelected(false);
    	myself.setSelected(false);
    }

     //��������Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(f1!=null){
            transaction.hide(f1);
        }
        if(f2!=null){
            transaction.hide(f2);
        }
        if(f3!=null){
            transaction.hide(f3);
        }
        if(f4!=null){
            transaction.hide(f4);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch(v.getId()){
            case R.id.btn_msg:
            	Toast.makeText(this, "123", Toast.LENGTH_LONG).show();
                selected();
                msg.setSelected(true);
                if(f1==null){
                    f1 = new Fragement("��һ��Fragment");
                    transaction.add(R.id.fragment_container,f1);
                }else{
                    transaction.show(f1);
                }
                break;

            case R.id.btn_course:
                selected();
                course.setSelected(true);
                if(f2==null){
                    f2 = new Fragement("�ڶ���Fragment");
                    transaction.add(R.id.fragment_container,f2);
                }else{
                    transaction.show(f2);
                }
                break;

            case R.id.btn_teach:
                selected();
                teach.setSelected(true);
                if(f3==null){
                    f3 = new Fragement("������Fragment");
                    transaction.add(R.id.fragment_container,f3);
                }else{
                    transaction.show(f3);
                }
                break;

            case R.id.btn_myself:
                selected();
                myself.setSelected(true);
                if(f4==null){
                    f4 = new Fragement("���ĸ�Fragment");
                    transaction.add(R.id.fragment_container,f4);
                }else{
                    transaction.show(f4);
                }
                break;
            case R.id.button_left: 
            	finish();
            	break;
            case R.id.button_right:
            	Toast.makeText(this, "���ڿ���", Toast.LENGTH_LONG).show();
        }

        transaction.commit();
    }
}


