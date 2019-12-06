package com.example.teamate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class    Signup extends AppCompatActivity {
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_Password= "Password" ;
    private static final String KEY_COMPANY = "Company";
    private static final String TAG ="Signup";
    private EditText emailentry;
    private EditText passentry;
    private EditText registercompany;
//    DatabaseReference reff;
//    User user;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        emailentry = (EditText) findViewById(R.id.emailregistertext);
        passentry = (EditText) findViewById(R.id.passwordregistertext);
        registercompany = (EditText)findViewById(R.id.registercompany);
        passentry.setTransformationMethod(new PasswordTransformationMethod());
    }
    public void saveNote (View v){
        String em = emailentry.getText().toString().trim();
        String pe = passentry.getText().toString().trim();
        String rc =registercompany.getText().toString().trim();
        Map<String, Object> note = new HashMap<>();
        note.put(KEY_EMAIL, em);
        note.put(KEY_Password, pe);
        note.put(KEY_COMPANY, rc);

        db.collection("Login Data").document("Users").set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(Signup.this, "Account Created", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Signup.this, MainActivity.class));

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Signup.this, "ERROR", Toast.LENGTH_SHORT).show();
                Log.d(TAG,e.toString());

            }
        });
    }

}
