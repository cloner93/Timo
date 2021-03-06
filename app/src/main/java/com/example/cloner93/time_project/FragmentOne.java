package com.example.cloner93.time_project;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentOne extends Fragment {
    TextView txt;
    Db db;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.fragment_one, container, false);
                v.findViewById(R.id.nav_camera);


        final ListView ag=(ListView) v.findViewById(R.id.listView);
        ImageView emptyimg = (ImageView)v.findViewById(R.id.imageView3);
        final Db k=new Db(v.getContext());
        final String g[],q[];
        ArrayList<HashMap<String,String>> pro;
        pro=new ArrayList<HashMap<String,String>>();
        g=k.getAll1();
        q=k.getAll1_2();
        for(int i=0;i<g.length;i++)
            {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("name",g[i]);
                hashMap.put("day",q[i]);
                pro.add(hashMap);
            }
        ListAdapter asd= new SimpleAdapter(v.getContext(),pro,R.layout.listview_plan,new String[]{"name","day"},new int[]{R.id.time_start,R.id.secondLine});
        ag.setAdapter(asd);
        if(asd.isEmpty())
        {
            Log.e("Empty", "Listview is empty");
            emptyimg.setVisibility(View.VISIBLE);
            ag.setVisibility(View.INVISIBLE);
        }
        else{
            Log.e("Empty","Listview NOT is empty");
            emptyimg.setVisibility(View.INVISIBLE);
            ag.setVisibility(View.VISIBLE);
        }

            registerForContextMenu(ag);
        ag.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {
                // TODO Auto-generated method stub
                Log.v("long clicked","pos: " + pos);
                return true;
            }
        });
        ag.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                //String te=String.valueOf(txt);
                String selected = ((TextView) view.findViewById(R.id.time_start)).getText().toString();
                    try {
                        HashMap<String,String> puta;
                        puta=k.getUserDetails(String.valueOf(selected));
                        String plan_id=puta.get("id");
                        String day=puta.get("day");
                        String name=puta.get("name");
                        String activity=puta.get("activity");
                        String repeat=puta.get("repeat");
                        String date_create=puta.get("date_create");

                        Intent intent=new Intent(v.getContext(),Plan_day_Activity.class);
                        intent.putExtra("plan_id", plan_id);
                        intent.putExtra("day", day);
                        intent.putExtra("name", name);
                        intent.putExtra("activity", activity);
                        intent.putExtra("repeat", repeat);
                        intent.putExtra("date_create", date_create);
                        startActivity(intent);

                        Log.i("fragment one", "Get Plan day DOWN!!!!");
                    }
                    catch (Exception e){
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
            }

        });

        return v;
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i("onResume", "onResume");




        final ListView ag=(ListView) getActivity().findViewById(R.id.listView);
        ImageView emptyimg = (ImageView)getActivity().findViewById(R.id.imageView3);
        final Db k=new Db(getActivity().getApplicationContext());
        final String g[],q[];
        ArrayList<HashMap<String,String>> pro;
        pro=new ArrayList<HashMap<String,String>>();
        g=k.getAll1();
        q=k.getAll1_2();
        for(int i=0;i<g.length;i++)
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name",g[i]);
            hashMap.put("day",q[i]);
            pro.add(hashMap);
        }
        ListAdapter asd= new SimpleAdapter(getActivity().getApplicationContext(),pro,R.layout.listview_plan,new String[]{"name","day"},new int[]{R.id.time_start,R.id.secondLine});
        ag.setAdapter(asd);
       if(asd.isEmpty())
       {
           Log.e("Empty", "Listview is empty");
           emptyimg.setVisibility(View.VISIBLE);
           ag.setVisibility(View.INVISIBLE);
       }
       else{
        Log.e("Empty","Listview NOT is empty");
        emptyimg.setVisibility(View.INVISIBLE);
        ag.setVisibility(View.VISIBLE);
        }
    }
}