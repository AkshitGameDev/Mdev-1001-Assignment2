package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    MyDatabaseHelper myDB;

    ArrayList<String> movie_id, movie_title, movie_studio, movie_genre;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        movie_id = new ArrayList<>();
        movie_title = new ArrayList<>();
        movie_studio = new ArrayList<>();
        movie_genre = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this, movie_id,movie_title,movie_studio,movie_genre);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void storeDataInArrays (){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                movie_id.add(cursor.getString(0));
                movie_title.add(cursor.getString(1));
                movie_studio.add(cursor.getString(2));
                movie_genre.add(cursor.getString(3));
            }
        }
    }
        /* void storeDataInArrays (){
            Cursor cursor = myDB.readAllData();
            if(cursor.getCount() == 0){
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
            }else {
                movie_id.add(cursor.getString(0));
                movie_title.add(cursor.getString(1));
                movie_studio.add(cursor.getString(2));
                movie_genre.add(cursor.getString(3));
            }
        }*/

}