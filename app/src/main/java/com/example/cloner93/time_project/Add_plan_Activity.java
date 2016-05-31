package com.example.cloner93.time_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Add_plan_Activity extends AppCompatActivity {

    Db db;
    EditText editText;
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
        final TextView textView=(TextView) findViewById(R.id.textView2);
        final TextView textView3=(TextView) findViewById(R.id.textView3);
        final SeekBar seekBar=(SeekBar) findViewById(R.id.seekBar);
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
                textView3.setText(String.valueOf(progress));

            }
        });
        //String seekBarValue= (String) textView3.getText();  get seekbar value

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_plan_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save_plan) {
            //Toast.makeText(Add_plan_Activity.this, "OK", Toast.LENGTH_SHORT).show();
            //db.insert_tbl_plan_day();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
