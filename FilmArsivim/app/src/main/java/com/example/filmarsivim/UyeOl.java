package com.example.filmarsivim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UyeOl extends AppCompatActivity {
    EditText uyeEmail,uyeSifre,isim;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_ol);

        uyeEmail=findViewById(R.id.uyeEmail);
        uyeSifre=findViewById(R.id.uyeSifre);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            Intent intent=new Intent(UyeOl.this,AnaSayfa.class);
            startActivity(intent);
            finish();
        }
    }
    public void uyeOl(View view){
        String email=uyeEmail.getText().toString();
        String sifre=uyeSifre.getText().toString();


        firebaseAuth.createUserWithEmailAndPassword(email,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(UyeOl.this,"Kullanıcı Oluşturuldu",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(UyeOl.this,AnaSayfa.class);
                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UyeOl.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

            }
        });


    }
}
