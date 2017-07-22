package com.dachuang.iresponse;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragement extends Fragment {
    private String context;
    private TextView mTextView;

    public  Fragement(String context){
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement,container,false);
        mTextView =(TextView) view.findViewById(R.id.txt_content);
    //    mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
        mTextView.setText(context);
        return view;
        
    }
}