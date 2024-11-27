package com.rishi.basesetup.animation.common

import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.rishi.basesetup.animation.ui.DefaultFontFamily
import com.rishi.basesetup.animation.ui.DefaultLightPothosColors
import com.rishi.basesetup.animation.ui.PothosColors
import com.whizdm.pothos.theme.shape.DefaultShapes
import com.whizdm.pothos.theme.shape.PothosShapes


@Composable
fun PothosText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF34353A),
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = PothosTheme.typography.bodyMediumMediumEmphasis
) {
    PothosText(
        text = AnnotatedString(text),
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        inlineContent = emptyMap(),
        onTextLayout = onTextLayout,
        style = style
    )
}

@Composable
fun PothosText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF34353A),
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    inlineContent: Map<String, InlineTextContent> = mapOf(),
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = PothosTheme.typography.bodyMediumMediumEmphasis
) {
    val mergedStyle = style.merge(
        TextStyle(
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            textAlign = textAlign ?: TextAlign.Unspecified,
            lineHeight = lineHeight,
            fontFamily = fontFamily,
            textDecoration = textDecoration,
            fontStyle = fontStyle,
            letterSpacing = letterSpacing
        ).textStylePadding()
    )

    Text(
        text = text,
        modifier = modifier,
        style = mergedStyle,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        inlineContent = inlineContent,
        lineHeight = lineHeight,
        fontWeight = fontWeight,
        fontSize = fontSize,
        fontFamily = fontFamily,
        textAlign = textAlign,
        color = color,
        fontStyle = fontStyle,
        letterSpacing = letterSpacing,
        onTextLayout = onTextLayout,
        textDecoration = textDecoration
    )
}



fun TextStyle.textStylePadding() = copy(
    platformStyle = PlatformTextStyle(
        includeFontPadding = true
    ),
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Proportional,
        trim = LineHeightStyle.Trim.None,
    )
)


internal val LocalColors: ProvidableCompositionLocal<PothosColors> =
    staticCompositionLocalOf { DefaultLightPothosColors }

internal val LocalShapes: ProvidableCompositionLocal<PothosShapes> =
    staticCompositionLocalOf { DefaultShapes }

internal val LocalTypography: ProvidableCompositionLocal<PothosTypography> =
    staticCompositionLocalOf { DefaultPothosTypography(DefaultFontFamily) }

object PothosTheme {

    val colors: PothosColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val shapes: PothosShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    val typography: PothosTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
