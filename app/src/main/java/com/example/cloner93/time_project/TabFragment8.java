package com.example.cloner93.time_project;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.cloner93.time_project.R;

import java.util.ArrayList;
import java.util.HashMap;

public class TabFragment8 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.tab_fragment8, container, false);


        int vid=values.plan_day_id;
        int vtab=values.tab_number;
        int vday=values.plan_day_num;

        ListView ag=(ListView) v.findViewById(R.id.listView9);

        final Db k = new Db(v.getContext());
        final String g[], z[];
        g = k.getAll11(vid, 8);
        z = k.getAll12(vid, 8);
        Log.e("----->>" + String.valueOf(vid), "tab8 id");
        Log.e("----->>" + String.valueOf(vtab), "tab8 tab num");
        ArrayList<HashMap<String, String>> get;
        get = new ArrayList<>();
        if(g.length!=0)
        {
            for (int i = 0; i < g.length; i++) {
                HashMap<String, String> get2 = new HashMap<>();
                get2.put("y", g[i]);
                get2.put("s", z[i]);
                get.add(get2);
            }
            ListAdapter liasatp = new SimpleAdapter(v.getContext(), get, R.layout.listview_day, new String[]{"y", "s"}, new int[]{R.id.time_start, R.id.time_end});
            ag.setAdapter(liasatp);
        }


        return v;
    }


}