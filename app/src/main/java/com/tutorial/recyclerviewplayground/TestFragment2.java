package com.tutorial.recyclerviewplayground;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by joedsantiago on 24/01/2018.
 */

public class TestFragment2 extends android.support.v4.app.Fragment{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Jjjj","onCreate2");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Jjjj","onAttach2");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Jjjj","onCreateView2");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("Jjjj","onViewCreated2");
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Jjjj","onDetach2");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Jjjj","onDestroy2");
    }
}
