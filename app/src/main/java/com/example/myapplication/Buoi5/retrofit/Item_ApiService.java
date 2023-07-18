package com.example.myapplication.Buoi5.retrofit;

import com.example.myapplication.Buoi5.Album;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Item_ApiService {
  @GET("photos")
  Call<ArrayList<Album>> getItems();
}
