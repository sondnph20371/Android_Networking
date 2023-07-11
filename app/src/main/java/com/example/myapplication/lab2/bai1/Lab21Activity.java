package com.example.myapplication.lab2.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class Lab21Activity extends AppCompatActivity {
    private TextView kq;
    private EditText txtName, txtScore;
    private Button btnSend;
    //private String link;

    public  static final String link = "http://10.24.50.162:8080/Android_Networking/std_GET.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab21);

        kq = findViewById(R.id.lab21_tvKq);
        txtName = findViewById(R.id.lab21_txtName);
        txtScore = findViewById(R.id.lab21_txtScore);
        btnSend = findViewById(R.id.lab21_btnSend);

      //  link = "http://10.24.50.162:8080/Android_Networking/std_GET.php";

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lab21_AsyncTask lab21_asyncTask = new Lab21_AsyncTask(kq,txtName.getText().toString(), txtScore.getText().toString(), Lab21Activity.this);
                lab21_asyncTask.execute();

            }
        });
    }
}