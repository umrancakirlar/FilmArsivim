package com.example.filmarsivim;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class AnaSayfa extends AppCompatActivity  {
    private FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//MENU BAĞLAMAK İÇİN
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.secenekler,menu);// virgülden sonraki menu yukarıda createOptions icindeki parantezdeki menu(bizim neuyu burayla bağlamak için
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//MENUDE BİR ŞEY SEÇİLİRSE YAPILACAK İŞLEM
        if(item.getItemId()==R.id.film_izledim){
            Intent intentToFilmEkle=new Intent(AnaSayfa.this,FilmEkle.class);
            startActivity(intentToFilmEkle);
        }else if(item.getItemId()==R.id.izlemek_istiyorum){
            Intent intentToFilmEkle2=new Intent(AnaSayfa.this,FilmEkle2.class);
            startActivity(intentToFilmEkle2);

        }else if(item.getItemId()==R.id.film_oner){
            Intent intentToFilmOner=new Intent(AnaSayfa.this,FilmOner.class);
            startActivity(intentToFilmOner);

        }
        else if(item.getItemId()==R.id.cikis_yap){
            firebaseAuth.signOut();
            Intent intentToGirisSayfasi=new Intent(AnaSayfa.this,GirisSayfasi.class);
            startActivity(intentToGirisSayfasi);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

    }
    public void filmleriListele(View view){
        Intent intent=new Intent(AnaSayfa.this,Izlediklerim.class);
        startActivity(intent);
    }
    public void istediklerimiListele(View view){
        Intent intent=new Intent(AnaSayfa.this,IzlemekIstediklerim.class);
        startActivity(intent);
    }

}