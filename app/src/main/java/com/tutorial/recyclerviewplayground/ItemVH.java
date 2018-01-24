package com.tutorial.recyclerviewplayground;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by joedsantiago on 17/01/2018.
 */

public class ItemVH extends RecyclerView.ViewHolder {

    protected EditText name;

    public ItemVH(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.nameTv);
    }
}
