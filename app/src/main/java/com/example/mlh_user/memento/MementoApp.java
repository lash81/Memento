package com.example.mlh_user.memento;

import android.app.Application;

/**
 * Created by MLH-User on 2/13/2016.
 */
public class MementoApp extends Application {

    private static int[] TIME_TO_GO_HOME = new int[2];

    public static int[] getTimeToGoHome() {
        return TIME_TO_GO_HOME;
    }

    public static void setTimeToGoHome(int hour, int minute) {
        TIME_TO_GO_HOME[0] = hour;
        TIME_TO_GO_HOME[1] = minute;
    }
}
