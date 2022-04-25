package com.example.a490_senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class activity_login extends AppCompatActivity {
    EditText txtUsername, txtPass;
    Button btnLogin;
    Spinner _spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsername = findViewById(R.id.txtUsername);
        txtPass = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogin);
        _spinner = findViewById(R.id._spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        _spinner.setAdapter(adapter);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = _spinner.getSelectedItem().toString();
                if (txtUsername.getText().toString().equals("admin") && txtPass.getText().toString().equals("admin") && item.equals("admin")) {
                    Intent intent = new Intent(activity_login.this, admin.class);
                    startActivity(intent);
                } else if (txtUsername.getText().toString().equals("user") && txtPass.getText().toString().equals("user") && item.equals("user")) {
                    Intent intent = new Intent(activity_login.this, user.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}