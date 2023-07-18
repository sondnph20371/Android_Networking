package com.example.myapplication.Buoi5.httpUrlConnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.Buoi5.Album;
import com.example.myapplication.Buoi5.Album_Adapter;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class List2Activity extends AppCompatActivity {
  private final static String URL = "https://jsonplaceholder.typicode.com/photos";
    ArrayList<Album> albumArrayList = new ArrayList<>();
    RecyclerView recyclerView;
    Album_Adapter album_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        recyclerView = findViewById(R.id.rcv2Album);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private class JsonTask extends AsyncTask<String, String, String> {
        Album album;

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;
            String line = "";
            try {
               URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();


                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    Log.d("Response: ", "> " + line);

                }
                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (result != null) {


                //JSONObject jsonObject= null;
                try {
                    JSONArray jsonArray = new JSONArray(result);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonResponse = jsonArray.getJSONObject(i);
                        String id = jsonResponse.getString("id");
                        String title = jsonResponse.getString("title");
                        String url = jsonResponse.getString("url");

                        album = new Album(id, title, url);
                        albumArrayList.add(album);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                album_adapter = new Album_Adapter(List2Activity.this, albumArrayList);
                recyclerView.setAdapter(album_adapter);
            }
        }

    }
}