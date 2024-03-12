package com.example.assignment2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    //singelton
    public static MyDatabaseHelper instance = null;
    private Context context;
    private static final String DATABASE_NAME = "MovieLibrary.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABEL_NAME = "MOVIES";
    private static final String COLUMN_ID = "_id";

    private static final String TITLE = "";
    private static final String STUDIO = "";
    private static final String GENRE = "";



    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABEL_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TITLE + " TEXT, " +
                STUDIO + " TEXT, " +
                GENRE + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABEL_NAME + ";");
        onCreate(db);
    }
    public void addMovie(String title, String studio, String genre){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TITLE, title);
        cv.put(STUDIO, studio);
        cv.put(GENRE, genre);
        long result = db.insert(TABEL_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }


}
