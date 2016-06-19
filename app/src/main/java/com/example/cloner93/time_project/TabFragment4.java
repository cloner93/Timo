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

public class TabFragment4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.tab_fragment4, container, false);


        int vid=values.plan_day_id;
        int vtab=values.tab_number;
        int vday=values.plan_day_num;

        ListView ag=(ListView) v.findViewById(R.id.listView4);

        final Db k = new Db(v.getContext());
        final String g[], z[],q[];
        g = k.getAll11(vid, 4);
        z = k.getAll12(vid, 4);
        q = k.getAll13(vid, 4);
        Log.e("----->>" + String.valueOf(vid), "tab4 id");
        Log.e("----->>" + String.valueOf(vtab), "tab4 tab num");
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
        }


        return v;
    }


}