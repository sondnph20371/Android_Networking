package com.example.myapplication.lab2.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class Lab24Activity extends AppCompatActivity {
    public static final String link = "http://192.168.1.8:3000/delta_POST";
    private EditText txtA, txtB, txtC;
    private Button btnSend;
    private TextView tvResult;
    String a, b, c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab24);

        txtA = findViewById(R.id.lab24_txtA);
        txtB = findViewById(R.id.lab24_txtB);
        txtC = findViewById(R.id.lab24_txtC);
        btnSend = findViewById(R.id.lab24_btnSend);
        tvResult = findViewById(R.id.lab24_tvResult);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = txtA.getText().toString();
                b = txtB.getText().toString();
                c = txtC.getText().toString();

                Bai4_POST bai4_post = new Bai4_POST(Lab24Activity.this, tvResult);
                bai4_post.execute(a, b, c);
            }
        });
    }
}