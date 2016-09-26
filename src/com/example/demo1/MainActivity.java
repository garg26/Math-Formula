package com.example.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.demo1.R.drawable;

import android.R.anim;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class MainActivity extends Activity{ 	
	
	public String title2;
	static final String TITLE = "title";
	static final String colorss = "color";
	JSONArray array1;
	JSONObject object;
	ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.android_main);
		
		
		
	    ListView listview = (ListView) findViewById(R.id.listView1);
	    StringBuffer str = new StringBuffer();
           try {
        	BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("boardexam.json")));
            String temp;
            while ((temp = br.readLine()) != null)
                str.append(temp);
            br.close();
           } catch (IOException e) {
            e.printStackTrace();
          } 
          String readFile = str.toString();
          try {
				  
                JSONObject json = new JSONObject(readFile);
                JSONArray array = json.getJSONArray("data");
                HashMap<String,String> hash = new HashMap<String,String>();
                int l = array.length();
                int[]  rainbow = new int[l];
                rainbow = this.getResources().getIntArray(R.array.rainbow);
                for(int i=0; i<l; i++) {
                int	colors = rainbow[i];
                String color = String.valueOf(colors);
                	object  = array.getJSONObject(i);
                    array1   = object.getJSONArray("data");
               
                   HashMap<String,String> hashmap = new HashMap<String,String>();
                   hashmap.put(TITLE,object.getString("title").toString());
                   hashmap.put("data", array1.toString());
                   hashmap.put("title1", object.getString("title").toString());
                   hashmap.put(colorss, color);
                   list.add(hashmap);
                   
               }
                Adapter1 arrayAdapter = new Adapter1(MainActivity.this,list);
                listview.setAdapter(arrayAdapter);
                
                listview.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
					
					Intent intent = new Intent(MainActivity.this,MainActivity2.class);
			
						Bundle b = new Bundle();
						b.putString("data",list.get(position).get("data"));
						b.putString("title1",list.get(position).get("title1"));
			    		intent.putExtras(b);
		                startActivity(intent);
					}
                });
                  
              } catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 }
