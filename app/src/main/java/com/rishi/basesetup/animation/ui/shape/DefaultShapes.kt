package com.whizdm.pothos.theme.shape

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

object DefaultShapes : PothosShapes {
    override val round: Shape
        get() = CircleShape
    override val xSmall: CornerBasedShape
        get() = RoundedCornerShape(size = 4.dp)
    override val small: CornerBasedShape
        get() = RoundedCornerShape(size = 8.dp)
    override val medium: CornerBasedShape
        get() = RoundedCornerShape(size = 12.dp)
    override val large: CornerBasedShape
        get() = RoundedCornerShape(size = 16.dp)
    override val xLarge: CornerBasedShape
        get() = RoundedCornerShape(size = 20.dp)
    override val xxLarge: CornerBasedShape
        get() = RoundedCornerShape(size = 24.dp)
}