package com.example.ctadmin.fblogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import android.view.View;

import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    LoginButton loginButton;
    TextView textView;

    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        loginButton= (LoginButton)findViewById(R.id.login_button);
        textView=(TextView)findViewById(R.id.sample_text_view);
        callbackManager= CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


                TextView textview = (TextView) findViewById(R.id.sample_text_view);
                String text = textview.getText().toString();
                textview.setText("(: Conncted To the given Fb Account :)");

            }



            @Override
            public void onCancel() {


            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}