package com.example.myapplication.Buoi5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.Buoi5.retrofit.Item_ApiService;
import com.example.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    // Album_AsyncTask album_asyncTask;
    ArrayList<Album> listTest = new ArrayList<>();

    Album_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.rcvAlbum);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("https://jsonplaceholder.typicode.com/")
               .addConverterFactory(GsonConverterFactory.create())
               .build();

       Item_ApiService apiService = retrofit.create(Item_ApiService.class);
       Call<ArrayList<Album>> call = apiService.getItems();
       call.enqueue(new Callback<ArrayList<Album>>() {
           @Override
           public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
               if(response.isSuccessful()) {
                   listTest = response.body();
                   Log.i("Sync", "Success");
                   Log.i("Sync", String.valueOf(listTest.size()));
                   adapter  = new Album_Adapter(ListActivity.this, listTest);
                   recyclerView.setAdapter(adapter);
               } else {
                   Log.i("Sync", "Fail");
               }
           }

           @Override
           public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

           }
       });

    }
}