package com.rishi.basesetup.animation.ui

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.rishi.basesetup.R

// Pothos uses Inter font family by default
val DefaultFontFamily = FontFamily(
    Font(R.font.pothos_inter_black, FontWeight.Black),
    Font(R.font.pothos_inter_bold, FontWeight.Bold),
    Font(R.font.pothos_inter_extrabold, FontWeight.ExtraBold),
    Font(R.font.pothos_inter_extralight, FontWeight.ExtraLight),
    Font(R.font.pothos_inter_light, FontWeight.Light),
    Font(R.font.pothos_inter_regular, FontWeight.W400),
    Font(R.font.pothos_inter_medium, FontWeight.W500),
    Font(R.font.pothos_inter_semibold, FontWeight.W600),
    Font(R.font.pothos_inter_thin, FontWeight.Thin)
)

val MvCashFontFamily = FontFamily(
    Font(R.font.pothos_mvcash_black, FontWeight.Black),
    Font(R.font.pothos_mvcash_bold, FontWeight.Bold),
    Font(R.font.pothos_mvcash_extrabold, FontWeight.ExtraBold),
    Font(R.font.pothos_mvcash_extralight, FontWeight.ExtraLight),
    Font(R.font.pothos_mvcash_light, FontWeight.Light),
    Font(R.font.pothos_mvcash_regular, FontWeight.W400),
    Font(R.font.pothos_mvcash_medium, FontWeight.W500),
    Font(R.font.pothos_mvcash_semibold, FontWeight.W600),
    Font(R.font.pothos_mvcash_thin, FontWeight.Thin)
)

object FontWeightTokens {
    val regular: FontWeight = FontWeight.W400
    val medium: FontWeight = FontWeight.W500
    val semibold: FontWeight = FontWeight.W600
    val bold: FontWeight = FontWeight.W800
}

object FontSizeTokens {
    val fontSize50: TextUnit = 10.sp
    val fontSize63: TextUnit = 11.sp
    val fontSize75: TextUnit = 12.sp
    val fontSize100: TextUnit = 14.sp
    val fontSize200: TextUnit = 16.sp
    val fontSize300: TextUnit = 18.sp
    val fontSize400: TextUnit = 20.sp
    val fontSize500: TextUnit = 24.sp
    val fontSize600: TextUnit = 32.sp
    val fontSize700: TextUnit = 42.sp
}

object LineHeightTokens {
    val lineHeight50: TextUnit = 16.sp
    val lineHeight63: TextUnit = 18.sp
    val lineHeight75: TextUnit = 20.sp
    val lineHeight100: TextUnit = 22.sp
    val lineHeight200: TextUnit = 24.sp
    val lineHeight300: TextUnit = 26.sp
    val lineHeight400: TextUnit = 28.sp
    val lineHeight500: TextUnit = 32.sp
    val lineHeight600: TextUnit = 46.sp
    val lineHeight700: TextUnit = 56.sp
}

object LetterSpacingTokens {
    val compact: TextUnit = (-0.1).sp
    val default: TextUnit = 0.sp
    val spacious: TextUnit = (0.3).sp
    val xSpacious: TextUnit = (0.5).sp
}

object TextDecorationTokens {
    val default: TextDecoration = TextDecoration.None
    val link: TextDecoration = TextDecoration.Underline
    val crossed: TextDecoration = TextDecoration.LineThrough
}

object FontStyleTokens {
    val normal: FontStyle = FontStyle.Normal
    val italic: FontStyle = FontStyle.Italic
}