package com.example.a490_senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class activity_uplode_reg_photo extends AppCompatActivity {

    // One Button
    Button btnUpload;
    Button btnSubmit;

    // One Preview Image
    ImageView ivBackdrop;

    // constant to compare
    // the activity result code
    int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uplode_reg_photo);

        // register the UI widgets with their appropriate IDs
        btnUpload = findViewById(R.id.btnUpload);
        ivBackdrop = findViewById(R.id.ivBackdrop);
        btnSubmit = findViewById(R.id.btnSubmit);

        // handle the Choose Image button to trigger
        // the image chooser function
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(activity_uplode_reg_photo.this, user.class);
                startActivity(i);
            }
        });

    }


    // this function is triggered when
    // the Select Image Button is clicked
    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
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
                }
                Intent intent = new Intent();
                intent.putExtra(Intent.EXTRA_TEXT, selectedImageUri);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}
