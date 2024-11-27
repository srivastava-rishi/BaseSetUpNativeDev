import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rishi.basesetup.R

@Composable
fun RippleAnimation(
    modifier: Modifier = Modifier,
    nbPulsar: Int = 2,
    pulsarStartRadius: Float = 60f,
    pulsarEndRadius: Float = 120f,
    pulsarColor: Color = Color.Gray,
    animationDuration: Int = 400,
    animationDelay: Int = 500,
    startAnimation: Boolean = true
) {
    if (startAnimation) {
        // Create infinite transition for ripples
        val infiniteTransition = rememberInfiniteTransition(label = "")
        // Generate animations for each ripple
        val rippleAnimations = List(nbPulsar) { index ->
            val delay = index * animationDelay
            val radius = infiniteTransition.animateFloat(
                initialValue = pulsarStartRadius,
                targetValue = pulsarEndRadius,
                animationSpec = InfiniteRepeatableSpec(
                    animation = tween(durationMillis = animationDuration),
                    initialStartOffset = StartOffset(delay),
                    repeatMode = RepeatMode.Restart
                ), label = ""
            )

            val alpha = infiniteTransition.animateFloat(
                initialValue = 1f,
                targetValue = 0f,
                animationSpec = InfiniteRepeatableSpec(
                    animation = tween(durationMillis = animationDuration),
                    initialStartOffset = StartOffset(delay),
                    repeatMode = RepeatMode.Restart
                ), label = ""
            )
            radius to alpha
        }
        Canvas(
            modifier = modifier.wrapContentSize()
        ) {
            rippleAnimations.forEach { (radius, alpha) ->
                drawCircle(
                    color = pulsarColor,
                    radius = radius.value,
                    alpha = alpha.value,
                    style = Stroke(width = 2.dp.toPx())
                )
            }
        }
    }
}


@Composable
fun GrowingCircle(
    color: Color = Color(0xFF217858),
    onAnimationEnd: () -> Unit
) {
    var startAnimation by remember { mutableStateOf(false) }
    val screenHeightDp = LocalConfiguration.current.screenHeightDp

    val animatedRadius by animateFloatAsState(
        targetValue = if (startAnimation) screenHeightDp.toFloat() else 60f,
        animationSpec = tween(durationMillis = 848, easing = FastOutSlowInEasing),
        finishedListener = {
            onAnimationEnd()
        },
        label = ""
    )
    Box {
        LaunchedEffect(Unit) {
            startAnimation = true
        }
        Canvas(modifier = Modifier.wrapContentSize()) {
            drawCircle(
                color = color,
                radius = animatedRadius,
                center = center
            )
        }
    }
}


@Composable
fun StaticCircle(
    height: Float,
    color: Color = Color(0xFF217858),
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = color,
                radius = height,
                center = center
            )
        }
    }
}

@Composable
fun LottieAnimationStaticEnd(
    animationRes: Int
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationRes))

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            progress = 1f,
            modifier = Modifier.size(120.dp)
        )
    }
}


@Composable
fun LottieAnimationWithDefaultCompletion(
    animationRes: Int,
    onAnimationComplete: () -> Unit
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationRes))
    val animationState = animateLottieCompositionAsState(
        composition = composition,
        iterations = 1
    )
    var isAnimationCompleted by remember { mutableStateOf(false) }

    if (animationState.isAtEnd && !animationState.isPlaying && !isAnimationCompleted) {
        isAnimationCompleted = true
        onAnimationComplete()
    }

    LottieAnimation(
        composition = composition,
        progress = animationState.progress,
        modifier = Modifier.size(120.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun RippleAnimationPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        RippleAnimation(
            modifier = Modifier
                .padding(top = 8.dp - 2.dp),
            nbPulsar = 5,
            pulsarStartRadius = 60f,
            pulsarEndRadius = 120f,
            pulsarColor = Color(0xFFEDEDEE),
            animationDuration = 3000,
            animationDelay = 800,
            startAnimation = true
        )
    }
}
