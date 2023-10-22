package com.ass2.i200547_i202433;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity14 extends AppCompatActivity {

    com.firebase.client.Firebase firebase;
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


        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        database.keepSynced(true);

        com.firebase.client.Firebase.setAndroidContext(this);
        firebase = new com.firebase.client.Firebase("https://console.firebase.google.com/project/i200547i202433smd/database/i200547i202433smd-default-rtdb/data/~2F");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String feedback = e1.getText().toString();
                Firebase feedbackFire = firebase.child("Feedback");
                feedbackFire.setValue(feedback);

                if(feedback.isEmpty()){
                    e1.setError("Please Fill the Form");
                    b1.setEnabled(false);
                }
                else{
                    e1.setError(null);
                    b1.setEnabled(true);
                }
            }
        });
    }
}