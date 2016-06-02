package com.example.cloner93.time_project;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentOne extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_one, container, false);
                v.findViewById(R.id.nav_camera);

        Db k=new Db(v.getContext());
        String g[];
        ListView ag=(ListView) v.findViewById(R.id.listView);
            ArrayList<HashMap<String,String>> pro;
            pro=new ArrayList<HashMap<String,String>>();
            g=k.getAll1();

            for(int i=0;i<g.length;i++){

                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("name",g[i]);
                pro.add(hashMap);
            }

            ListAdapter asd= new SimpleAdapter(v.getContext(),pro,R.layout.listview_plan,new String[]{"name"},new int[]{R.id.secondLine});
            ag.setAdapter(asd);
        return v;
    }
}