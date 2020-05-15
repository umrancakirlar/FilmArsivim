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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GirisYap extends AppCompatActivity {
    EditText hesapEmail,hesapSifre;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_yap);

        hesapEmail=findViewById(R.id.hesapEmail);
        hesapSifre=findViewById(R.id.hesapSifre);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            Intent intent=new Intent(GirisYap.this,AnaSayfa.class);
            startActivity(intent);
            finish();
        }
    }
    public void girisYap(View view){
        String email=hesapEmail.getText().toString();
        String sifre=hesapSifre.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent=new Intent(GirisYap.this,AnaSayfa.class);
                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(GirisYap.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
