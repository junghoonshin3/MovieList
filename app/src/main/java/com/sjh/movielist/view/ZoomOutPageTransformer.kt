package com.sjh.movielist.view

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.sjh.movielist.core.utils.dp2px
import java.lang.Math.abs

private const val MIN_SCALE = 0.85f
private const val MIN_ALPHA = 0.5f

class ZoomOutPageTransformer() : ViewPager2.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        view.apply {
            val nextItemVisiblePx = 140.dp2px
            val currentItemHorizontalMarginPx = 100.dp2px
            val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
            val scaleFactor = 1 - (0.25f * abs(position))
            translationX = -pageTranslationX * position
            scaleY = scaleFactor
            scaleX = scaleFactor
            alpha = (MIN_ALPHA +
                    (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
        }
    }
}