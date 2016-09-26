package com.example.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter1 extends BaseAdapter  {

	private Activity activity;
	List<HashMap<String, String>> list1;
	String string;
	
	private static LayoutInflater inflater = null;
	
	
	public Adapter1(Activity activity1, ArrayList<HashMap<String, String>> list) {
		this.list1 = list;
		activity = activity1;
        
        
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public Adapter1(MainActivity3 activity1, String list,Drawable drawable) {
		activity = activity1;
		this.string = list;
		
	}

	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list1.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.new_main, null);
		
		TextView textView = (TextView) vi.findViewById(R.id.textView1);
		TextView textView1 = (TextView) vi.findViewById(R.id.icon);
	    
		
		
	    HashMap<String,String> hash = new HashMap<String, String>();
		hash = list1.get(position);
		textView.setText(hash.get(MainActivity.TITLE));
		GradientDrawable bgShape = (GradientDrawable)textView1.getBackground();
		bgShape.setColor(Integer.parseInt(hash.get(MainActivity.colorss)));
		
        return vi;
	}
}
