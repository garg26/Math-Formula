package com.example.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class MainActivity2 extends Activity implements OnClickListener{

	static final String TITLE = "title";
	static final String URL = "url";
	private String string;
	static final String colorss = "color";
	JSONObject obj ;
	ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		
        ListView listview = (ListView) findViewById(R.id.listView1);
        TextView textView = (TextView) findViewById(R.id.textView2);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView.setOnClickListener(this);
			
			
		Intent intent = getIntent();
		try {
			String string1 	= intent.getStringExtra("title1");
			textView1.setText(string1);
			
			String	string	= intent.getStringExtra("data");
			JSONArray jsonArray = new JSONArray(string);
			
			int l = jsonArray.length();
			int[]  rainbow = new int[l];
             rainbow = this.getResources().getIntArray(R.array.rainbow);
	         for(int i=0; i<l; i++)
	         {
	        	 int	colors = rainbow[i];
	             String color = String.valueOf(colors);
	        	 obj = jsonArray.getJSONObject(i);
	        	 String title = obj.getString("title");
	        	 String url = obj.getString("link");
	      
	        	 HashMap<String,String> hashmap = new HashMap<String,String>();
	        	 hashmap.put(TITLE,obj.getString("title"));
                 hashmap.put("link", obj.getString("link"));
                 hashmap.put(colorss, color);
                 list.add(hashmap);
                 
             }
	         Adapter1 arrayAdapter = new Adapter1(MainActivity2.this,list);
             listview.setAdapter(arrayAdapter);
             listview.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id)  {
					
					
						Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
						intent.putExtra("link", list.get(position).get("link"));	               
		                startActivity(intent);
					}
             	   
                });
               
					} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	@Override
	public void onClick(View v) {
		Intent i = new Intent(MainActivity2.this,MainActivity.class);
		startActivity(i);
		
    }
	
}
		
		
			
			

