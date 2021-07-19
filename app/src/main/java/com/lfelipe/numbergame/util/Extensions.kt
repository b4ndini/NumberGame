package com.lfelipe.numbergame.util

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