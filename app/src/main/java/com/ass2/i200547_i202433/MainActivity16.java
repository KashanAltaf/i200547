package com.ass2.i200547_i202433;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        database.keepSynced(true);
    }
}