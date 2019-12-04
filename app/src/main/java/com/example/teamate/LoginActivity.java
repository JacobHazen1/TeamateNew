package com.example.teamate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.teamate.data.Account;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button btnLogin;
    MyDBHandler dbHandler;
    Account montek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // get text fields and buttons ready
        email = (EditText) findViewById(R.id.emailtext);
        password = (EditText) findViewById(R.id.passwordtext);
        btnLogin = (Button) findViewById(R.id.btnlogin);
        // initialize database
        dbHandler = new MyDBHandler(this);
        // create accounts
        montek = new Account("Montek", "Parmar", "montek@gmail.com", "monpar", 1, 2, "fuck");
        boolean isInserted = dbHandler.insertData(montek);
        // check if account was added
        if (isInserted == true) {
            Toast.makeText(LoginActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        } else  {
            Toast.makeText(LoginActivity.this, "Data NOT Inserted", Toast.LENGTH_LONG).show();
        }
    }

    /*public void checkLogin() {
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Account tempAccount = dbHandler.findAccount(email.getText().toString());
                        if (tempAccount.getEmail().equalsIgnoreCase(email.getText().toString()) && tempAccount.getPassword().equalsIgnoreCase(password.getText().toString())) {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Wrong email or password.", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }*/
}
