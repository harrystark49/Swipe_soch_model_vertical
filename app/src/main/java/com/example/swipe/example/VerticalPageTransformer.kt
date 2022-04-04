package com.example.swipe.example

import android.view.View

//import androidx.viewpager.widget.ViewPager


class VerticalPageTransformer(val translate : Float) : ViewPager.PageTransformer {

    companion object {
        private const val TAG = "SliderTransformer"

        private const val DEFAULT_TRANSLATION_X = .0f
        private const val DEFAULT_TRANSLATION_FACTOR = 1.2f

        private const val SCALE_FACTOR = .14f
        private const val DEFAULT_SCALE = 1f

        private const val ALPHA_FACTOR = .3f
        private const val DEFAULT_ALPHA = 1f
        val CURRENT_PAGE_SCALE = 0.99f

    }

    override fun transformPage(page: View, position: Float) {

        page.apply {

//            ViewCompat.setElevation(page, -abs(position))
            setLayerType(View.LAYER_TYPE_NONE, null)

            val scaleFactor = -SCALE_FACTOR * position + DEFAULT_SCALE
            val alphaFactor = -ALPHA_FACTOR * position + DEFAULT_ALPHA
            val scale = CURRENT_PAGE_SCALE - position * 0.03f

            scaleX = scale
            scaleY = scale

            when {
                position <= 0f -> {
                    translationX = -position * width
                    val yPosition = position * height
                    translationY = yPosition
//                    alpha = DEFAULT_ALPHA
                    alpha = alphaFactor
                }
                position <= 4 -> {
                    translationX = -(width) * position
                    translationY = translate * position
//                    alpha = DEFAULT_ALPHA
                    alpha = alphaFactor
                }
                else -> {
                    translationX = -(width) * position
                    alpha = alphaFactor
//                    alpha = 0f
                }
            }
        }
    }

}
