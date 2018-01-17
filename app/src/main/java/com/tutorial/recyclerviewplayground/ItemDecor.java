package com.tutorial.recyclerviewplayground;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

/**
 * Created by joedsantiago on 17/01/2018.
 */

public class ItemDecor extends RecyclerView.ItemDecoration {

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        c.drawColor(Color.RED);
        super.onDraw(c, parent, state);

    }
}
