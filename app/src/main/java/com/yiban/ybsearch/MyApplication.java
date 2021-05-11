package com.yiban.ybsearch;

import android.app.Application;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

public class MyApplication extends Application {
    public static final String CACHE_ENGINE = "com.yiban/search";

    @Override
    public void onCreate() {
        super.onCreate();
        FlutterEngine engine = new FlutterEngine(this);
        engine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
        FlutterEngineCache.getInstance().put(CACHE_ENGINE, engine);

    }
}
