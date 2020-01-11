package com.example.cloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseEncoder;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    
    public void callClick(View Click){
        final ParseObject newClick = new ParseObject("Test Save");
        newClick.put("Name","Ganesh");
        Toast.makeText(SignIn.this,"Called",Toast.LENGTH_SHORT).show();
        newClick.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null)
                    Toast.makeText(SignIn.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SignIn.this, e.getMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });

    }

    

}