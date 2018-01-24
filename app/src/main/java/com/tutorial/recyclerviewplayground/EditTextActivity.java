package com.tutorial.recyclerviewplayground;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Continuation: EditText
 */
public class EditTextActivity extends AppCompatActivity implements OnLastItemVisible, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private PagingLayoutManager pagingLayoutManager;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    private AutoCompleteTextView autoCompleteTextView;

    private void setupRecyclerView() {
        pagingLayoutManager = new PagingLayoutManager(this);

        recyclerView.setLayoutManager(pagingLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }


    private void setupEditText() {

//        autoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                Log.d("Jjjj", "Has focus" + hasFocus);
//                if (!hasFocus)
//                    autoCompleteTextView.setText(autoCompleteTextView.getText().toString() + "s");
//            }
//        });

//        autoCompleteTextView.setFilters(new InputFilter[]{
//                new InputFilter() {
//                    @Override
//                    public CharSequence filter(CharSequence source, int start, int end,
//                                               Spanned dest, int dstart, int dend) {
//
//                        Log.d("InputFilter", source.toString()+"--"+dest);
//                        if (autoCompleteTextView.getText().toString().contains("s")) {
//                            autoCompleteTextView.setText(autoCompleteTextView.getText().toString().replace("s", ""));
//                        }
//                        return source.toString() + "s";
//                    }
//                }
//        });


        autoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.d("Jjj", v.getText().toString());
                itemAdapter.updateStakes(Integer.parseInt(v.getText().toString()));
                return true;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoComplete);
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);

        swipeRefreshLayout.setOnRefreshListener(this);
        setupEditText();

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//        recyclerView.setLayoutManager(gridLayoutManager);

        setupRecyclerView();

        itemAdapter = new ItemAdapter();
        itemAdapter.setItems(getItems());
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                Log.d("Jjjj","Onchanged");
                if(itemAdapter.isMixed()){
                    autoCompleteTextView.setText("Mixed");
                }
            }
        });

    }

    private List<Item> getItems() {
        List<Item> items = new ArrayList<>(30);
        for (int i = 0; i < 5; i++) {
            items.add(new Item( "5s"));
        }
        return items;
    }


    @Override
    public void onLastItemVisible() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                itemAdapter.addAll(getItems());
                pagingLayoutManager.resetLoadStatus();
                progressBar.setVisibility(View.INVISIBLE);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        //TODO
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                itemAdapter.setItems(getItems());
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Jjjj","onDestroy");
    }


}
