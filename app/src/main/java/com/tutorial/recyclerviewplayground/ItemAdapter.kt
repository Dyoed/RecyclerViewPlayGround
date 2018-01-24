package com.tutorial.recyclerviewplayground

import android.annotation.SuppressLint
import android.app.Activity
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

    var titles: List<String> = ArrayList<String>().apply {
        add("Title 1")
        add("Title 2")
        add("Title 3")
        add("Title 4")
    }

    fun isMixed(): Boolean {
        var notMixed = true
        var lastItem: Item? = null
        items.forEach {
            if (lastItem != null) {
                if (it.name != lastItem?.name) notMixed = false
                return@forEach
            }
            lastItem = it
        }
        return !notMixed
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


    fun updateStakes(newStake: Int) {
        items.forEach {
            it.name = "${newStake}s"
        }
        notifyDataSetChanged()
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder.itemViewType) {
            0 -> {
                val itemVH = holder as ItemVH
                val editText = itemVH.name
                editText.setText(item.name)
                editText.setOnTouchListener({ view, evt ->
                    if (evt.action == MotionEvent.ACTION_UP) {
                        itemVH.name.setText("")
                        editText.post({Utils.showKeyboard(editText.context as Activity,
                                editText)})
//                        editText.requestFocus()
                    }
                    false
                })
                editText.setOnFocusChangeListener({ _, hasFocus ->
                    if (!hasFocus) {
                        Log.d("Jjjj", "$hasFocus -- ${item.name}")
                        itemVH.name.setText("${item.name}")

                    }
                })
                editText.setOnEditorActionListener { v, actionId, event ->
                    item.name = editText.text.toString().replace("s", "s") + "s"
                    items[position] = item
                    notifyItemChanged(position)
                    editText.clearFocus()
                    true
                }

            }
            2 -> {
                val sectionVH = holder as SectionVH
                sectionVH.name.text = titles[0]
            }


        }


    }

}
