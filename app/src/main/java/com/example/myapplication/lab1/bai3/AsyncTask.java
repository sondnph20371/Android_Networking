package com.example.myapplication.lab1.bai3;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.net.URL;

public class AsyncTask extends android.os.AsyncTask<String, Void, Bitmap> {

    Listener mListenr;//khai báo sử dụng giao diện
    ProgressDialog progressDialog;//sử dụng tiến trình
    public AsyncTask(Listener listener, Context context) {
        this.mListenr = listener; //khởi tạo listener
        this.progressDialog = new ProgressDialog(context);//khởi tạo tiến trình
    }
    //chuẩn bị thực hiện
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Bắt đầu dowload");
        progressDialog.show();
    }
    //thực hiện
    Bitmap bitmap = null;
    @Override
    protected Bitmap doInBackground(String... strings) {
        URL url;

        try {
            url = new URL(strings[0]); //lấy về đường dẫn ảnh
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        if(bitmap!=null) {
            mListenr.onImageDowload(bitmap);
        } else {
            mListenr.onError();
        }
    }
}
