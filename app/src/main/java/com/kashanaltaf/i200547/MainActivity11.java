package com.kashanaltaf.i200547;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity11 extends AppCompatActivity {

    Button b1, b2;
    ImageButton i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        b1 = (Button) findViewById(R.id.report);
        b2 = (Button) findViewById(R.id.rent);
        i1 = (ImageButton) findViewById(R.id.chat);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity2();
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity3();
            }
        });

    }
    private void Activity1(){
        Intent intent = new Intent(this, MainActivity14.class);
        startActivity(intent);
    }

    private void Activity2(){
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
    private void Activity3(){
        Intent intent = new Intent(this, MainActivity9.class);
        startActivity(intent);
    }

}