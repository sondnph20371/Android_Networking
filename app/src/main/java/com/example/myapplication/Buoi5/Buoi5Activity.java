package com.example.myapplication.Buoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Buoi5.httpUrlConnection.List2Activity;
import com.example.myapplication.R;

public class Buoi5Activity extends AppCompatActivity {
    private Button btnRetrofit, btnHttp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buoi5);
        btnRetrofit = findViewById(R.id.buoi5_btnRetrofit);
        btnHttp = findViewById(R.id.buoi5_btnHttp);

        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Buoi5Activity.this, ListActivity.class));
            }
        });

        btnHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Buoi5Activity.this, List2Activity.class));
            }
        });

    }
}