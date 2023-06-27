package com.example.myapplication.lab1.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class Bai4Activity extends AppCompatActivity {
    private EditText txtTime;
    private Button btnAsync;
    private TextView tvStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        txtTime = findViewById(R.id.bai4_txtTime);
        tvStatus = findViewById(R.id.bai4_tvStatus);
        btnAsync = findViewById(R.id.bai4_btnAsync);

        btnAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sleeptime = txtTime.getText().toString();
                new Bai4AsyncTask(Bai4Activity.this, tvStatus, txtTime ).execute(sleeptime);
            }
        });
    }
}