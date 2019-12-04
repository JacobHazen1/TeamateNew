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
    private MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        loginButton = (Button) findViewById(R.id.btnlogin);

        dbHandler = new MyDBHandler(this);

        Account montek = new Account("Montek", "Parmar", "montek@gmail.com", "monpar", 1, 3, "fuck");

        dbHandler.addHandler(montek);

        email = (EditText) findViewById(R.id.emailtext);
        password = (EditText) findViewById(R.id.passwordtext);
        email.getText();
        password.getText();

        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Account account = dbHandler.findHandler(email.getText().toString());
                if (account.getEmail().equals(email.getText().toString()) && account.getPassword().equals(password.getText().toString())) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else {
                    startActivity(new Intent(LoginActivity.this, Contactus.class));
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
