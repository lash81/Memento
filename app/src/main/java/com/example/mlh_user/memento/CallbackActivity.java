package com.example.mlh_user.memento;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uber.sdk.android.rides.RequestButton;
import com.uber.sdk.android.rides.RideParameters;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CallbackActivity extends AppCompatActivity {

    @Bind(R.id.OkayHomeButton)
    RequestButton requestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        ButterKnife.bind(this);
        requestButton.setClientId(UberInformation.clientID);

//        try {
//            PackageManager pm = this.getApplicationContext().getPackageManager();
//            pm.getPackageInfo("com.ubercab", PackageManager.GET_ACTIVITIES);
//            String uri =
//                    "uber://?action=setPickup&pickup=my_location&client_id="+UberInformation.clientID;
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse(uri));
//            startActivity(intent);
//        } catch (PackageManager.NameNotFoundException e) {
//            // No Uber app! Open mobile website.
//            String url = "https://m.uber.com/sign-up?client_id="+UberInformation.clientID;
//            Intent i = new Intent(Intent.ACTION_VIEW);
//            i.setData(Uri.parse(url));
//            startActivity(i);
//        }

    }
}
