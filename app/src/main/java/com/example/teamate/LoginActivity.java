package com.example.teamate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.*;

import com.example.teamate.data.Account;
import com.example.teamate.data.MyDBHandler;
import com.example.teamate.data.TestActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private Button signupbutton;
    private EditText email;
    private EditText password;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference noteRef = db.document("Login Data/Users");
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_Password= "Password" ;
    private static final String KEY_COMPANY = "Company";
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
        password.setTransformationMethod(new PasswordTransformationMethod());

//        loginButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                if (email.equals(em) && password.equals(pas) ) {
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                }else {
//                    Toast.makeText(LoginActivity.this, "Wrong password/usermames",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        signupbutton = (Button) findViewById(R.id.signuppage);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, Signup.class));
            }
        });
    }
    public void finduser(View v){
        noteRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        email.getText().toString();
                        password.getText().toString();
                        if (documentSnapshot.exists()){
                            String useremail = documentSnapshot.getString(KEY_EMAIL);
                            String upassword = documentSnapshot.getString(KEY_Password);
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));


                        }else{
                            Toast.makeText(LoginActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this, "ERROR", Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
