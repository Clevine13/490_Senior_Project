package com.example.a490_senior_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler<vaccine_pic> extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "vaccinedb.1.4";

    // below int is our database version
    private static final int DB_VERSION = 2;

    // below variable is for our table name.
    private static final String TABLE_NAME = "TheVaccines";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our person name column
    private static final String NAME_COL = "name";

    // below variable is for our vaccine name column.
    private static final String VACCINE_NAME_COL = "vaccine_name";

    // below variable id for our vaccine date column.
    private static final String SHOTS_COL = "shots";

    // below variable for our vaccine provider column.
    private static final String PROVIDER_COL = "provider";

    // below variable is for our vaccine status column.
    private static final String STATUS_COL = "status";

    private static final String CARD_COL = "vaccine_card";

    private static final String CARD_PIC = "vaccine_pic";



    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + VACCINE_NAME_COL + " TEXT,"
                + SHOTS_COL + " TEXT,"
                + PROVIDER_COL + " TEXT,"
                + STATUS_COL + " TEXT,"
                + CARD_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewVaccine(String personName, String vaccineName, String vaccineShots, String vaccineProvider, String vaccineStatus,
                              String vaccineCard) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, personName);
        values.put(VACCINE_NAME_COL,vaccineName);
        values.put(SHOTS_COL, vaccineShots);
        values.put(PROVIDER_COL, vaccineProvider);
        values.put(STATUS_COL, vaccineStatus);
        values.put(CARD_COL, vaccineCard);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }


    // we have created a new method for reading all the courses.
    public ArrayList<VaccineModal> readVaccine() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorVaccine = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<VaccineModal> vaccineModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorVaccine.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                vaccineModalArrayList.add(new VaccineModal(cursorVaccine.getString(1),
                        cursorVaccine.getString(2),
                        cursorVaccine.getString(3),
                        cursorVaccine.getString(4),
                        cursorVaccine.getString(5),
                        cursorVaccine.getString(6)));
            } while (cursorVaccine.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorVaccine.close();
        return vaccineModalArrayList;
    }
    public void updateVaccine(String originalPersonName, String personName, String vaccineName, String vaccineCard, String vaccineShots,
                              String vaccineProvider, String vaccineStatus) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, personName);
        values.put(VACCINE_NAME_COL, vaccineName);
        values.put(CARD_COL, vaccineCard);
        values.put(SHOTS_COL, vaccineShots);
        values.put(PROVIDER_COL, vaccineProvider);
        values.put(STATUS_COL, vaccineStatus);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "name=?", new String[]{originalPersonName});
        db.close();
    }

    // below is the method for deleting our course.
    public void deleteVaccine(String personName) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME, "name=?", new String[]{personName});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



}

