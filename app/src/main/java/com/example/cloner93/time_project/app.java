package com.example.cloner93.time_project;

/**
 * Created by cloner93 on 6/19/16.
 */

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

public class app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Don't do this! This is just so cold launches take some time
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}