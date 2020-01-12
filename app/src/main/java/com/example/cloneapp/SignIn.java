package com.example.cloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import org.w3c.dom.Text;

public class SignIn extends AppCompatActivity {

    EditText emailText, passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Instagram. Well, More or less.");
        emailText = findViewById(R.id.emailEntry);
        passwordText = findViewById(R.id.passEntry);
        if(ParseUser.getCurrentUser()!=null)
            ParseUser.getCurrentUser().logOut();
    }

    public void logInClick(View view){
        if(!emailText.getText().toString().equals("") && !passwordText.getText().toString().equals("")){

            ParseUser userEntry = new ParseUser();
            userEntry.logInInBackground(emailText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if(e==null)
                    {
                        Toast.makeText(SignIn.this,"User " + user.getUsername() + " has been logged in",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        FancyToast.makeText(SignIn.this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,true).show();
                    }
                }
            });
        } else {
            FancyToast.makeText(SignIn.this,"Enter Email ID and Password",FancyToast.LENGTH_SHORT,FancyToast.WARNING,true).show();
        }
    }

    public void signUpRedirect(View view) {
        Intent intent = new Intent(SignIn.this, SignUp.class);
        startActivity(intent);
    }

}