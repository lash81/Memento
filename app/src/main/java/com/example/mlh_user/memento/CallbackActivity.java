package com.example.mlh_user.memento;

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

        // TODO: FIll params
        RideParameters rideParameters = new RideParameters.Builder()
                .build();

        requestButton.setRideParameters(rideParameters);
    }
}
