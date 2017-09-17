package com.example.james.kpop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartScreen extends AppCompatActivity {

    private View mLoginButton;
    private View mSigninButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            Intent i = new Intent(StartScreen.this, MainActivity.class);
            startActivity(i);
        }
        setContentView(R.layout.start_screen);
        mLoginButton = findViewById(R.id.login_button);
        mSigninButton = findViewById(R.id.signin_button);
    }

    protected void onResume(){
        super.onResume();
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartScreen.this, LoginActivity.class);
                startActivity(i);
            }
        });

        mSigninButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartScreen.this, SignUp.class);
                startActivity(i);
            }
        });
    }
}
