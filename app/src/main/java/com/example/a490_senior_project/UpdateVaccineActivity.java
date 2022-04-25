package com.example.a490_senior_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class UpdateVaccineActivity extends AppCompatActivity {


        // variables for our edit text, button, strings and dbhandler class.
        private EditText vaccineNameEdt, personNameEdt, vaccineShotsEdt, vaccineProviderEdt, vaccineStatusEdt;
        private TextView vaccineCardTV;
        private Button updateVaccineBtn,deleteVaccineBtn;
        private DBHandler dbHandler;
        String vaccineName, personName, vaccineShots, vaccineProvider, vaccineStatus, vaccineCard;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_update);

            // initializing all our variables.
            personNameEdt = findViewById(R.id.idEdtPersonName);
            vaccineNameEdt = findViewById(R.id.idEdtVaccineName);
            vaccineShotsEdt = findViewById(R.id.idEdtVaccineShot);
            vaccineProviderEdt = findViewById(R.id.idEdtVaccineProvider);
            vaccineStatusEdt = findViewById(R.id.idEdtVaccineStatus);
            vaccineCardTV = findViewById(R.id.idTVVaccineCard);
            updateVaccineBtn = findViewById(R.id.idBtnUpdateVaccine);
            deleteVaccineBtn = findViewById(R.id.idBtnDelete);

            // on below line we are initialing our dbhandler class.
            dbHandler = new DBHandler(UpdateVaccineActivity.this);

            // on below lines we are getting data which
            // we passed in our adapter class.
            personName = getIntent().getStringExtra("person name");
            vaccineName = getIntent().getStringExtra("vaccine name");
            vaccineCard = getIntent().getStringExtra("vaccine card");
            vaccineShots = getIntent().getStringExtra("shots");
            vaccineProvider = getIntent().getStringExtra("provider");
            vaccineStatus = getIntent().getStringExtra("status");

            // setting data to edit text
            // of our update activity.
            personNameEdt.setText(personName);
            vaccineNameEdt.setText(vaccineName);
            vaccineCardTV.setText(vaccineCard);
            vaccineShotsEdt.setText(vaccineShots);
            vaccineProviderEdt.setText(vaccineProvider);
            vaccineStatusEdt.setText(vaccineStatus);
            // adding on click listener to our update course button.
            updateVaccineBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // inside this method we are calling an update course
                    // method and passing all our edit text values.
                    dbHandler.updateVaccine(personName, personNameEdt.getText().toString(), vaccineNameEdt.getText().toString(), vaccineCardTV.getText().toString(),
                            vaccineShotsEdt.getText().toString(), vaccineProviderEdt.getText().toString(), vaccineStatusEdt.getText().toString());

                    // displaying a toast message that our course has been updated.
                    Toast.makeText(UpdateVaccineActivity.this, "Vaccine Updated..", Toast.LENGTH_SHORT).show();

                    // launching our main activity.
                    Intent i = new Intent(UpdateVaccineActivity.this, user.class);
                    startActivity(i);
                }
            });

            deleteVaccineBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // calling a method to delete our course.
                    dbHandler.deleteVaccine(personName);
                    Toast.makeText(UpdateVaccineActivity.this, "Deleted the vaccine info", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(UpdateVaccineActivity.this, user.class);
                    startActivity(i);
                }
            });
        }
    }
