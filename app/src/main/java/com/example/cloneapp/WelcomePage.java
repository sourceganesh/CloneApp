package com.example.cloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        setTitle("Instagram. Well, More or less.");
    }
}
