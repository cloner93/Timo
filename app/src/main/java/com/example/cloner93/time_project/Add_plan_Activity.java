package com.example.cloner93.time_project;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ghasemkiani.util.icu.PersianCalendar;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Add_plan_Activity extends AppCompatActivity {

    Db db;
    PersianCalendar persianCalendar;

    String time;
    int seekBarValue;
    int ch1;
    int ch2;
    private EditText editText;
    CheckBox checkBox1;
    CheckBox checkBox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        db =new Db(this);
        checkBox1=(CheckBox)findViewById(R.id.checkBox);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        editText =(EditText) findViewById(R.id.editText);
        persianCalendar = new PersianCalendar(new Date());

        final TextView textView=(TextView) findViewById(R.id.textView2);
         TextView textView3=(TextView) findViewById(R.id.textView3);
        final SeekBar seekBar=(SeekBar) findViewById(R.id.seekBar);
        assert textView != null;
        assert seekBar != null;
        textView.setText(seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                textView.setText(progress + "/" + seekBar.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar  ) {
                textView.setText(progress + "/" + seekBar.getMax());
                seekBarValue=seekBar.getProgress();

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_plan_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_save_plan) {

            if(!checkBox1.isChecked())
                ch1=0;
            else
                ch2=1;
            /*
            persianCalendar1.get(Calendar.YEAR)
            persianCalendar1.get(Calendar.MONTH) + 1
            persianCalendar1.get(Calendar.DAY_OF_MONTH)
            persianCalendar1.get(Calendar.HOUR_OF_DAY)    HOUR_OF_DAY

            persianCalendar1.get(Calendar.MINUTE)
            persianCalendar1.get(Calendar.SECOND)
            */
            if(Objects.equals(editText.getText().toString(), "") || seekBarValue==0)
                Toast.makeText(Add_plan_Activity.this, "Full all value !!!", Toast.LENGTH_SHORT).show();
            else {
                time = String.valueOf(persianCalendar.get(Calendar.YEAR)) + "/" + String.valueOf(persianCalendar.get(Calendar.MARCH) + 1) + "/" + String.valueOf(persianCalendar.get(Calendar.DAY_OF_MONTH));
                db.insert_tbl_plan_day(editText.getText().toString(), seekBarValue, ch1, ch2, time);
                finish();
                Toast.makeText(getApplicationContext(), "Down!", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
