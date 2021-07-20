package com.lfelipe.numbergame.util

import androidx.constraintlayout.widget.ConstraintLayout
import com.lfelipe.numbergame.databinding.NumberLayoutBinding


fun NumberLayoutBinding.setColor(color: Int) {
    this.apply {
        ivBottom.setBackgroundColor(color)
        ivBottomStart.setBackgroundColor(color)
        ivBottomEnd.setBackgroundColor(color)
        ivTop.setBackgroundColor(color)
        ivTopStart.setBackgroundColor(color)
        ivTopEnd.setBackgroundColor(color)
        ivCenter.setBackgroundColor(color)
    }

}

fun NumberLayoutBinding.setSize(size: Int) {
    val layout = this.numberContainer
    when (size) {

        0 -> this.apply {
            ivTopEnd.layoutParams.height = 40.toDp(layout)
            ivTopEnd.layoutParams.width = 7.toDp(layout)
            ivTopStart.layoutParams.height = 40.toDp(layout)
            ivTopStart.layoutParams.width = 7.toDp(layout)
            ivBottomStart.layoutParams.height = 40.toDp(layout)
            ivBottomStart.layoutParams.width = 7.toDp(layout)
            ivBottomEnd.layoutParams.height = 40.toDp(layout)
            ivBottomEnd.layoutParams.width = 7.toDp(layout)
            ivTop.layoutParams.width = 35.toDp(layout)
            ivTop.layoutParams.height = 6.toDp(layout)
            ivCenter.layoutParams.width = 35.toDp(layout)
            ivCenter.layoutParams.height = 6.toDp(layout)
            ivBottom.layoutParams.width = 35.toDp(layout)
            ivBottom.layoutParams.height = 6.toDp(layout)
            ivTopStart.requestLayout()
            ivTopEnd.requestLayout()
            ivBottomStart.requestLayout()
            ivBottomEnd.requestLayout()
            ivTop.requestLayout()
            ivCenter.requestLayout()
            ivBottom.requestLayout()
        }
        25 -> this.apply {
            ivTopEnd.layoutParams.height = 50.toDp(layout)
            ivTopEnd.layoutParams.width = 8.toDp(layout)
            ivTopStart.layoutParams.height = 50.toDp(layout)
            ivTopStart.layoutParams.width = 8.toDp(layout)
            ivBottomStart.layoutParams.height = 50.toDp(layout)
            ivBottomStart.layoutParams.width = 8.toDp(layout)
            ivBottomEnd.layoutParams.height = 50.toDp(layout)
            ivBottomEnd.layoutParams.width = 8.toDp(layout)
            ivTop.layoutParams.width = 45.toDp(layout)
            ivTop.layoutParams.height = 8.toDp(layout)
            ivCenter.layoutParams.width = 45.toDp(layout)
            ivCenter.layoutParams.height = 8.toDp(layout)
            ivBottom.layoutParams.width = 45.toDp(layout)
            ivBottom.layoutParams.height = 8.toDp(layout)
            ivTopStart.requestLayout()
            ivTopEnd.requestLayout()
            ivBottomStart.requestLayout()
            ivBottomEnd.requestLayout()
            ivTop.requestLayout()
            ivCenter.requestLayout()
            ivBottom.requestLayout()
        }
        50 -> this.apply {
            ivTopEnd.layoutParams.height = 60.toDp(layout)
            ivTopEnd.layoutParams.width = 10.toDp(layout)
            ivTopStart.layoutParams.height = 60.toDp(layout)
            ivTopStart.layoutParams.width = 10.toDp(layout)
            ivBottomStart.layoutParams.height = 60.toDp(layout)
            ivBottomStart.layoutParams.width = 10.toDp(layout)
            ivBottomEnd.layoutParams.height = 60.toDp(layout)
            ivBottomEnd.layoutParams.width = 10.toDp(layout)
            ivTop.layoutParams.width = 55.toDp(layout)
            ivTop.layoutParams.height = 10.toDp(layout)
            ivCenter.layoutParams.width = 55.toDp(layout)
            ivCenter.layoutParams.height = 10.toDp(layout)
            ivBottom.layoutParams.width = 55.toDp(layout)
            ivBottom.layoutParams.height = 10.toDp(layout)
            ivTopStart.requestLayout()
            ivTopEnd.requestLayout()
            ivBottomStart.requestLayout()
            ivBottomEnd.requestLayout()
            ivTop.requestLayout()
            ivCenter.requestLayout()
            ivBottom.requestLayout()
        }
        75 -> this.apply {
            ivTopEnd.layoutParams.height = 70.toDp(layout)
            ivTopEnd.layoutParams.width = 12.toDp(layout)
            ivTopStart.layoutParams.height = 70.toDp(layout)
            ivTopStart.layoutParams.width = 12.toDp(layout)
            ivBottomStart.layoutParams.height = 70.toDp(layout)
            ivBottomStart.layoutParams.width = 12.toDp(layout)
            ivBottomEnd.layoutParams.height = 70.toDp(layout)
            ivBottomEnd.layoutParams.width = 12.toDp(layout)
            ivTop.layoutParams.width = 65.toDp(layout)
            ivTop.layoutParams.height = 12.toDp(layout)
            ivCenter.layoutParams.width = 65.toDp(layout)
            ivCenter.layoutParams.height = 12.toDp(layout)
            ivBottom.layoutParams.width = 65.toDp(layout)
            ivBottom.layoutParams.height = 12.toDp(layout)
            ivTopStart.requestLayout()
            ivTopEnd.requestLayout()
            ivBottomStart.requestLayout()
            ivBottomEnd.requestLayout()
            ivTop.requestLayout()
            ivCenter.requestLayout()
            ivBottom.requestLayout()

        }
        100 ->
            this.apply {
                ivTopEnd.layoutParams.height = 80.toDp(layout)
                ivTopEnd.layoutParams.width = 13.toDp(layout)
                ivTopStart.layoutParams.height = 80.toDp(layout)
                ivTopStart.layoutParams.width = 13.toDp(layout)
                ivBottomStart.layoutParams.height = 80.toDp(layout)
                ivBottomStart.layoutParams.width = 13.toDp(layout)
                ivBottomEnd.layoutParams.height = 80.toDp(layout)
                ivBottomEnd.layoutParams.width = 13.toDp(layout)
                ivTop.layoutParams.width = 75.toDp(layout)
                ivTop.layoutParams.height = 14.toDp(layout)
                ivCenter.layoutParams.width = 75.toDp(layout)
                ivCenter.layoutParams.height = 14.toDp(layout)
                ivBottom.layoutParams.width = 75.toDp(layout)
                ivBottom.layoutParams.height = 14.toDp(layout)
                ivTopStart.requestLayout()
                ivTopEnd.requestLayout()
                ivBottomStart.requestLayout()
                ivBottomEnd.requestLayout()
                ivTop.requestLayout()
                ivCenter.requestLayout()
                ivBottom.requestLayout()

            }


    }
}


fun Int.toDp(layout: ConstraintLayout): Int {
    val pixels: Float = layout.context.resources.displayMetrics.density;
    return (this * pixels).toInt()
}