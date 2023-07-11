package com.example.myapplication.lab2.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class Bai2Activity extends AppCompatActivity {
    public static final String SERVER_NAME = "http://192.168.1.8:3000/rectangle_POST";
    private EditText edWidth;
    private EditText edLength;
    private Button btnSend;
    private TextView tvResult;
    String strWidth, strlength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        edWidth = findViewById(R.id.lab22_width);
        edLength = findViewById(R.id.lab22_length);
        btnSend = findViewById(R.id.lab22_btnSend);
        tvResult = findViewById(R.id.lab22_tvResult);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strWidth = edWidth.getText().toString();
                strlength = edLength.getText().toString();

                Background_POST background_post = new Background_POST(tvResult, strWidth, strlength, Bai2Activity.this);
                background_post.execute();
                Log.d("Bai2", "Value of Width: " + strWidth);
                Log.d("Bai2", "Value of Length: " + strlength);
            }
        });

    }
}