package com.ranjeevmahtani.brackit;

import android.app.Application;

import com.ranjeevmahtani.brackit.config.Configuration;

/**
 * Application singleton to perform app startup activities
 */
public class BrackItApplication extends Application {

    public void onCreate() {
        super.onCreate();

        Configuration.init(this);
    }
}