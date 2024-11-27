package com.rishi.basesetup.animation.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color as ComposeColor

object DefaultLightPothosColors : PothosColors {

    override val neutral: Neutral = object : Neutral {

        override val background: Neutral.Background
            get() = object : Neutral.Background {
                override val primary: ComposeColor
                    get() = PothosColorTokens.Grey.white
                override val secondary: ComposeColor
                    get() = PothosColorTokens.Grey.grey50
                override val tertiary: ComposeColor
                    get() = PothosColorTokens.Grey.grey100
                override val quaternary: ComposeColor
                    get() = PothosColorTokens.Grey.grey200
                override val quinary: ComposeColor
                    get() = PothosColorTokens.Grey.grey300
                override val senary: ComposeColor
                    get() = PothosColorTokens.Grey.grey400
                override val septenary: ComposeColor
                    get() = PothosColorTokens.Grey.grey900
            }

        override val text: Neutral.Text
            get() = object : Neutral.Text {
                override val lowEmphasis: ComposeColor
                    get() = PothosColorTokens.Grey.grey400
                override val mediumEmphasis: ComposeColor
                    get() = PothosColorTokens.Grey.grey700
                override val highEmphasis: ComposeColor
                    get() = PothosColorTokens.Grey.grey800
                override val lowEmphasisInverse: ComposeColor
                    get() = PothosColorTokens.Grey.grey300
                override val mediumEmphasisInverse: ComposeColor
                    get() = PothosColorTokens.Grey.grey50
                override val highEmphasisInverse: ComposeColor
                    get() = PothosColorTokens.Grey.white
            }

        override val border: Neutral.Border
            get() = object : Neutral.Border {
                override val primary: ComposeColor
                    get() = PothosColorTokens.Grey.grey100
                override val secondary: ComposeColor
                    get() = PothosColorTokens.Grey.grey200
                override val tertiary: ComposeColor
                    get() = PothosColorTokens.Grey.grey300
                override val quaternary: ComposeColor
                    get() = PothosColorTokens.Grey.grey500
                override val quinary: ComposeColor
                    get() = PothosColorTokens.Grey.grey900
                override val primaryInverse: Color
                    get() = PothosColorTokens.Grey.white
            }

        override val icon: Neutral.Icon
            get() = object : Neutral.Icon {
                override val primary: ComposeColor
                    get() = PothosColorTokens.Grey.grey800
                override val secondary: ComposeColor
                    get() = PothosColorTokens.Grey.grey400
                override val tertiary: ComposeColor
                    get() = PothosColorTokens.Grey.grey300
                override val primaryInverse: ComposeColor
                    get() = PothosColorTokens.Grey.white
                override val secondaryInverse: ComposeColor
                    get() = PothosColorTokens.Grey.grey300
            }
    }

    override val brand: Brand
        get() = object : Brand {
            override val background: Brand.Background
                get() = object : Brand.Background {
                    override val cta: ComposeColor
                        get() = PothosColorTokens.Primary.primary500
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Primary.primary600
                    override val secondary: ComposeColor
                        get() = PothosColorTokens.Primary.primary500
                    override val tertiary: ComposeColor
                        get() = PothosColorTokens.Primary.primary400
                    override val quaternary: ComposeColor
                        get() = PothosColorTokens.Primary.primary100
                    override val quinary: ComposeColor
                        get() = PothosColorTokens.Primary.primary50
                }
            override val text: Brand.Text
                get() = object : Brand.Text {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Primary.primary600
                    override val secondary: ComposeColor
                        get() = PothosColorTokens.Primary.primary500
                    override val primaryInverse: ComposeColor
                        get() = PothosColorTokens.Primary.primary300
                }
            override val border: Brand.Border
                get() = object : Brand.Border {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Primary.primary100
                    override val secondary: ComposeColor
                        get() = PothosColorTokens.Primary.primary300
                    override val tertiary: ComposeColor
                        get() = PothosColorTokens.Primary.primary500
                    override val quaternary: ComposeColor
                        get() = PothosColorTokens.Primary.primary600
                }
            override val icon: Brand.Icon
                get() = object : Brand.Icon {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Primary.primary600
                    override val secondary: ComposeColor
                        get() = PothosColorTokens.Primary.primary500
                    override val tertiary: Color
                        get() = PothosColorTokens.Primary.primary400
                    override val primaryInverse: ComposeColor
                        get() = PothosColorTokens.Primary.primary300
                }
        }

    override val info: Info
        get() = object : Info {
            override val background: Info.Background
                get() = object : Info.Background {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Secondary.secondary100
                    override val secondary: ComposeColor
                        get() = PothosColorTokens.Secondary.secondary200
                    override val tertiary: Color
                        get() = PothosColorTokens.Secondary.secondary600
                }
            override val text: Info.Text
                get() = object : Info.Text {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Secondary.secondary500
                }
            override val icon: Info.Icon
                get() = object : Info.Icon {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Secondary.secondary500
                }
        }

    override val accent: Accent
        get() = object : Accent {
            override val background: Accent.Background
                get() = object : Accent.Background {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Complementary.complementary100
                    override val secondary: ComposeColor
                        get() = PothosColorTokens.Complementary.complementary600
                }
            override val text: Accent.Text
                get() = object : Accent.Text {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Complementary.complementary500
                }
            override val icon: Accent.Icon
                get() = object : Accent.Icon {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Complementary.complementary500
                }
        }

    override val caution: Caution
        get() = object : Caution {
            override val background: Caution.Background
                get() = object : Caution.Background {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Yellow.yellow200
                    override val secondary: ComposeColor
                        get() = PothosColorTokens.Yellow.yellow300
                    override val tertiary: ComposeColor
                        get() = PothosColorTokens.Yellow.yellow500
                    override val quaternary: ComposeColor
                        get() = PothosColorTokens.Yellow.yellow600
                }
            override val text: Caution.Text
                get() = object : Caution.Text {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Yellow.yellow800
                }
            override val icon: Caution.Icon
                get() = object : Caution.Icon {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Yellow.yellow700
                }
        }

    override val warning: Warning
        get() = object : Warning {
            override val background: Warning.Background
                get() = object : Warning.Background {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Orange.orange100
                    override val secondary: ComposeColor
                        get() = PothosColorTokens.Orange.orange200
                    override val tertiary: ComposeColor
                        get() = PothosColorTokens.Orange.orange400
                }
            override val text: Warning.Text
                get() = object : Warning.Text {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Orange.orange500
                    override val secondary: ComposeColor
                        get() = PothosColorTokens.Orange.orange700
                }
            override val icon: Warning.Icon
                get() = object : Warning.Icon {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Orange.orange500
                }
        }

    override val danger: Danger
        get() = object : Danger {
            override val background: Danger.Background
                get() = object : Danger.Background {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Red.red100
                    override val secondary: ComposeColor
                        get() = PothosColorTokens.Red.red400
                    override val tertiary: ComposeColor
                        get() = PothosColorTokens.Red.red500
                }
            override val text: Danger.Text
                get() = object : Danger.Text {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Red.red500
                }
            override val border: Danger.Border
                get() = object : Danger.Border {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Red.red500
                }
            override val icon: Danger.Icon
                get() = object : Danger.Icon {
                    override val primary: ComposeColor
                        get() = PothosColorTokens.Red.red500
                }
        }
}