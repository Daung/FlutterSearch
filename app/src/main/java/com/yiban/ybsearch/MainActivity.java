package com.yiban.ybsearch;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tv_Search(View view) {
        startActivity(FlutterActivity.withCachedEngine(MyApplication.CACHE_ENGINE).build(this));
    }
}