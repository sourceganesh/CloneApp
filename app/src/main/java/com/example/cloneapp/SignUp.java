package com.example.cloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {

    EditText getName,getEmail,pass,passReconfirm;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getName = findViewById(R.id.getName);
        getEmail = findViewById(R.id.getEmail);
        pass = findViewById(R.id.getPass);
        passReconfirm =findViewById(R.id.getPassReconfirm);

    }

    public void SignUpClick(View view){
        if(!getName.getText().toString().equals("") && !getEmail.getText().toString().equals("") && !pass.getText().toString().equals("") && !passReconfirm.getText().toString().equals("")){
            if(pass.getText().toString().equals(passReconfirm.getText().toString())){

                ParseUser newUser = new ParseUser();
                newUser.setUsername(getName.getText().toString());
                newUser.setEmail(getEmail.getText().toString());
                newUser.setPassword(pass.getText().toString());
                final ProgressDialog SignUp = new ProgressDialog(this);
                SignUp.setMessage("Signing Up and Signing in");
                SignUp.show();
                newUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null)
                        {
                            FancyToast.makeText(SignUp.this,"You have been Signed In!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                            SignUp.dismiss();
                        }
                        else
                        {
                            FancyToast.makeText(SignUp.this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,true).show();
                        }
                    }
                });

            } else {
                FancyToast.makeText(SignUp.this,"Passwords Do not match",FancyToast.LENGTH_LONG,FancyToast.WARNING,true).show();
            }
        }else
            FancyToast.makeText(SignUp.this,"Please Enter All Fields",FancyToast.LENGTH_SHORT,FancyToast.WARNING,true).show();
    }

    public void logInRedir(View view){
        Intent intent = new Intent(SignUp.this,SignIn.class);
        startActivity(intent);
    }
}
