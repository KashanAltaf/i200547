package com.kashanaltaf.i200547;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity3 extends AppCompatActivity {

    Button b1;
    Button b2;
    EditText e1, e2, e3, e4, e5;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main3);
        b1 = (Button) findViewById(R.id.but1);
        b2 = (Button) findViewById(R.id.but2);
        e1 = (EditText) findViewById(R.id.txtName);
        e2 = (EditText) findViewById(R.id.txtEmail);
        e3 = (EditText) findViewById(R.id.txtNum);
        e4 = (EditText) findViewById(R.id.txtCtry);
        e5 = (EditText) findViewById(R.id.txtCty);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String name, email, password, country, city;
                name = String.valueOf(e1.getText());
                email = String.valueOf(e2.getText());
                password = String.valueOf(e3.getText());
                country = String.valueOf(e4.getText());
                city = String.valueOf(e5.getText());

                if(TextUtils.isEmpty(name)){
                    Toast.makeText(MainActivity3.this, "Enter Name", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity3.this, "Enter Email", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity3.this, "Enter Password", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(country)){
                    Toast.makeText(MainActivity3.this, "Enter Country", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(city)){
                    Toast.makeText(MainActivity3.this, "Enter City", Toast.LENGTH_LONG).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(MainActivity3.this, "Authentication created.",
                                            Toast.LENGTH_SHORT).show();
                                    } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity3.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity2();
            }
        });
    }

    private void Activity2() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}