package com.example.cloner93.time_project;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_one, container, false);
                v.findViewById(R.id.nav_camera);
        return v;


    }
}