package com.example.cloner93.time_project;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.cloner93.time_project.R;

import java.util.ArrayList;
import java.util.HashMap;

public class TabFragment5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.tab_fragment5, container, false);

        ImageView emptyimg = (ImageView)v.findViewById(R.id.imageView8);
        int vid=values.plan_day_id;
        int vtab=values.tab_number;
        int vday=values.plan_day_num;

        ListView ag=(ListView) v.findViewById(R.id.listView4);

        final Db k = new Db(v.getContext());
        final String g[], z[],q[];
        g = k.getAll11(vid, 5);
        z = k.getAll12(vid, 5);
        q = k.getAll13(vid, 5);
        Log.e("----->>" + String.valueOf(vid), "tab5 id");
        Log.e("----->>" + String.valueOf(vtab), "tab5 tab num");
        ArrayList<HashMap<String, String>> get;
        get = new ArrayList<>();
        if(g.length!=0)
        {
            for (int i = 0; i < g.length; i++) {
                HashMap<String, String> get2 = new HashMap<>();
                get2.put("y", g[i]);
                get2.put("s", z[i]);
                get2.put("w", q[i]);
                get.add(get2);
            }
            ListAdapter liasatp = new SimpleAdapter(v.getContext(), get, R.layout.listview_day, new String[]{"y", "s", "w"}, new int[]{R.id.time_start, R.id.time_end, R.id.day_command});
            ag.setAdapter(liasatp);
            Log.e("Empty","Listview NOT is empty");
            emptyimg.setVisibility(View.INVISIBLE);
            ag.setVisibility(View.VISIBLE);
        }
        else
        {
            Log.e("Empty", "Listview is empty");
            emptyimg.setVisibility(View.VISIBLE);
            ag.setVisibility(View.INVISIBLE);
        }


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("onResume", "onResume");

        ImageView emptyimg = (ImageView)getActivity().findViewById(R.id.imageView8);
        int vid=values.plan_day_id;
        int vtab=values.tab_number;
        int vday=values.plan_day_num;

        ListView ag=(ListView) getActivity().findViewById(R.id.listView6);


        final Db k = new Db(getActivity().getApplicationContext());
        final String g[], z[],q[];
        g = k.getAll11(vid, 5);
        z = k.getAll12(vid, 5);
        q = k.getAll13(vid, 5);
        Log.e("----->>" + String.valueOf(vid), "tab5 id");
        Log.e("----->>" + String.valueOf(vtab), "tab5 tab num");
        ArrayList<HashMap<String, String>> get;
        get = new ArrayList<>();
        if(g.length!=0)
        {
            for (int i = 0; i < g.length; i++) {
                HashMap<String, String> get2 = new HashMap<>();
                get2.put("y", g[i]);
                get2.put("s", z[i]);
                get2.put("w", q[i]);
                get.add(get2);
            }
            ListAdapter liasatp = new SimpleAdapter(getActivity().getApplicationContext(), get, R.layout.listview_day, new String[]{"y", "s", "w"}, new int[]{R.id.time_start, R.id.time_end, R.id.day_command});
            ag.setAdapter(liasatp);
            Log.e("Empty","Listview NOT is empty");
            emptyimg.setVisibility(View.INVISIBLE);
            ag.setVisibility(View.VISIBLE);
        }
        else
        {
            Log.e("Empty", "Listview is empty");
            emptyimg.setVisibility(View.VISIBLE);
            ag.setVisibility(View.INVISIBLE);
        }
    }
}