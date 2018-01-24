package com.tutorial.recyclerviewplayground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by joedsantiago on 24/01/2018.
 */

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Jjjj", "onCreate");
        setContentView(R.layout.activity_lifecycle);
        final Button edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TestFragment testFragment = new TestFragment();

                FragmentTransaction ft = getSupportFragmentManager()
                        .beginTransaction();
                ft.add(testFragment, "");
                ft.commit();

                edit.getHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragContainer,new TestFragment2())
                                .addToBackStack(null)
                                .commit();
                    }
                }, 3000);



//                startActivity(new Intent(getApplicationContext(), EditTextActivity.class));
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Jjjj", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Jjjj", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Jjjj", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Jjjj", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Jjjj", "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
