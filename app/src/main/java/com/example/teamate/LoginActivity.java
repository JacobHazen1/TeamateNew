package com.example.teamate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.teamate.data.Account;
import com.example.teamate.data.MyDBHandler;
import com.example.teamate.data.TestActivity;
import com.example.teamate.ui.dashboard.DashboardFragment;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHandler = new MyDBHandler(this);

        Account montek = new Account("Montek", "Parmar", "montek@gmail.com", "monpar", 1, 3, "fuck");

        dbHandler.addHandler(montek);

        email = (EditText) findViewById(R.id.emailtext);
        password = (EditText) findViewById(R.id.passwordtext);

        Button loginButton = (Button) findViewById(R.id.btnlogin);

        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Account account = dbHandler.findHandler(email.getText().toString());
                if (account.getEmail().equals(email.getText().toString()) && account.getPassword().equals(password.getText().toString())) {
                    startActivity(new Intent(LoginActivity.this, TestActivity.class));
                    System.out.println("Welcome " + account.getFirstName());
                } else {
                    System.out.println("Error");
                }
            }
        });
    }
}
