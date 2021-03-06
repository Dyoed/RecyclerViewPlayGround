package com.tutorial.recyclerviewplayground;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnLastItemVisible, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private PagingLayoutManager pagingLayoutManager;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;


    private void setupRecyclerView() {
        pagingLayoutManager = new PagingLayoutManager(this);

        recyclerView.setLayoutManager(pagingLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);

        swipeRefreshLayout.setOnRefreshListener(this);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//        recyclerView.setLayoutManager(gridLayoutManager);

        setupRecyclerView();

        itemAdapter = new ItemAdapter();
        itemAdapter.setItems(getItems());
        recyclerView.setAdapter(itemAdapter);

    }

    private List<Item> getItems() {
        List<Item> items = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            items.add(new Item(  i+"s"));
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
}
