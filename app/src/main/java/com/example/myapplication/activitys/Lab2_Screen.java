package com.example.myapplication.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.lab2.bai1.Lab21Activity;
import com.example.myapplication.lab2.bai2.Bai2Activity;
import com.example.myapplication.lab2.bai3.Lab23Activity;
import com.example.myapplication.lab2.bai4.Lab24Activity;

public class Lab2_Screen extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        btn1 =findViewById(R.id.btnLab21);
        btn2 = findViewById(R.id.btnLab22);
        btn3 = findViewById(R.id.btnLab23);
        btn4 = findViewById(R.id.btnLab24);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab2_Screen.this, Lab21Activity.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab2_Screen.this, Bai2Activity.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab2_Screen.this, Lab23Activity.class));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab2_Screen.this, Lab24Activity.class));
            }
        });
    }
}