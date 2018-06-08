package com.gabar.mvpsample;

import android.app.Application;
import android.content.Context;

/**
 * Created by sanjeev on 7/8/17.
 */


public class MyCustomApplciation extends Application {
    public static Context context=null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
    }

    public static Context getInstance(){
        return context;
    }
}
