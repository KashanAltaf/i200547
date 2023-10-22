package com.ass2.i200547_i202433;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    FirebaseAuth mAuth;

    ProgressBar progressBar;
    EditText e1, e2;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity5.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main1);
        b1 = (Button) findViewById(R.id.eigh);
        b2 = (Button) findViewById(R.id.svn);
        b3 = (Button) findViewById(R.id.nin);
        e1 = (EditText) findViewById(R.id.f);
        e2 = (EditText) findViewById(R.id.sx);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        database.keepSynced(true);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity2();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity3();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(e1.getText());
                password = String.valueOf(e2.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this, "Enter Name", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Enter Email", Toast.LENGTH_LONG).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Login Successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity5.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity.this, "Login Failed.",
                                            Toast.LENGTH_SHORT).show();
                                    }
                            }
                        });
            }
        });
    }


    private void Activity3() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void Activity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }


}