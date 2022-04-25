package com.example.a490_senior_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class view_vaccine extends AppCompatActivity {

    private ArrayList<VaccineModal> vaccineModalArrayList;
    private DBHandler dbHandler;
    private VaccineRVAdapter vaccineRVAdapter;
    private RecyclerView vaccinesRV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vaccine);

        vaccineModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(view_vaccine.this);

        vaccineModalArrayList = dbHandler.readVaccine();

        vaccineRVAdapter = new VaccineRVAdapter(vaccineModalArrayList, view_vaccine.this);

        vaccinesRV = findViewById(R.id.idRVVaccines);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view_vaccine.this, RecyclerView.VERTICAL, false);
        vaccinesRV.setLayoutManager(linearLayoutManager);

        vaccinesRV.setAdapter(vaccineRVAdapter);

    }
}