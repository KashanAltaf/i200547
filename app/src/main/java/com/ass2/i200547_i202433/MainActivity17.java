package com.ass2.i200547_i202433;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity17 extends AppCompatActivity {

    ImageButton i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        i1 = (ImageButton) findViewById(R.id.endVid);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        database.keepSynced(true);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });
    }
    private void Activity1() {
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
    }
}