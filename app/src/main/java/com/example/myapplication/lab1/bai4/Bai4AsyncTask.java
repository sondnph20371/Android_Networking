package com.example.myapplication.lab1.bai4;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4AsyncTask extends AsyncTask<String, Void, String> {
    private ProgressDialog dialog;
    private TextView tvResult;
    private EditText txtTime;
    private Context context;
    private String kq;
    public Bai4AsyncTask(Context context,TextView tvResult, EditText txtTime) {
        this.context = context;
        this.tvResult = tvResult;
        this.txtTime = txtTime;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context,"Thông báo",
                "đợi " +txtTime.getText().toString()+ " giây...");
    }

    @Override
    protected String doInBackground(String...strings) {
        //publishProgress("Sleeping");
        try {
          int time = Integer.parseInt(strings[0])*1000;
          Thread.sleep(time);
          kq = "đã ngủ trong " + strings[0] + " giây";
        }catch (Exception e) {
            e.printStackTrace();
            kq = e.getMessage();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(dialog.isShowing()) {
            dialog.dismiss();
        }
        tvResult.setText(s);
    }
}
