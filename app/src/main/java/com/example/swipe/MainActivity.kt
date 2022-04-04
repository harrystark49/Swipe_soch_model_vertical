package com.example.swipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.swipe.example.TestViewPager
import com.example.swipe.example.VerticalPageTransformer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewPager: TestViewPager
    lateinit var adap:adap
    var viewPagerState = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list=ArrayList<String>()

         viewPager= this.findViewById<TestViewPager>(R.id.viewPager)

        //bottom is is for vertical scroll view
        val displayMetrics: DisplayMetrics = resources.displayMetrics
        val density = displayMetrics.density
        var translation = 45f
        if (density <= 2.0)
            translation = 32f
        else if (density > 2.0f && density <= 2.5f)
            translation = 40f

        viewPager.setPageTransformer(true, VerticalPageTransformer(translation))
        for(i in 1..10){
            list.add("view $i")
        }

       adap= adap(this,list)
        adap.viewPager=viewPager
        var llm=LinearLayoutManager(this)
        llm.orientation=LinearLayoutManager.VERTICAL
        viewPager.adapter=adap

//
//        con.setOnTouchListener(object : OnSwipeTouchListener(this){
//
//            override fun onSwipeRight() {
//                super.onSwipeRight()
//                Toast.makeText(this@MainActivity, "Swiped Right", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onSwipeLeft() {
//                super.onSwipeLeft()
//                Toast.makeText(this@MainActivity, "Swiped Left", Toast.LENGTH_SHORT).show()
//
//            }
//
//            override fun onSwipeUp() {
//                super.onSwipeUp()
//                Toast.makeText(this@MainActivity, "Swiped Up", Toast.LENGTH_SHORT).show()
//
//            }
//
//            override fun onSwipeDown() {
//                super.onSwipeDown()
//                Toast.makeText(this@MainActivity, "Swiped Down", Toast.LENGTH_SHORT).show()
//
//            }
//        })
        viewPager.addOnPageChangeListener(object :com.example.swipe.example.ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
                viewPagerState=state
//                Toast.makeText(this@MainActivity, "moved", Toast.LENGTH_SHORT).show()
            }

        })

        viewPager?.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_SCROLL) {
                if (viewPagerState == ViewPager.SCROLL_STATE_IDLE) {
                    Toast.makeText(this, "moved", Toast.LENGTH_SHORT).show()
                }
                }
            return@setOnTouchListener false
        }

    }


}