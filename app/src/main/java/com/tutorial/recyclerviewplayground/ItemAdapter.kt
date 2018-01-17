package com.tutorial.recyclerviewplayground

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import java.util.*

/**
 * Created by joedsantiago on 17/01/2018.
 */

class ItemAdapter : BaseRecyclerAdapter<Item, RecyclerView.ViewHolder>() {

    val titles: List<String> = ArrayList<String>().apply {
        add("Title 1")
        add("Title 2")
        add("Title 3")
        add("Title 4")
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2 * 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        Log.d("Joed", "Viewtype" + viewType)
        when (viewType) {
            0 -> return ItemVH(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_recycler, parent, false))
            2 -> return SectionVH(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_section, parent, false))
            else -> return null
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder.itemViewType) {
            0 -> {
                val itemVH = holder as ItemVH
                itemVH.name.text = item.name
                itemVH.name.setOnTouchListener({view,evt->
                    if(evt.action == MotionEvent.ACTION_UP){
                        itemVH.name.text = ""
                        false
                    }
                    false
                })
            }
            2 -> {
                val sectionVH = holder as SectionVH
                sectionVH.name.text = titles[0]
            }


        }


    }

}
