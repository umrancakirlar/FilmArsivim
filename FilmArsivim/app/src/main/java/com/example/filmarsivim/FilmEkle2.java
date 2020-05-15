package com.example.filmarsivim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class FilmEkle2 extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    EditText filmAdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_ekle2);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        filmAdi=findViewById(R.id.filmAdi);
    }
    public void filmEkle(View view){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        String film=filmAdi.getText().toString();

        HashMap<String, Object> post = new HashMap<>();
        post.put("filmismi",film);
        post.put("dateTime", FieldValue.serverTimestamp());
        firebaseFirestore.collection("İstediğimFilmler").add(post).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(FilmEkle2.this,"Film eklendi",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FilmEkle2.this,AnaSayfa.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FilmEkle2.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
