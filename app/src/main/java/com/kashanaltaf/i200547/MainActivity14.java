package com.kashanaltaf.i200547;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public class MainActivity14 extends AppCompatActivity {

    FirebaseDatabase firebase;
    EditText e1;
    Button b1;
    ImageButton b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        e1 = (EditText) findViewById(R.id.e2);
        b1 = (Button) findViewById(R.id.e3);
        b2 = (ImageButton) findViewById(R.id.e0);
        

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String feedback = e1.getText().toString();
            }
        });

        }
}