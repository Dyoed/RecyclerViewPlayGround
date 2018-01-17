package com.tutorial.recyclerviewplayground;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by joedsantiago on 17/01/2018.
 */

public class SectionVH extends RecyclerView.ViewHolder {

    public TextView name;

    public SectionVH(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.nameTv);
    }
}
