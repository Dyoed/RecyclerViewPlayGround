package com.tutorial.recyclerviewplayground;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by joedsantiago on 17/01/2018.
 */

public abstract class BaseRecyclerAdapter<E, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<E> items;

    public void setItems(List<E> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void addAll(List<E> newItems){
        this.items.addAll(newItems);
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public E getItem(int position){
        return items.get(position);
    }


}
