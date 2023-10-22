package com.kashanaltaf.i200547;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {

    Button b2;
    Button b3;
    FirebaseAuth mAuth;
    EditText e1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2 = (Button) findViewById(R.id.d);
        b3 = (Button) findViewById(R.id.e);
        e1 = (EditText) findViewById(R.id.c);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        database.keepSynced(true);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = e1.getText().toString().trim();
                if(!TextUtils.isEmpty(Email)){
                    //functionality
                    b2.setVisibility(View.INVISIBLE);

                    mAuth.sendPasswordResetEmail(Email).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(MainActivity2.this, "Reset Password Link has been sent to the Email!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity2.this, "Error in resetting password!", Toast.LENGTH_LONG).show();
                                    b2.setVisibility(View.VISIBLE);
                                }
                            });
                }
                else{
                    e1.setError("Please fill the email!");
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });
    }

    private void Activity1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}