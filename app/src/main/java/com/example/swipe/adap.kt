package com.example.swipe

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.swipe.example.RecycledPagerAdapter
import com.example.swipe.example.TestViewPager
import com.example.swipe.example.ViewHolder1

class adap(var context: Context,var list:List<String>): RecycledPagerAdapter<ViewHolder1>() {

    var viewPager: TestViewPager? = null
    override fun getCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder1 {
        var view= LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        var v1=ViewHolder1(context,view)
        v1.viewPager=viewPager!!

        return v1
            }

    override fun onBindViewHolder(viewHolder: ViewHolder1?, position: Int) {
        viewHolder?.redner(list[position],position)
    }


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): view {
//        return view(LayoutInflater.from(context).inflate(R.layout.each_item,parent,false))
//    }
//
//    override fun onBindViewHolder(holder: view, position: Int) {
//        holder.bind(position)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
}