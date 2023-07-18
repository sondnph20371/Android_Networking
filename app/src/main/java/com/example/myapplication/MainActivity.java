package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Buoi5.Buoi5Activity;
import com.example.myapplication.Buoi5.ListActivity;
import com.example.myapplication.activitys.Lab1_Screen;
import com.example.myapplication.activitys.Lab2_Screen;

public class MainActivity extends AppCompatActivity {
    private Button lab1, lab2, buoi5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lab1 = findViewById(R.id.btnLab1);
        lab2 = findViewById(R.id.btnLab2);
        buoi5 = findViewById(R.id.btnBuoi5);

        lab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Lab1_Screen.class));
            }
        });

        lab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab2_Screen.class);
                startActivity(intent);
            }
        });

        buoi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Buoi5Activity.class);
                startActivity(intent);
            }
        });


    }
}