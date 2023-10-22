package com.kashanaltaf.i200547;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity13 extends AppCompatActivity {

    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    EditText e5;
    Button b1;
    String name, email, number, country, city;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        e1 = findViewById(R.id.r2);
        e2 = findViewById(R.id.r4);
        e3 = findViewById(R.id.r6);
        e4 = findViewById(R.id.r8);
        e5 = findViewById(R.id.r10);
        b1 = findViewById(R.id.but100);


        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        database.keepSynced(true);

        reference = FirebaseDatabase.getInstance().getReference("users");

        showData();

    }
    private void showData(){
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        number = intent.getStringExtra("number");
        country = intent.getStringExtra("country");
        city = intent.getStringExtra("city");

        e1.setText(name);
        e2.setText(email);
        e3.setText(number);
        e4.setText(country);
        e5.setText(city);
    }

    public void update(View view){
        if(isNameChanged() || isEmailChanged() || isNumChanged() || isCountryChanged() || isCityChanged()){
            Toast.makeText(this, "Data has been updated", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Data has not been updated", Toast.LENGTH_LONG).show();
        }
    }
    private boolean isNameChanged(){
        if(!name.equals(e1.getEditableText().toString())){
            reference.child("name").setValue(e1.getEditableText().toString());
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isEmailChanged(){
        if(!email.equals(e2.getEditableText().toString())){
            reference.child("email").setValue(e2.getEditableText().toString());
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isNumChanged(){
        if(!number.equals(e3.getEditableText().toString())){
            reference.child("number").setValue(e3.getEditableText().toString());
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isCountryChanged(){
        if(!country.equals(e1.getEditableText().toString())){
            reference.child("country").setValue(e4.getEditableText().toString());
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isCityChanged(){
        if(!city.equals(e5.getEditableText().toString())){
            reference.child("city").setValue(e5.getEditableText().toString());
            return true;
        }
        else{
            return false;
        }
    }

}