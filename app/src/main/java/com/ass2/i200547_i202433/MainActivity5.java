package com.ass2.i200547_i202433;

import static com.ass2.i200547_i202433.R.*;
import static com.ass2.i200547_i202433.R.id.*;
import static com.ass2.i200547_i202433.R.layout.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity5 extends AppCompatActivity {

    ImageView l1;
    ImageView l2;
    ImageView l3;
    ImageView l4;
    ImageView l5;
    Button b1;
    FirebaseAuth auth;
    FirebaseUser user;
    View v1, v2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main5);
        l1 = (ImageView) findViewById(id.l1);
        l2 = (ImageView) findViewById(id.l2);
        l3 = (ImageView) findViewById(id.l3);
        l4 = (ImageView) findViewById(id.l4);
        l5 = (ImageView) findViewById(id.l5);
        b1 = (Button) findViewById(but11);
        v1 = (View) findViewById(t1);
        v2 = (View) findViewById(t2);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        database.keepSynced(true);

        if(user == null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity2();
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity3();
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity4();
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity5();
            }
        });

        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity6();
            }
        });


        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity7();
            }
        });
    }
    private void Activity7(){
        Intent intent = new Intent(this, MainActivity11.class);
        startActivity(intent);
    }
    private void Activity6(){
        Intent intent = new Intent(this, MainActivity11.class);
        startActivity(intent);
    }

    private void Activity5() {
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);
    }

    private void Activity4() {
        Intent intent = new Intent(this, MainActivity10.class);
        startActivity(intent);
    }

    private void Activity3() {
        Intent intent = new Intent(this, MainActivity12.class);
        startActivity(intent);
    }

    private void Activity2() {
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }

    private void Activity1() {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
}