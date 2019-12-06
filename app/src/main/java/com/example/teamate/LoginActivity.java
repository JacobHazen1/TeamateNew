package com.example.teamate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.teamate.data.Account;
import com.example.teamate.data.MyDBHandler;
import com.example.teamate.data.TestActivity;

import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private Button signupbutton;
    private EditText email;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        loginButton = (Button) findViewById(R.id.btnlogin);


        email = (EditText) findViewById(R.id.emailtext);
        password = (EditText) findViewById(R.id.passwordtext);
        email.getText();
        password.getText();

        loginButton.setOnClickListener(new View.OnClickListener(){
            String em = email.toString();
            String pas = password.toString();

            @Override
            public void onClick(View view) {
                if (email.equals(em) && password.equals(pas) ) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else {
                    Toast.makeText(LoginActivity.this, "Wrong password/usermames",Toast.LENGTH_SHORT).show();
                }
            }
        });
        signupbutton = (Button) findViewById(R.id.signuppage);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, Signup.class));
            }
        });
    }
}
