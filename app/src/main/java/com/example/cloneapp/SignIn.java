package com.example.cloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseEncoder;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignIn extends AppCompatActivity {

    EditText emailText, passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailText = findViewById(R.id.emailEntry);
        passwordText = findViewById(R.id.passEntry);
    }

    public void logInClick(View view){
        if(!emailText.getText().toString().equals("") && !emailText.getText().toString().equals("")){

            ParseUser userEntry = new ParseUser();
            userEntry.logInInBackground(emailText.getText().toString(), emailText.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if(e==null)
                    {
                        Toast.makeText(SignIn.this,"User" + user.getUsername() + "has been logged in",Toast.LENGTH_SHORT);
                    }
                }
            });
        } else {
            FancyToast.makeText(SignIn.this,"Enter Email ID and Password",FancyToast.LENGTH_SHORT,FancyToast.ERROR,true).show();
        }
    }
}