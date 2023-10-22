package com.kashanaltaf.i200547;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.UUID;

public class MainActivity12 extends AppCompatActivity {

    ImageButton i1, i2;
    EditText e1, e2, e3, e4;
    Button b1;
    Uri imageUri, vidUri;
    private String myUri = "";

    private StorageTask uploadTask;
    private StorageReference storageReference;
    private FirebaseStorage storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        i1 = (ImageButton) findViewById(R.id.c1);
        i2 = (ImageButton) findViewById(R.id.c2);
        e1 = (EditText) findViewById(R.id.r2);
        e2 = (EditText) findViewById(R.id.r4);
        e3 = (EditText) findViewById(R.id.r6);
        e4 = (EditText) findViewById(R.id.r8);
        b1 = (Button) findViewById(R.id.b1);


        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        database.keepSynced(true);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && requestCode==RESULT_OK && data!=null && data.getData()!=null){
            imageUri = data.getData();
            vidUri = data.getData();
            i1.setImageURI(imageUri);
            i2.setImageURI(vidUri);

            final ProgressDialog pd = new ProgressDialog(this);
            pd.setTitle("Uploading Image...");
            pd.show();

            final String randomKey = UUID.randomUUID().toString();
            Uri file = Uri.fromFile(new File("C:/Users/DELL/Downloads/download.jpg"));
            StorageReference rDef = storageReference.child("Cover Pic");
            rDef.putFile(file).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            pd.dismiss();
                            Snackbar.make(findViewById(R.id.c1), "Image Uploaded", Snackbar.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            pd.dismiss();
                            Toast.makeText(getApplicationContext(), "Failed to Upload", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                            double progressPercent = (100.00 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            pd.setMessage("Progress: " + (int) progressPercent + "%");
                        }
                    });
        }
    }
}