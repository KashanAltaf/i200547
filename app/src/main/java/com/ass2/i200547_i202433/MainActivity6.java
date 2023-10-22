package com.ass2.i200547_i202433;

import static com.ass2.i200547_i202433.R.*;
import static com.ass2.i200547_i202433.R.id.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity6 extends AppCompatActivity {

    ImageView l1;
    ImageView l2;
    ImageView l3;
    ImageView l4;
    ImageView l5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main6);
        l1 = (ImageView) findViewById(ll1);
        l2 = (ImageView) findViewById(ll2);
        l3 = (ImageView) findViewById(ll3);
        l4 = (ImageView) findViewById(ll4);
        l5 = (ImageView) findViewById(ll5);


        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        database.keepSynced(true);

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
    }

    private void Activity5() {
        Intent intent = new Intent(this, MainActivity10.class);
        startActivity(intent);
    }

    private void Activity4() {
        Intent intent = new Intent(this, MainActivity8.class);
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