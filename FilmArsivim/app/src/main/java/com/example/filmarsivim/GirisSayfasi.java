package com.example.filmarsivim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GirisSayfasi extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_sayfasi);
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            Intent intent=new Intent(GirisSayfasi.this,AnaSayfa.class);
            startActivity(intent);
            finish();
        }
    }
    public void hesapOlustur(View view){
        Intent intent=new Intent(GirisSayfasi.this,UyeOl.class);
        startActivity(intent);

    }
    public void hesapGiris(View view){
        Intent intent=new Intent(GirisSayfasi.this,GirisYap.class);
        startActivity(intent);

    }
}
