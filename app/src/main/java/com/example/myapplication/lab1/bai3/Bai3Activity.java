package com.example.myapplication.lab1.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class Bai3Activity extends AppCompatActivity implements Listener {
    ImageView iv;
    Button btnLoad;
    TextView tvAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        iv = findViewById(R.id.bai1_iv);
        btnLoad = findViewById(R.id.bai1_btnLoad);
        tvAlert = findViewById(R.id.bai1_tvAlert);

    btnLoad.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new AsyncTask(Bai3Activity.this, Bai3Activity.this).execute("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxeVKKhcw5BVb33-sIFbVwBxpGvFjAORNkHA&usqp=CAU");
        }
    });

    }

    @Override
    public void onImageDowload(Bitmap bitmap) {
    iv.setImageBitmap(bitmap); //đưa ảnh lên imageview
        tvAlert.setText("Dowload thành công");
    }

    @Override
    public void onError() {
        tvAlert.setText("Dowload thất bại");
    }


}