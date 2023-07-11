package com.example.myapplication.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.lab1.Bai1Activity;
import com.example.myapplication.lab1.Bai21Activity;
import com.example.myapplication.lab1.bai3.Bai3Activity;
import com.example.myapplication.lab1.bai4.Bai4Activity;
import com.example.myapplication.lab2.bai1.Lab21Activity;
import com.example.myapplication.lab2.bai2.Bai2Activity;
import com.example.myapplication.lab2.bai3.Lab23Activity;
import com.example.myapplication.lab2.bai4.Lab24Activity;

public class Lab1_Screen extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_screen);

        btn1 = findViewById(R.id.btnLab11);
        btn2 = findViewById(R.id.btnLab12);
        btn3 = findViewById(R.id.btnLab13);
        btn4 = findViewById(R.id.btnLab14);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab1_Screen.this, Bai1Activity.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab1_Screen.this, Bai21Activity.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab1_Screen.this, Bai3Activity.class));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab1_Screen.this, Bai4Activity.class));
            }
        });

    }
}