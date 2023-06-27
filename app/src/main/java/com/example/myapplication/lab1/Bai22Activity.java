package com.example.myapplication.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bai22Activity extends AppCompatActivity {
    private ImageView iv;
    private Button btnLoad;
    private TextView tvAlert;
    private Bitmap bitmap = null;
    private ProgressDialog prg;
    private String url ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxeVKKhcw5BVb33-sIFbVwBxpGvFjAORNkHA&usqp=CAU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai22);

        iv = findViewById(R.id.bai2_iv);
        btnLoad = findViewById(R.id.bai2_btnLoad);
        tvAlert = findViewById(R.id.bai2_tvAlert);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                prg = ProgressDialog.show(Bai22Activity.this, "Thông báo", "Loading");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        bitmap = dowloadBitmap(url);
                        Message msg = messHandler.obtainMessage();
                        Bundle bundle = new Bundle();
                        String mess = "Đã dowload xong";
                        bundle.putString("message", mess);
                        msg.setData(bundle);
                        messHandler.sendMessage(msg);

                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
            }
        });
    }

    private Handler messHandler = new Handler() {
        public void handlerMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message = bundle.getString("message");
            tvAlert.setText(message);
            iv.setImageBitmap(bitmap);
            prg.dismiss();
        }
    };

    private Bitmap dowloadBitmap (String link) {

        try {
            URL url = new URL(link); //lấy về đường dẫn ảnh
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return  bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}