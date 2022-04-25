package com.example.a490_senior_project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VaccineRVAdapter extends RecyclerView.Adapter<VaccineRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<VaccineModal> vaccineModalArrayList;
    private Context context;

    // constructor
    public VaccineRVAdapter(ArrayList<VaccineModal> vaccineModalArrayList, Context context) {
        this.vaccineModalArrayList = vaccineModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vaccine_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        VaccineModal modal = vaccineModalArrayList.get(position);
        holder.personNameTV.setText(modal.getPersonName());
        holder.vaccineNameTV.setText(modal.getVaccineName());
        //holder.vaccinePicIV.setImageURI(Uri.parse(modal.getVaccineCard()));//this is causing a problem to look at
        holder.vaccineCardTV.setText(modal.getVaccineCard());
        holder.vaccineShotsTV.setText(modal.getVaccineShots());
        holder.vaccineProviderTV.setText(modal.getVaccineProvider());
        holder.vaccineStatusTV.setText(modal.getVaccineStatus());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateVaccineActivity.class);

                // below we are passing all our values.
                i.putExtra("person name", modal.getPersonName());
                i.putExtra("vaccine name", modal.getVaccineName());
                if (null != modal.getVaccineCard()) {
                    i.putExtra("image uri", Uri.parse(modal.getVaccineCard()));
                }
                i.putExtra("vaccine card", modal.getVaccineCard());
                i.putExtra("provider", modal.getVaccineProvider());
                i.putExtra("shots", modal.getVaccineShots());
                i.putExtra("status", modal.getVaccineStatus());


                // starting our activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return vaccineModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView personNameTV, vaccineNameTV, vaccineShotsTV, vaccineProviderTV, vaccineStatusTV, vaccineCardTV;
        private ImageView vaccinePicIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            personNameTV = itemView.findViewById(R.id.idTVPersonName);
            vaccineStatusTV = itemView.findViewById(R.id.idTVVaccineStatus);
            vaccineNameTV = itemView.findViewById(R.id.idTVVaccineName);
            vaccineProviderTV = itemView.findViewById(R.id.idTVVaccineProvider);
            vaccineShotsTV = itemView.findViewById(R.id.idTVVaccineShots);
            vaccineCardTV = itemView.findViewById(R.id.idTVVaccineCard);
            vaccinePicIV = itemView.findViewById(R.id.ivBackdrop);
        }
    }
}
