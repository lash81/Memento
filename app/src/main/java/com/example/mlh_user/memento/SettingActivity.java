package com.example.mlh_user.memento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {

    @Bind(R.id.timePicker)
    TimePicker timePicker;

    @Bind(R.id.setTimeButton)
    Button timeButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.setTimeButton)
    public void setTime(View v) {
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();
        Log.d("Set Time", String.format("We set: %d:%d", hour, minute));
        MementoApp.setTimeToGoHome(hour, minute);
        finish();
    }
}
