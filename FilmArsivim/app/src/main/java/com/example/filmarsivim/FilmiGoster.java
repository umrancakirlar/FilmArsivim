package com.example.filmarsivim;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

public class FilmiGoster extends AppCompatActivity {
    ImageView filmAfis;
    TextView filmAdi,filmTarih,filmHakkinda,filmTur;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private ArrayList<String> filmListesi;
    private ArrayList<String> tarihListesi;
    private ArrayList<String> hakkindaListesi;
    private ArrayList<String> afisListesi;
    private ArrayList<String> turListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmi_goster);

        filmAfis=findViewById(R.id.filmAfis);
        filmAdi=findViewById(R.id.filmAdi);
        filmTarih=findViewById(R.id.filmTarih);
        filmHakkinda=findViewById(R.id.filmHakkinda);
        filmTur=findViewById(R.id.filmTur);

        filmListesi=new ArrayList<>();
        afisListesi=new ArrayList<>();
        tarihListesi=new ArrayList<>();
        hakkindaListesi=new ArrayList<>();
        turListesi=new ArrayList<>();

        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();

        CollectionReference collectionReference = firebaseFirestore.collection("Filmler");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(FilmiGoster.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {
                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();


                        String hakkinda = (String) data.get("filmdusunce");
                        String ad = (String) data.get("filmadi");
                        String downloadUrl = (String) data.get("downloadurl");
                        String zaman = (String) data.get("filmtarih");
                        String tur=(String) data.get("filmtur");


                        filmListesi.add(ad);
                        afisListesi.add(downloadUrl);
                        tarihListesi.add(zaman);
                        hakkindaListesi.add(hakkinda);
                        turListesi.add(tur);


                        filmAdi.setText(ad);
                        Picasso.get().load(downloadUrl).into(filmAfis);
                        filmHakkinda.setText(hakkinda);
                        filmTarih.setText(zaman);
                        filmTur.setText(tur);
                    }
                }
            }
        });
    }

}
