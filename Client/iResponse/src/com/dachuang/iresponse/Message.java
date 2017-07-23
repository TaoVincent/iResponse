package com.dachuang.iresponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Message extends Fragment implements SearchView.OnQueryTextListener {
	private SearchView mSearchView;
	private ListView listView_msg;
	private SimpleAdapter simpleAdapter;
	private List<Map<String, String>> dataList;
	private String[] userName = { "my", "thq", "wsc", "aaa",
			"bbb", "ccc", "ddd" };
	private String[] msg = { "今晚回来吃饭", "我在家等你", "明天来公司给你钱", 
			"你好", "你好", "你好", "你好" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.message, container, false);

		// searchView
		mSearchView = (SearchView) view.findViewById(R.id.searchView);
		mSearchView.setOnQueryTextListener(this);

		// listview_msg
		dataList = new ArrayList<Map<String, String>>();
		listView_msg = (ListView) view.findViewById(R.id.listView_msg);
		simpleAdapter = new SimpleAdapter(getActivity(), getData(), R.layout.item_msg,
				new String[] { "pic", "userName", "msg" }, new int[] { R.id.imageView1, R.id.userName, R.id.msg });
		listView_msg.setAdapter(simpleAdapter);
		return view;
	}

	private List<Map<String, String>> getData() {
		for (int i = 0; i < userName.length; i++) {
			Map<String, String> map = new HashMap();
			map.put("pic", R.drawable.ic_launcher + "");
			map.put("userName", userName[i]);
			map.put("msg", msg[i]);

			dataList.add(map);
		}  

		return dataList; 
	}

	@Override
	public boolean onQueryTextChange(String newString) {
		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		return false;
	}
}
