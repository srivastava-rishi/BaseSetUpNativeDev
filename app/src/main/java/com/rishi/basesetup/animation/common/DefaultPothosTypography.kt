package com.rishi.basesetup.animation.common

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

class DefaultPothosTypography(
    val defaultFontFamily: FontFamily
) : PothosTypography {

    override val headline1: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize700
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight700
            override val fontWeight: FontWeight
                get() = FontWeightTokens.medium
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val headline2: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize600
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight600
            override val fontWeight: FontWeight
                get() = FontWeightTokens.medium
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val title1: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize500
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight500
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val title2: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize300
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight300
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bannerTitle: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize400
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight400
            override val fontWeight: FontWeight
                get() = FontWeightTokens.bold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bannerTitle1: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize600
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight500
            override val fontWeight: FontWeight
                get() = FontWeightTokens.bold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyLargeLowEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize200
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight200
            override val fontWeight: FontWeight
                get() = FontWeightTokens.regular
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyLargeMediumEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize200
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight200
            override val fontWeight: FontWeight
                get() = FontWeightTokens.medium
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyLargeHighEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize200
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight200
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyLargeLink: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize200
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight200
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.link
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyMediumLowEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize100
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight100
            override val fontWeight: FontWeight
                get() = FontWeightTokens.regular
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyMediumMediumEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize100
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight100
            override val fontWeight: FontWeight
                get() = FontWeightTokens.medium
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyMediumHighEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize100
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight100
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyMediumLink: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize100
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight100
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.default
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.link
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodySmallLowEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize75
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight75
            override val fontWeight: FontWeight
                get() = FontWeightTokens.regular
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.spacious
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodySmallHighEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize75
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight75
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.spacious
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodySmallLink: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize75
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight75
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.spacious
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.link
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyTinyLowEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize50
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight50
            override val fontWeight: FontWeight
                get() = FontWeightTokens.regular
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.xSpacious
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyTinyHighEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize50
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight50
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.xSpacious
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyTinyMediumEmphasis: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize50
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight50
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.xSpacious
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.default
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()

    override val bodyTinyLink: TextStyle
        get() = object : BaseTypography {
            override val fontFamily: FontFamily
                get() = defaultFontFamily
            override val fontSize: TextUnit
                get() = FontSizeTokens.fontSize50
            override val lineHeight: TextUnit
                get() = LineHeightTokens.lineHeight50
            override val fontWeight: FontWeight
                get() = FontWeightTokens.semibold
            override val letterSpacing: TextUnit
                get() = LetterSpacingTokens.xSpacious
            override val textDecoration: TextDecoration
                get() = TextDecorationTokens.link
            override val fontStyle: FontStyle
                get() = FontStyleTokens.normal
        }.toTextStyle()
}

fun BaseTypography.toTextStyle(): TextStyle {
    return TextStyle(
        fontSize = fontSize,
        fontFamily = fontFamily,
        lineHeight = lineHeight,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        fontStyle = fontStyle,
        textDecoration = textDecoration,
        fontFeatureSettings = "liga 0"
        // Added to disable font ligatures
        // in super home theme fonts
    )
}


interface PothosTypography {
    val headline1: TextStyle
    val headline2: TextStyle

    val title1: TextStyle
    val title2: TextStyle

    val bannerTitle: TextStyle
    val bannerTitle1: TextStyle

    val bodyLargeLowEmphasis: TextStyle
    val bodyLargeMediumEmphasis: TextStyle
    val bodyLargeHighEmphasis: TextStyle
    val bodyLargeLink: TextStyle

    val bodyMediumLowEmphasis: TextStyle
    val bodyMediumMediumEmphasis: TextStyle
    val bodyMediumHighEmphasis: TextStyle
    val bodyMediumLink: TextStyle

    val bodySmallLowEmphasis: TextStyle
    val bodySmallHighEmphasis: TextStyle
    val bodySmallLink: TextStyle

    val bodyTinyLowEmphasis: TextStyle
    val bodyTinyHighEmphasis: TextStyle
    val bodyTinyMediumEmphasis: TextStyle
    val bodyTinyLink: TextStyle
}

interface BaseTypography {
    val fontFamily: FontFamily
    val fontSize: TextUnit
    val lineHeight: TextUnit
    val fontWeight: FontWeight
    val letterSpacing: TextUnit
    val textDecoration: TextDecoration
    val fontStyle: FontStyle
}

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