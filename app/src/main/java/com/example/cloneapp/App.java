package com.example.cloneapp;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("h1XxnBPM0W4DaPrgkVCfXfHONeIvs5rI83FDr1Si")
                .clientKey("hA2xcWGtHiWgEg5jk3nTduxZVUfvLM4JUuFWYSyu")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
