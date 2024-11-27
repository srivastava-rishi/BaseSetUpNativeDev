import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.rishi.basesetup.R
import com.rishi.basesetup.animation.common.PothosTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SuccessPayment() {

    val systemUiController = rememberSystemUiController()

    val screenHeightDp = LocalConfiguration.current.screenHeightDp
    val topPadding = 80.dp

    systemUiController.setStatusBarColor(
        color = Color.Transparent,
        darkIcons = true
    )

    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }

    // Animatables for transition
    val yOffSet = remember { Animatable(screenHeightPx) }
    val yOffSet2 = remember { Animatable(screenHeightPx / 2) }
    val alphaValue = remember { Animatable(1f) }
    val backGroundOffSet = remember {
        Animatable(screenHeightPx / 2)
    }
    val scale = remember { Animatable(2f) }
    val topPaddingPx = with(density) { topPadding.toPx() }


    var showMiddle by remember {
        mutableStateOf(true)
    }

    // Launch animations
    LaunchedEffect(Unit) {
        delay(2000)
        showMiddle = false
        launch {
            backGroundOffSet.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 2000)
            )
        }

        launch {
            yOffSet2.animateTo(
                targetValue = topPaddingPx,
                animationSpec = tween(durationMillis = 2000)
            )
        }

        launch {
            alphaValue.animateTo(0f, animationSpec = tween(durationMillis = 1000))
        }

        launch {
            yOffSet.animateTo(
                targetValue = topPaddingPx,
                animationSpec = tween(durationMillis = 2000)
            )
        }
        launch {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 2000)
            )
        }
    }

    // Main Box container
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Circle and Lottie Animation
        if (showMiddle) {
            Box {
                StaticCircle(
                    height = screenHeightDp.toFloat()
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF))
                    .drawWithCache {
                        onDrawBehind {
                            val radius = size.width / 1f
                            val centerX = size.width / 2f
                            val curveHeight = radius + 50.dp.toPx()

                            val transitionColor = lerp(
                                Color(0xFF144835),
                                Color(0xFF217858),
                                1f - alphaValue.value
                            )
                            drawCircle(
                                color = Color(0xFFE7F4ED),
                                radius = radius + 20.dp.toPx(),
                                center = Offset(centerX, curveHeight),
                            )
                            drawCircle(
                                color = transitionColor,
                                radius = radius,
                                center = Offset(centerX, curveHeight)
                            )
                        }
                    }
                    .graphicsLayer {
                        translationY = yOffSet.value.dp.toPx()
                        scaleX = scale.value
                        scaleY = scale.value
                    }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        translationY = yOffSet.value.dp.toPx()
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Paid in flash",
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "12:00PM, 02 Feb ‘24",
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                BriefCard(
                    modifier = Modifier.graphicsLayer {
                        scaleX = scale.value
                        scaleY = scale.value
                    }
                )
            }
        }

        // Uncommented code, drawing the second circle and transitioning
        Box(
            modifier = Modifier
                .graphicsLayer {
                    translationY = yOffSet2.value
                }
        ) {
            LottieAnimationStaticEnd(R.raw.green_success)
        }
    }
}


@Composable
fun BriefCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(top = 60.dp)
            .widthIn(max = 268.dp)
            .background(color = Color(0xFFF6F6F6), shape = RoundedCornerShape(24.dp))
            .border(
                width = 2.dp,
                color = PothosTheme.colors.neutral.border.primary,
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .widthIn(max = 268.dp)
                .alpha(0.5f)
                .clip(RoundedCornerShape(24.dp)),
            painter = painterResource(id = R.drawable.txn_detail_success_top_wave_bg),
            contentScale = ContentScale.Inside,
            contentDescription = "topWaveBackground"
        )
        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .alpha(0.5f)
                .widthIn(max = 268.dp)
                .clip(RoundedCornerShape(24.dp)),
            painter = painterResource(id = R.drawable.bottom_wave),
            contentScale = ContentScale.Inside,
            contentDescription = "bottomWaveBackground"
        )
        Column(
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    start = 21.dp,
                    end = 21.dp,
                    bottom = 16.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "MV Amal",
                    style = PothosTheme.typography.bodyMediumHighEmphasis,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = PothosTheme.colors.neutral.text.highEmphasis
                )
                if (true) {
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_hexagon_tick),
                        contentDescription = "verified",
                        modifier = Modifier.size(12.dp),
                        alignment = Alignment.Center
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "amalkumar@okicici",
                style = PothosTheme.typography.bodySmallLowEmphasis,
                textAlign = TextAlign.Center,
                color = PothosTheme.colors.neutral.text.mediumEmphasis
            )
            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.height(16.dp))
            if (true) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .defaultMinSize(minHeight = 34.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Txn ID: 039898378752432",
                        style = PothosTheme.typography.bodyTinyLowEmphasis,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = PothosTheme.colors.neutral.text.lowEmphasis
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_copy_upi_id),
                        contentDescription = "copy",
                        modifier = Modifier
                            .clickable {
                            }
                            .size(16.dp),
                        alignment = Alignment.Center
                    )
                }
            }
            Divider(color = PothosTheme.colors.neutral.border.secondary)
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .defaultMinSize(minHeight = 40.dp)
                    .clickable {
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "View Details",
                    style = PothosTheme.typography.bodySmallLink,
                    textAlign = TextAlign.Center,
                    color = PothosTheme.colors.neutral.text.highEmphasis
                )
            }
        }
    }
}


@Composable
fun FailurePayment() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color(0xFFFFFFFF))
            .drawWithCache {
                onDrawBehind {
                    val radius = size.width / 1f
                    val centerX = size.width / 2f
                    val curveHeight = radius - size.height * 0.6f
                    drawCircle(
                        color = Color(0xFFE7F4ED).copy(0.4f),
                        radius = radius + 20.dp.toPx(),
                        center = Offset(centerX, curveHeight)
                    )
                    drawCircle(
                        color = Color(0xFFFCE9E8),
                        radius = radius,
                        center = Offset(centerX, curveHeight)
                    )
                }
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_txn_fail_icon),
                contentDescription = "check",
                modifier = Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Paid in flash",
                color = PothosTheme.colors.neutral.text.highEmphasis,
                style = PothosTheme.typography.bodyMediumHighEmphasis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "12:00PM, 02 Feb ‘24",
                color = PothosTheme.colors.neutral.text.highEmphasis,
                style = PothosTheme.typography.bodyTinyLowEmphasis
            )
            Spacer(modifier = Modifier.height(8.dp))
            BriefCard()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    FailurePayment()
}