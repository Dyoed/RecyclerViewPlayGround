package com.tutorial.recyclerviewplayground;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by joedsantiago on 17/01/2018.
 */

public class PagingLayoutManager extends LinearLayoutManager {

    private OnLastItemVisible onLastItemVisible;
    private boolean isLoading;

    public void setOnLastItemVisible(OnLastItemVisible onLastItemVisible) {
        this.onLastItemVisible = onLastItemVisible;
    }

    public void resetLoadStatus(){
        isLoading = false;
    }

    public PagingLayoutManager(Context context) {
        super(context);
        if (context instanceof OnLastItemVisible) {
            this.onLastItemVisible = (OnLastItemVisible) context;
        }
    }

    public PagingLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public PagingLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {

        if (findLastVisibleItemPosition() == getItemCount() - 1) {
            if (onLastItemVisible != null && !isLoading) {
                isLoading = true;
                onLastItemVisible.onLastItemVisible();
            }
        }

        Log.d("Jjj", " -- " + findLastVisibleItemPosition());
        return super.scrollVerticallyBy(dy, recycler, state);


    }
}
