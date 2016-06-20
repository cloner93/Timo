package com.example.cloner93.time_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Objects;

public class Plan_day_Activity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    //public int tabb =0;

    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_day);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        values.tab_number =i;



        Bundle intent = getIntent().getExtras();
        final String plan_id = intent.getString("plan_id");
        final String day = intent.getString("day");
        final String name = intent.getString("name");
        final String activity = intent.getString("activity");
        final String repeat = intent.getString("repeat");
        final String date_create = intent.getString("date_create");

        int day_num = Integer.parseInt(day);
        values.plan_day_id = Integer.parseInt(plan_id);
        values.plan_day_num=Integer.parseInt(day);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);


        if(Objects.equals(day, "1")){
            assert tabLayout != null;
            tabLayout.addTab(tabLayout.newTab().setText("Day 1"));
        }else if(Objects.equals(day, "2")) {
            assert tabLayout != null;
            tabLayout.addTab(tabLayout.newTab().setText("Day 1"));
            tabLayout.addTab(tabLayout.newTab().setText("Day 2"));

        }else if(Objects.equals(day, "3")){
            assert tabLayout != null;
            tabLayout.addTab(tabLayout.newTab().setText("Day 1"));
            tabLayout.addTab(tabLayout.newTab().setText("Day 2"));
            tabLayout.addTab(tabLayout.newTab().setText("Day 3"));

        }else if(Objects.equals(day, "4")){
            assert tabLayout != null;
            tabLayout.addTab(tabLayout.newTab().setText("1"));
            tabLayout.addTab(tabLayout.newTab().setText("2"));
            tabLayout.addTab(tabLayout.newTab().setText("3"));
            tabLayout.addTab(tabLayout.newTab().setText("4"));

        }else if (Objects.equals(day, "5")){
            assert tabLayout != null;
            tabLayout.addTab(tabLayout.newTab().setText("1"));
            tabLayout.addTab(tabLayout.newTab().setText("2"));
            tabLayout.addTab(tabLayout.newTab().setText("3"));
            tabLayout.addTab(tabLayout.newTab().setText("4"));
            tabLayout.addTab(tabLayout.newTab().setText("5"));

        }else if (Objects.equals(day, "6")){
            assert tabLayout != null;
            tabLayout.addTab(tabLayout.newTab().setText("1"));
            tabLayout.addTab(tabLayout.newTab().setText("2"));
            tabLayout.addTab(tabLayout.newTab().setText("3"));
            tabLayout.addTab(tabLayout.newTab().setText("4"));
            tabLayout.addTab(tabLayout.newTab().setText("5"));
            tabLayout.addTab(tabLayout.newTab().setText("6"));

        }else if (Objects.equals(day, "7")){
            assert tabLayout != null;
            tabLayout.addTab(tabLayout.newTab().setText("1"));
            tabLayout.addTab(tabLayout.newTab().setText("2"));
            tabLayout.addTab(tabLayout.newTab().setText("3"));
            tabLayout.addTab(tabLayout.newTab().setText("4"));
            tabLayout.addTab(tabLayout.newTab().setText("5"));
            tabLayout.addTab(tabLayout.newTab().setText("6"));
            tabLayout.addTab(tabLayout.newTab().setText("7"));

        }else if (Objects.equals(day, "8")){
            assert tabLayout != null;
            tabLayout.addTab(tabLayout.newTab().setText("1"));
            tabLayout.addTab(tabLayout.newTab().setText("2"));
            tabLayout.addTab(tabLayout.newTab().setText("3"));
            tabLayout.addTab(tabLayout.newTab().setText("4"));
            tabLayout.addTab(tabLayout.newTab().setText("5"));
            tabLayout.addTab(tabLayout.newTab().setText("6"));
            tabLayout.addTab(tabLayout.newTab().setText("7"));
            tabLayout.addTab(tabLayout.newTab().setText("8"));

        }else if (Objects.equals(day, "9")){
            assert tabLayout != null;
            tabLayout.addTab(tabLayout.newTab().setText("1"));
            tabLayout.addTab(tabLayout.newTab().setText("2"));
            tabLayout.addTab(tabLayout.newTab().setText("3"));
            tabLayout.addTab(tabLayout.newTab().setText("4"));
            tabLayout.addTab(tabLayout.newTab().setText("5"));
            tabLayout.addTab(tabLayout.newTab().setText("6"));
            tabLayout.addTab(tabLayout.newTab().setText("7"));
            tabLayout.addTab(tabLayout.newTab().setText("8"));
            tabLayout.addTab(tabLayout.newTab().setText("9"));

        }else if (Objects.equals(day, "10")){
            assert tabLayout != null;
            tabLayout.addTab(tabLayout.newTab().setText("1"));
            tabLayout.addTab(tabLayout.newTab().setText("2"));
            tabLayout.addTab(tabLayout.newTab().setText("3"));
            tabLayout.addTab(tabLayout.newTab().setText("4"));
            tabLayout.addTab(tabLayout.newTab().setText("5"));
            tabLayout.addTab(tabLayout.newTab().setText("6"));
            tabLayout.addTab(tabLayout.newTab().setText("7"));
            tabLayout.addTab(tabLayout.newTab().setText("8"));
            tabLayout.addTab(tabLayout.newTab().setText("9"));
            tabLayout.addTab(tabLayout.newTab().setText("10"));
        }

        assert tabLayout != null;
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        assert viewPager != null;
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                i=tab.getPosition()+1;
                values.tab_number =i;
                Log.e("***----->>"+String.valueOf(i),"tab");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab1);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Add_plan_day_Activity.class);

                intent.putExtra("plan_id", plan_id);
                intent.putExtra("day", String.valueOf(i));
                intent.putExtra("date", String.valueOf(date_create));
                //Toast.makeText(getApplicationContext(),plan_id +"  "+i+"  "+date_create, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Plan_day_ Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.cloner93.time_project/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Plan_day_ Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.cloner93.time_project/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
