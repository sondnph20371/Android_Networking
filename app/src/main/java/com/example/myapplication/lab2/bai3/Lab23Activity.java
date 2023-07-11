package com.example.myapplication.lab2.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class Lab23Activity extends AppCompatActivity {
    public  static final String link = "http://192.168.1.8:3000/cube_POST";
    private EditText txtCanh;
    private Button btnSend;
    private TextView tvResult;
    private String side;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab23);

        txtCanh = findViewById(R.id.lab23_txtCanh);
        btnSend = findViewById(R.id.lab23_btnSend);
        tvResult = findViewById(R.id.lab23_tvResult);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                side = txtCanh.getText().toString();
                Bai3Background_POST background_post = new Bai3Background_POST(tvResult, side, Lab23Activity.this);
                background_post.execute();
                Log.d("Bai3", "Value of side: " + side);
            }
        });

    }
}