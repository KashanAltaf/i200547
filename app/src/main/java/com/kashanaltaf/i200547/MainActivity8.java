package com.kashanaltaf.i200547;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity8 extends AppCompatActivity {

    ImageView l1;
    ImageView l2;
    ImageView l3;
    ImageView l4;
    ImageView l5;
    ImageButton l6;
    ImageButton l7;
    ImageButton l8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        l1 = (ImageView) findViewById(R.id.lll5);
        l2 = (ImageView) findViewById(R.id.lll6);
        l3 = (ImageView) findViewById(R.id.lll7);
        l4 = (ImageView) findViewById(R.id.lll8);
        l5 = (ImageView) findViewById(R.id.lll9);
        l6 = (ImageButton) findViewById(R.id.lll1);
        l7 = (ImageButton) findViewById(R.id.lll2);
        l8 = (ImageButton) findViewById(R.id.lll3);

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
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity6();
            }
        });
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Activity7();}
        });
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Activity8();}
        });
    }

    private void Activity8() {
        Intent intent = new Intent(this, MainActivity9.class);
        startActivity(intent);
    }

    private void Activity7() {
        Intent intent = new Intent(this, MainActivity9.class);
        startActivity(intent);
    }

    private void Activity6() {
        Intent intent = new Intent(this, MainActivity9.class);
        startActivity(intent);
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
        Intent intent = new Intent(this, MainActivity7.class);
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