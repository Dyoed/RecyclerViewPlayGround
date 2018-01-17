package com.tutorial.recyclerviewplayground;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by joedsantiago on 17/01/2018.
 */

public class LayoutsActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);


        BuildConfig.VERSION_CODE
        BuildConfig.VERSION_NAME

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                android.R.anim.fade_in
                Toast.makeText(LayoutsActivity.this, "Tiiiiiiiiiji", Toast.LENGTH_SHORT).show();
            }
        }, 800);
    }
}
