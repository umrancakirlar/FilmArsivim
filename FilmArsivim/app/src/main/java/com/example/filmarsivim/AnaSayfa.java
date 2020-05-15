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

public class AnaSayfa extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private FirebaseAuth firebaseAuth;
    TextView onerilenFilm;
    Spinner spinner;
    FirebaseFirestore firebaseFirestore;
    String spinnerText;




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

        }else if(item.getItemId()==R.id.cikis_yap){
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
        onerilenFilm=findViewById(R.id.onerilenFilm);
        spinner=findViewById(R.id.spinner);
        firebaseFirestore=FirebaseFirestore.getInstance();

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Tur,android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    public void filmleriListele(View view){
        Intent intent=new Intent(AnaSayfa.this,Izlediklerim.class);
        startActivity(intent);
    }
    public void istediklerimiListele(View view){
        Intent intent=new Intent(AnaSayfa.this,IzlemekIstediklerim.class);
        startActivity(intent);
    }

    public void onerilenFilmiEkle(View view){
        AlertDialog.Builder alert=new AlertDialog.Builder(AnaSayfa.this);
        alert.setTitle("Film Ekle");
        alert.setMessage("Filmi izlemek istediklerim listesine eklemek ister misin?");
        alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(AnaSayfa.this,FilmEkle2.class);
                startActivity(intent);
            }
        }).setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AnaSayfa.this,"Güzel bir filmi kaçırdın",Toast.LENGTH_LONG).show();
            }
        });
        alert.show();

    }
    public void filmOner(View view){
        if(spinnerText.equals("Romantik")){
            romantik();
        } else if(spinnerText.equals("Aksiyon")){
            aksiyon();
        } else if(spinnerText.equals("Macera")){
            macera();
        }else if(spinnerText.equals("Gerilim")){
            gerilim();
        }else if(spinnerText.equals("Korku")){
            korku();
        }else if(spinnerText.equals("Dram")){
            dram();
        }else if(spinnerText.equals("Suç")){
            suc();
        }else if(spinnerText.equals("Bilim-Kurgu")){
            bilimKurgu();
        }else if(spinnerText.equals("Komedi")){
            komedi();
        }else if(spinnerText.equals("Fantastik")){
            fantastik();
        }
    }

    public void romantik(){
        CollectionReference collectionReference = firebaseFirestore.collection("Romantik");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(AnaSayfa.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();
                        String film = (String) data.get("film");

                        onerilenFilm.setText(film);

                    }
                }

            }
        });
    }
    public void macera(){
        CollectionReference collectionReference = firebaseFirestore.collection("Macera");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(AnaSayfa.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();
                        String film = (String) data.get("film");

                        onerilenFilm.setText(film);

                    }
                }

            }
        });
    }
    public void korku(){
        CollectionReference collectionReference = firebaseFirestore.collection("Korku");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(AnaSayfa.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();
                        String film = (String) data.get("film");

                        onerilenFilm.setText(film);

                    }
                }

            }
        });
    }
    public void komedi(){
        CollectionReference collectionReference = firebaseFirestore.collection("Komedi");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(AnaSayfa.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();
                        String film = (String) data.get("film");

                        onerilenFilm.setText(film);

                    }
                }

            }
        });
    }
    public void dram(){
        CollectionReference collectionReference = firebaseFirestore.collection("Dram");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(AnaSayfa.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();
                        String film = (String) data.get("film");

                        onerilenFilm.setText(film);

                    }
                }

            }
        });
    }
    public void gerilim(){
        CollectionReference collectionReference = firebaseFirestore.collection("Gerilim");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(AnaSayfa.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();
                        String film = (String) data.get("film");

                        onerilenFilm.setText(film);

                    }
                }

            }
        });
    }
    public void suc(){
        CollectionReference collectionReference = firebaseFirestore.collection("Suç");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(AnaSayfa.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();
                        String film = (String) data.get("film");

                        onerilenFilm.setText(film);

                    }
                }

            }
        });
    }
    public void bilimKurgu(){
        CollectionReference collectionReference = firebaseFirestore.collection("Bilim-Kurgu");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(AnaSayfa.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();
                        String film = (String) data.get("film");

                        onerilenFilm.setText(film);

                    }
                }

            }
        });
    }
    public void fantastik(){
        CollectionReference collectionReference = firebaseFirestore.collection("Fantastik");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(AnaSayfa.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();
                        String film = (String) data.get("film");

                        onerilenFilm.setText(film);

                    }
                }

            }
        });
    }

    public void aksiyon(){
        CollectionReference collectionReference = firebaseFirestore.collection("Aksiyon");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(AnaSayfa.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();
                        String film = (String) data.get("film");

                        onerilenFilm.setText(film);

                    }
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerText=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}