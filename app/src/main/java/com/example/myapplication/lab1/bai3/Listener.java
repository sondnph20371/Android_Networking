package com.example.myapplication.lab1.bai3;

import android.graphics.Bitmap;

public interface Listener {
    void onImageDowload(Bitmap bitmap);
    void onError();
}
