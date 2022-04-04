package com.example.swipe.example

import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.each_item.view.*

class ViewHolder1(context: Context,view:View):RecycledPagerAdapter.ViewHolder(view) {
    lateinit var viewPager: TestViewPager

    fun redner(data:String, pos: Int){
        itemView.textv.text=data
    }
    override fun onDestroy() {

    }

}