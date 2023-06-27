package com.example.myapplication.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Bai1Activity extends AppCompatActivity {
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
                final Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //dowload ảnh
                       final Bitmap bitmap = getPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxeVKKhcw5BVb33-sIFbVwBxpGvFjAORNkHA&usqp=CAU");
                       iv.post(new Runnable() {
                           @Override
                           public void run() {
                               iv.setImageBitmap(bitmap);
                               tvAlert.setText("Dowload thành công");
                           }
                       }) ;

                    }
                });
                thread.start();
            }
        });


    }

    private Bitmap getPicture (String link) {
        URL url;
        Bitmap bitmap = null;
        try {
            url = new URL(link); //lấy về đường dẫn ảnh
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}