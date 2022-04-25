package com.example.a490_senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class user extends AppCompatActivity {
    private EditText vaccineNameEdt, vaccineStatusEdt, vaccineShotEdt, vaccineProviderEdt, personNameEdt;
    private String Card_URI, vaccineCard;
    private ImageView ivBackdrop;
    private DBHandler dbHandler;
    int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        vaccineNameEdt = findViewById(R.id.idEdtVaccineName);
        vaccineShotEdt = findViewById(R.id.idEdtVaccineShot);
        vaccineProviderEdt = findViewById(R.id.idEdtVaccineProvider);
        vaccineStatusEdt = findViewById(R.id.idEdtVaccineStatus);
        personNameEdt = findViewById(R.id.idEdtPersonName);
        ivBackdrop = findViewById(R.id.ivBackdrop);
        Button addVaccineBtn = findViewById(R.id.idBtnAddVaccine);
        Button readVaccineBtn = findViewById(R.id.idBtnReadVaccine);
        Button uploadVaccineBtn = findViewById(R.id.idBtnUploadCard);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(user.this);

        // below line is to add on click listener for our add course button.

        addVaccineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String personName = personNameEdt.getText().toString();
                String vaccineName = vaccineNameEdt.getText().toString();
                String vaccineShot = vaccineShotEdt.getText().toString();
                String vaccineProvider = vaccineProviderEdt.getText().toString();
                String vaccineStatus = vaccineStatusEdt.getText().toString();
                String vaccineCard = Card_URI;


                // validating if the text fields are empty or not.
                if (vaccineName.isEmpty() && vaccineShot.isEmpty() && vaccineProvider.isEmpty() && personName.isEmpty())
                {
                    Toast.makeText(user.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewVaccine(personName,vaccineName, vaccineShot, vaccineProvider, vaccineStatus, vaccineCard);

                // after adding the data we are displaying a toast message.
                Toast.makeText(user.this, " vaccine data has been added.", Toast.LENGTH_SHORT).show();
                personNameEdt.setText("");
                vaccineNameEdt.setText("");
                vaccineShotEdt.setText("");
                vaccineProviderEdt.setText("");
                vaccineStatusEdt.setText("");


            }
        });

        readVaccineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(user.this, view_vaccine.class);
                startActivity(i);
            }
        });

        uploadVaccineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }

        });
    }



    String imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
        i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        i.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        i.getFlags();

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
        System.out.println(Card_URI);
        return Card_URI;
    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {

                // Get the url of the image from data
                Uri selectedImageUri = data.getData();


                if (null != selectedImageUri) {
                    // update the preview image in the layout

                    ivBackdrop.setImageURI(selectedImageUri);
                    Card_URI = selectedImageUri.toString();

                }
            }
        }
    }


}