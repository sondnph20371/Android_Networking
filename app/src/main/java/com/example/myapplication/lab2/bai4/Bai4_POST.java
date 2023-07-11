package com.example.myapplication.lab2.bai4;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.example.myapplication.lab2.bai3.Lab23Activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Bai4_POST extends AsyncTask<String, Void, Void> {
    String link = Lab24Activity.link;
    TextView tvResult;
    String result;
    ProgressDialog progressDialog;
    Context context;

    public Bai4_POST(Context context, TextView tvResult) {
        this.context = context;
        this.tvResult = tvResult;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Sending...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            URL url = new URL(link);
            String param= "a=" + URLEncoder.encode(strings[0].toString(), "utf-8") + "&b=" + URLEncoder.encode(strings[1].toString(), "utf-8")
                    + "&c=" + URLEncoder.encode(strings[2].toString(), "utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line = "";
            BufferedReader btf = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = btf.readLine()) != null){
                sb.append(line);
            }
            result= sb.toString();
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        tvResult.setText(result);
    }
}
