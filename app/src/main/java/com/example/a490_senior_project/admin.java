package com.example.a490_senior_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class admin extends AppCompatActivity {
    private ArrayList<VaccineModal> vaccineModalArrayList;
    private DBHandler dbHandler;
    private VaccineRVAdapter vaccineRVAdapter;
    private RecyclerView vaccinesRV;
    private String Card_URI;
    private ImageView ivBackdrop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vaccine);

        vaccineModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(admin.this);

        vaccineModalArrayList = dbHandler.readVaccine();

        vaccineRVAdapter = new VaccineRVAdapter(vaccineModalArrayList, admin.this);

        vaccinesRV = findViewById(R.id.idRVVaccines);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(admin.this, RecyclerView.VERTICAL, false);
        vaccinesRV.setLayoutManager(linearLayoutManager);

        vaccinesRV.setAdapter(vaccineRVAdapter);



    }
}