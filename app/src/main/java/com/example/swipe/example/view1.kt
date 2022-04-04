package com.example.swipe.example

import android.content.Context
import android.view.View

class view1(var context: Context,var view:View):RecycledPagerAdapter.ViewHolder(view) {
    lateinit var viewPager: TestViewPager
    override fun onDestroy() {
    }
}