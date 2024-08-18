package com.rishi.basesetup.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.rishi.basesetup.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)


val interFamily = FontFamily(
    Font(R.font.font_inter, FontWeight.Normal),
    Font(R.font.font_inter_medium, FontWeight.Medium),
    Font(R.font.font_inter_semi_bold, FontWeight.SemiBold)
)

val Typography.largeDisplay: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 68.sp
    )

// hero title
val Typography.ht1: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 42.sp
    )
val Typography.ht1Center: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 42.sp,
        textAlign = TextAlign.Center
    )
val Typography.ht2: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 32.sp
    )
val Typography.ht3: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 28.sp,
        lineHeight = 40.sp
    )
val Typography.ht4: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
        lineHeight = 32.sp
    )

// title
val Typography.pageTitle: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    )
val Typography.sectionTitle: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
        lineHeight = 26.sp
    )
val Typography.subTitle: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    )
val Typography.subtitle2SelectedOnSurfaceHighEmphasisLeft: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W700,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp,
        lineHeight = 24.sp,
        color = budget_black_edit,
    )

// paragraph
val Typography.paragraphLeading: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    )
val Typography.paragraphLeadingMedium: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 18.sp
    )
val Typography.paragraphLeadingSemiBold: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W600,
        lineHeight = 28.sp,
        fontSize = 18.sp
    )
val Typography.paragraph: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    )
val Typography.paragraphMedium: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    )
val Typography.paragraphSemiBold: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    )
val Typography.link: TextStyle
    get() = paragraphSemiBold.copy(textDecoration = TextDecoration.Underline)

val Typography.paragraphSmall: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.03.sp,
        color = a_color_grey_dark
    )
val Typography.paragraphSmallCenter: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        textAlign = TextAlign.Center
    )
val Typography.paragraphRegular: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        textAlign = TextAlign.Center
    )

val Typography.paragraphSmallMedium: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    )
val Typography.paragraphSmallSemiBold: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    )
val Typography.paragraphDefaultRegular: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        lineHeight = 24.sp,
        fontSize = 16.sp,
        letterSpacing = 0.03.sp,
    )

val Typography.linkSmall: TextStyle
    get() = paragraphSmallSemiBold

val Typography.ParagraphSmallRegular: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        lineHeight = 22.sp,
        fontSize = 14.sp,
        letterSpacing = 0.03.sp,
        color = a_color_grey_dark
    )

// captions
val Typography.captionDefault: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        letterSpacing = 0.3.sp,
        color = budget_black_edit,
        lineHeight = 20.sp,
    )

val Typography.captionDefaultMedium: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
    )
val  Typography.captionDefaultSemiBold: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W600,
        fontSize = 12.sp
    )
val Typography.captionLink: TextStyle
    get() = captionDefaultSemiBold

val Typography.captionSmall: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp
    )
val Typography.captionSmallMedium: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 10.sp
    )
val Typography.captionSmallSemiBold: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W600,
        fontSize = 10.sp
    )
val Typography.captionSmallLink: TextStyle
    get() = captionSmallSemiBold

val Typography.captionRegular: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.3.sp,
        color = budget_black_edit,
        lineHeight = 20.sp,
    )

//buttons
val Typography.buttonSmall: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W600,
        fontSize = 10.sp,
        lineHeight = 22.sp
    )

// overline
val Typography.overLine: TextStyle
    get() = captionDefaultSemiBold

val Typography.body2SelectedOnSurfaceHighEmphasisLeft: TextStyle
    get() = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp,
        color = budget_black_edit,
        lineHeight = 20.sp
    )