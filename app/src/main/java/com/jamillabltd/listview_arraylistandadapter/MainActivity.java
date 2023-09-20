package com.jamillabltd.listview_arraylistandadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);


        //TODO: ======== create item here ======

        //==== 1st Item =========
        hashMap = new HashMap<>();
        hashMap.put("name", "Jamil Ahmed");
        hashMap.put("mobile", "01712302246");
        arrayList.add(hashMap);

        //==== 2nd Item =========
        hashMap = new HashMap<>();
        hashMap.put("name", "Rasel Miah");
        hashMap.put("mobile", "017234543456");
        arrayList.add(hashMap);

        //==== 3rd Item =========
        hashMap = new HashMap<>();
        hashMap.put("name", "Shakil Ahmed");
        hashMap.put("mobile", "01834548734");
        arrayList.add(hashMap);

        //==== 4th Item =========
        hashMap = new HashMap<>();
        hashMap.put("name", "Towkir");
        hashMap.put("mobile", "01712302286");
        arrayList.add(hashMap);

        //==== 5th Item =========
        hashMap = new HashMap<>();
        hashMap.put("name", "Sahanur");
        hashMap.put("mobile", "01723483399");
        arrayList.add(hashMap);

        //================================


    }

    //======================================
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint("MissingInflatedId")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.list_item, parent, false);

            //TODO: ==== get data from hashmap ====
            hashMap = arrayList.get(position);

            TextView tvName = view.findViewById(R.id.tvName);
            TextView tvMobile = view.findViewById(R.id.tvMobile);

            tvName.setText(hashMap.get("name"));
            tvMobile.setText(hashMap.get("mobile"));


            //onclick to image action
            ImageView tvImage = view.findViewById(R.id.tvImage);
            tvImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Hello! \nPosition: "+ position, Toast.LENGTH_SHORT).show();
                }
            });

            return view;
        }
    }
    //======================================
}