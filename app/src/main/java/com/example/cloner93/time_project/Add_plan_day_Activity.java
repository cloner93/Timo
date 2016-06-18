package com.example.cloner93.time_project;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Add_plan_day_Activity extends AppCompatActivity {
    private TextView displayTime;
    private TextView displayTime2;
    private EditText editText2;
    private CheckBox tag1;
    private CheckBox tag2;
    private CheckBox tag3;

    private int pHour;
    private int pMinute;
    private int pHour2=0;
    private int pMinute2=0;
    private int tag_1;
    private int tag_2;
    private int tag_3;
    String time_start;
    String time_end="0:0";
    static final int TIME_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID2 = 1;
    int d;
    Db db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan_day);

        db =new Db(this);

        tag1 = (CheckBox)findViewById(R.id.checkBox3);
        tag2 = (CheckBox)findViewById(R.id.checkBox4);
        tag3 = (CheckBox)findViewById(R.id.checkBox5);
        editText2 = (EditText) findViewById(R.id.editText2);
        displayTime = (TextView) findViewById(R.id.textView4);
        displayTime2 = (TextView) findViewById(R.id.textView7);
        displayTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                d=0;
                showDialog(TIME_DIALOG_ID);
            }
        });
        displayTime2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                d=1;
                showDialog(TIME_DIALOG_ID2);
            }
        });


        final Calendar cal = Calendar.getInstance();
        pHour = cal.get(Calendar.HOUR_OF_DAY);
        pMinute = cal.get(Calendar.MINUTE);
        pHour2 = cal.get(Calendar.HOUR_OF_DAY);
        pMinute2 = cal.get(Calendar.MINUTE);
            if(d==0)
                updateDisplay();
            else
                updateDisplay2();
    }

    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            pHour = hourOfDay;
            pMinute = minute;
            updateDisplay();
        }
    };
    private TimePickerDialog.OnTimeSetListener mTimeSetListener2 = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            pHour2 = hourOfDay;
            pMinute2 = minute;
            updateDisplay2();
        }
    };
    private void updateDisplay() {
        displayTime.setText(new StringBuilder().append(pad(pHour)).append(":").append(pad(pMinute)));
        time_start=String.valueOf(pHour)+":"+ String.valueOf(pMinute);
    }
    private void updateDisplay2() {
        displayTime2.setText(new StringBuilder().append(pad(pHour2)).append(":").append(pad(pMinute2)));
        time_end=String.valueOf(pHour2)+":"+ String.valueOf(pMinute2);
    }
    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,mTimeSetListener, pHour, pMinute, false);
            case TIME_DIALOG_ID2:
                return new TimePickerDialog(this,mTimeSetListener2, pHour2, pMinute2, false);
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_plan_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Bundle intget = getIntent().getExtras();
        final String plan_id = intget.getString("plan_id");
        final String day = intget.getString("day");
        final String date = intget.getString("date");
        int dayto=Integer.valueOf(day);

        if(tag1.isChecked())
            tag_1=1;
        else
            tag_1=0;

        if(tag2.isChecked())
            tag_2=1;
        else
            tag_2=0;

        if(tag3.isChecked())
            tag_3=1;
        else
            tag_3=0;
        int notice=1;
        int notice_time=10;
        int nitice_time_no=1;
        String notice_comment="OK";

        int notice_sound=1;
        int notice_vibrate=1;

        int id = item.getItemId();
        if (id == R.id.action_save_plan) {
            try {
                db.insert_tbl_all_day(plan_id, String.valueOf(date), time_start, time_end, dayto, tag_1, tag_2, tag_3, editText2.getText().toString(), notice, notice_time, nitice_time_no, notice_comment, notice_sound, notice_vibrate);
                Log.d("Database", "Adding to   <<<table tbl_all_day>>>");

                if(notice!=0) {
                    AlarmReciever.comment=editText2.getText().toString();
                    Intent i = new Intent(getApplicationContext(), AlarmReciever.class);
                    PendingIntent operation = PendingIntent.getBroadcast(getApplicationContext(), 0, i, 0);
                    AlarmManager alarmManager = (AlarmManager) getBaseContext().getSystemService(ALARM_SERVICE);
                    GregorianCalendar calendar = new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, pHour, pMinute+1);
                    long alarm_time = calendar.getTimeInMillis();
                    Log.e("Time & Date",String.valueOf(Calendar.YEAR)+"/"+String.valueOf(Calendar.MONTH)+"/"+String.valueOf(Calendar.DAY_OF_MONTH)+"   "+String.valueOf(Calendar.HOUR_OF_DAY)+":"+String.valueOf(Calendar.MINUTE));
                    alarmManager.set(AlarmManager.RTC_WAKEUP, alarm_time, operation);
                    Toast.makeText(getBaseContext(), "Alarm is set successfully", Toast.LENGTH_SHORT).show();
                }

                finish();
                Toast.makeText(getApplicationContext(), "Down!", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e) {
                Toast.makeText(Add_plan_day_Activity.this, "OK!!!", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
