package com.example.mlh_user.memento;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the EDIT TIME button */
    public void editTime(View view) {
        Intent myIntent = new Intent(this, SettingActivity.class); // switches current Activity to SettingActivity
        startActivityForResult(myIntent, 0);
    }

    /** Called when another Activity finishes and returns to this Activity */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        // initialize
        Log.d("Call Ran", "Time was set");
        AlarmManager alarm = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);

        // set up receiver for trigger
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("Call Ran", "Received Intent");
                startActivity(new Intent(context, CallbackActivity.class));
            }
        };
        IntentFilter intentFilter = new IntentFilter("ping_phone"); // this is the action (+ tag)
        registerReceiver(receiver, intentFilter);

        // set up time to ping
        Calendar c = GregorianCalendar.getInstance(); // calendar with date/time = current date/time
        Intent myIntent = new Intent("ping_phone");
        PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 1, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            // Request code = 1
        alarm.set(AlarmManager.RTC_WAKEUP,5000+c.getTimeInMillis(),sender);
    }
}
