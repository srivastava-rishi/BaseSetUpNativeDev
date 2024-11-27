package com.rishi.basesetup.animation.ui

import androidx.compose.ui.graphics.Color as ComposeColor

interface PothosColors {
    val neutral: Neutral
    val brand: Brand
    val info: Info
    val accent: Accent
    val caution: Caution
    val warning: Warning
    val danger: Danger
}

interface Neutral {

    val background: Background
    val text: Text
    val border: Border
    val icon: Icon

    interface Background {
        val primary: ComposeColor
        val secondary: ComposeColor
        val tertiary: ComposeColor
        val quaternary: ComposeColor
        val quinary: ComposeColor
        val senary: ComposeColor
        val septenary: ComposeColor
    }

    interface Text {
        val lowEmphasis: ComposeColor
        val mediumEmphasis: ComposeColor
        val highEmphasis: ComposeColor
        val lowEmphasisInverse: ComposeColor
        val mediumEmphasisInverse: ComposeColor
        val highEmphasisInverse: ComposeColor
    }

    interface Border {
        val primary: ComposeColor
        val secondary: ComposeColor
        val tertiary: ComposeColor
        val quaternary: ComposeColor
        val quinary: ComposeColor
        val primaryInverse: ComposeColor
    }

    interface Icon {
        val primary: ComposeColor
        val secondary: ComposeColor
        val tertiary: ComposeColor
        val primaryInverse: ComposeColor
        val secondaryInverse: ComposeColor
    }
}

interface Brand {

    val background: Background
    val text: Text
    val border: Border
    val icon: Icon

    interface Background {
        val cta: ComposeColor
        val primary: ComposeColor
        val secondary: ComposeColor
        val tertiary: ComposeColor
        val quaternary: ComposeColor
        val quinary: ComposeColor
    }

    interface Text {
        val primary: ComposeColor
        val secondary: ComposeColor
        val primaryInverse: ComposeColor
    }

    interface Border {
        val primary: ComposeColor
        val secondary: ComposeColor
        val tertiary: ComposeColor
        val quaternary: ComposeColor
    }

    interface Icon {
        val primary: ComposeColor
        val secondary: ComposeColor
        val tertiary: ComposeColor
        val primaryInverse: ComposeColor
    }
}

interface Info {

    val background: Background
    val text: Text
    val icon: Icon

    interface Background {
        val primary: ComposeColor
        val secondary: ComposeColor
        val tertiary: ComposeColor
    }

    interface Text {
        val primary: ComposeColor
    }

    interface Icon {
        val primary: ComposeColor
    }
}

interface Accent {

    val background: Background
    val text: Text
    val icon: Icon

    interface Background {
        val primary: ComposeColor
        val secondary: ComposeColor
    }

    interface Text {
        val primary: ComposeColor
    }

    interface Icon {
        val primary: ComposeColor
    }
}

interface Caution {

    val background: Background
    val text: Text
    val icon: Icon

    interface Background {
        val primary: ComposeColor
        val secondary: ComposeColor
        val tertiary: ComposeColor
        val quaternary: ComposeColor
    }

    interface Text {
        val primary: ComposeColor
    }

    interface Icon {
        val primary: ComposeColor
    }
}

interface Warning {

    val background: Background
    val text: Text
    val icon: Icon

    interface Background {
        val primary: ComposeColor
        val secondary: ComposeColor
        val tertiary: ComposeColor
    }

    interface Text {
        val primary: ComposeColor
        val secondary: ComposeColor
    }

    interface Icon {
        val primary: ComposeColor
    }
}

interface Danger {

    val background: Background
    val text: Text
    val border: Border
    val icon: Icon

    interface Background {
        val primary: ComposeColor
        val secondary: ComposeColor
        val tertiary: ComposeColor
    }

    interface Text {
        val primary: ComposeColor
    }

    interface Icon {
        val primary: ComposeColor
    }

    interface Border {
        val primary: ComposeColor
    }
}