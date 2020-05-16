package com.example.filmarsivim;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

import java.util.Map;

public class FilmOner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextView onerilenFilm;
    String spinnerText;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_oner);
        onerilenFilm=findViewById(R.id.onerilenFilm);
        spinner=findViewById(R.id.spinner);
        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Tur,android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    public void onerilenFilmiEkle(View view){
        AlertDialog.Builder alert=new AlertDialog.Builder(FilmOner.this);
        alert.setTitle("Film Ekle");
        alert.setMessage("Filmi izlemek istediklerim listesine eklemek ister misin?");
        alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(FilmOner.this,FilmEkle2.class);
                startActivity(intent);
            }
        }).setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FilmOner.this,"Güzel bir filmi kaçırdın",Toast.LENGTH_LONG).show();
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
                    Toast.makeText(FilmOner.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(FilmOner.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(FilmOner.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(FilmOner.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(FilmOner.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(FilmOner.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(FilmOner.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(FilmOner.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(FilmOner.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(FilmOner.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
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
