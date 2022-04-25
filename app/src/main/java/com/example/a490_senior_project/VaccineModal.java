package com.example.a490_senior_project;

public class VaccineModal {

    // variables for our vaccinename,
    // description, tracks and duration, id.
    private String vaccineName;
    private String personName;
    private String vaccineProvider;
    private String vaccineShots;
    private String vaccineStatus;
    private String vaccineCard;
    private int id;

    // creating getter and setter methods


    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getVaccineProvider() {
        return vaccineProvider;
    }

    public void setVaccineProvider(String vaccineProvider) {
        this.vaccineProvider = vaccineProvider;
    }

    public String getVaccineShots() {
        return vaccineShots;
    }

    public void setVaccineShots(String vaccineShots) {
        this.vaccineShots = vaccineShots;
    }

    public String getVaccineStatus() {
        return vaccineStatus;
    }

    public void setVaccineStatus(String vaccineStatus) {
        this.vaccineStatus = vaccineStatus;
    }

    public String getVaccineCard() {
        return vaccineCard;
    }

    public void setVaccineCard(String vaccineCard) {
        this.vaccineCard = vaccineCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public VaccineModal(String personName,String vaccineName, String vaccineShots, String vaccineProvider, String vaccineStatus,
                        String vaccineCard) { this.personName = personName;
       this.vaccineName = vaccineName;
       this.vaccineShots = vaccineShots;
       this.vaccineProvider = vaccineProvider;
       this.vaccineStatus = vaccineStatus;
       this.vaccineCard = vaccineCard;
    }
}

