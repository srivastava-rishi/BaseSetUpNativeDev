package com.rishi.basesetup.animation

import GrowingCircle
import LottieAnimationWithDefaultCompletion
import RippleAnimation
import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalInputModeManager
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rishi.basesetup.R
import com.rishi.basesetup.animation.common.PothosTheme
import com.rishi.basesetup.navigation.actions.PaymentScreenActions
import com.rishi.basesetup.ui.theme.paragraph
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs

/*

Phase1 :-

We will say :-

myChip -> circular box
payeeChip -> circular box

1. User who is sending the money myChip will come from the circular chip that is there behind payeeChip
2. myChip -> will be rotating like a box at 90 degree
3. after that my chip will slowly come
#.
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentAnimation(
    onAction: (paymentScreenActions: PaymentScreenActions) -> Unit
) {

    val screenHeightDp = LocalConfiguration.current.screenHeightDp.also {
        Log.d("testingHeight", "screenHeightDp 1st : $it ")
        Log.d("testingHeight", "screenHeightDp 1st in float: ${it.toFloat()} ")
    }

    Log.d("testingHeight", "PaymentAnimation: $screenHeightDp ")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Icon(
                            modifier = Modifier
                                .clickable {},
                            painter = painterResource(id = R.drawable.back_arrow_24px),
                            contentDescription = "Back Icon",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFFFFF)
                ),
            )
        }
    ) { innerPadding ->
        PaymentContent(
            modifier = Modifier.padding(innerPadding),
            onAction = onAction
        )
    }
}


@Composable
fun PaymentContent(
    modifier: Modifier,
    onAction: (paymentScreenActions: PaymentScreenActions) -> Unit,
) {

    val screenHeightDp = LocalConfiguration.current.screenHeightDp
    val middleHeight = screenHeightDp / 2

    // Animation states
    var startAnimation by remember { mutableStateOf(false) }
    var reset by remember { mutableStateOf(false) }
    var secondAnimationPhase by remember { mutableStateOf(false) }

    // Animatable values for animations
    val firstChipTranslation = remember { Animatable(0f) }
    val firstChipRotation = remember { Animatable(0f) }
    val secondChipTranslation = remember { Animatable(0f) }

    val firstChipSize = remember { Animatable(30f) }
    val originalDistance = 173f
    val lottie1 by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.speedline))

    val firstChipSecondTranslation = remember { Animatable(0f) }
    val secondChipSecondTranslation = remember { Animatable(0f) }

    // variables
    var firstAnimationCompleted by remember {
        mutableStateOf(false)
    }
    var secondAnimationCompleted by remember {
        mutableStateOf(false)
    }
    var startSpeedLineAnimation by remember {
        mutableStateOf(false)
    }

    var showSuccessScreen by remember {
        mutableStateOf(false)
    }

    var showGrowingEffect by remember {
        mutableStateOf(false)
    }

    // Reset animations on retrigger
    LaunchedEffect(reset) {
        if (reset) {
            // Reset values
            firstChipRotation.snapTo(0f)
            firstChipTranslation.snapTo(0f)
            secondChipTranslation.snapTo(0f)
            firstChipSize.snapTo(30f)
            startAnimation = false
            reset = false
            //
            firstAnimationCompleted = false
            secondAnimationCompleted = false
            //
            firstChipSecondTranslation.snapTo(0f)
            secondChipSecondTranslation.snapTo(0f)
            secondAnimationPhase = false
            showSuccessScreen = false
            showGrowingEffect = false
        }
    }

    // Animation effect8
    LaunchedEffect(startAnimation) {
        if (startAnimation) {
            launch {
                firstChipRotation.animateTo(
                    targetValue = 180f,
                    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
                )
            }
            launch {
                val secondChipTargetPosition = middleHeight.toFloat() - firstChipSize.targetValue
                // setting for second phase
                secondChipSecondTranslation.snapTo(secondChipTargetPosition)
                secondChipTranslation.animateTo(
                    targetValue = secondChipTargetPosition,
                    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
                )
                secondAnimationCompleted = true
            }
            launch {
                firstChipSize.animateTo(
                    targetValue = 60f,
                    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
                )
            }
            launch {
                val firstChipTargetPosition =
                    middleHeight.toFloat() - (originalDistance + firstChipSize.targetValue)
                // setting for second phase
                firstChipSecondTranslation.snapTo(firstChipTargetPosition)

                firstChipTranslation.animateTo(
                    targetValue = firstChipTargetPosition,
                    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
                )
                firstAnimationCompleted = true
            }
        }
    }

    LaunchedEffect(firstAnimationCompleted, secondAnimationCompleted) {
        startSpeedLineAnimation = firstAnimationCompleted && secondAnimationCompleted
        if (startSpeedLineAnimation) {
            // here add the actual delay
            delay(1000)
            startSpeedLineAnimation = false
            secondAnimationPhase = true
        }
    }

    LaunchedEffect(key1 = secondAnimationPhase) {
        if (secondAnimationPhase) {
            val firstChipJob = launch {
                firstChipSecondTranslation.animateTo(
                    targetValue = firstChipTranslation.value + 110f,
                    animationSpec = tween(durationMillis = 330, easing = LinearOutSlowInEasing)
                )
            }
            val secondChipJob = launch {
                secondChipSecondTranslation.animateTo(
                    targetValue = secondChipTranslation.value - 90f,
                    animationSpec = tween(durationMillis = 330, easing = LinearOutSlowInEasing)
                )
            }

            firstChipJob.join()
            secondChipJob.join()
            showSuccessScreen = true
        }
    }

    Column(
        modifier = modifier
            .padding(top = if (startAnimation) 0.dp else 24.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Parent Box to align both ripple-chip pairs initially
        Box(
            modifier = Modifier
                .offset(
                    y = firstChipSecondTranslation.value.dp + 35.dp
                ),
        ) {
            if (showGrowingEffect) {
                GrowingCircle(
//                    color = Color(0xFFFCE9E8)
                ) {
                    onAction(PaymentScreenActions.OpenSuccessScreen)
//                    onA
                }
            }
        }

        Box(
            modifier = Modifier
                .wrapContentSize()
                .alpha(if (!showGrowingEffect) 1f else 0f),
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                RippleAnimation(
                    modifier = Modifier.offset(y = firstChipTranslation.value.dp),
                    nbPulsar = 2,
                    pulsarStartRadius = firstChipSize.value,
                    pulsarEndRadius = 180f,
                    pulsarColor = Color(0xFFEDEDEE),
                    animationDuration = 2000,
                    animationDelay = 800,
                    startAnimation = startSpeedLineAnimation
                )

                CircularChip(
                    size = firstChipSize.value.dp,
                    background = Color(0xFFFFC8CE),
                    initials = "V",
                    roteAtY = if (startAnimation) firstChipRotation.value else 0f,
                    transY = if (startAnimation) {
                        if (secondAnimationPhase) {
                            firstChipSecondTranslation.value
                        } else {
                            firstChipTranslation.value
                        }
                    } else {
                        0f
                    }
                )
            }
            // Second Pair: RippleAnimation + CircularChip
            Box(
                contentAlignment = Alignment.Center
            ) {
                RippleAnimation(
                    modifier = Modifier.offset(y = secondChipTranslation.value.dp),
                    nbPulsar = 2,
                    pulsarStartRadius = firstChipSize.value,
                    pulsarEndRadius = 180f,
                    pulsarColor = Color(0xFFEDEDEE),
                    animationDuration = 2000,
                    animationDelay = 800,
                    startAnimation = startSpeedLineAnimation
                )

                CircularChip(
                    size = firstChipSize.value.dp,
                    transY = if (startAnimation) {
                        if (secondAnimationPhase) {
                            secondChipSecondTranslation.value
                        } else {
                            secondChipTranslation.value
                        }
                    } else {
                        0f
                    },
                    showThings = true
                )
            }
        }

        Box(
            modifier = Modifier
                .offset(
                    y = firstChipTranslation.value.dp - firstChipSize.value.dp
                )
                .wrapContentSize(),
        ) {
            if (startSpeedLineAnimation) {
                LottieAnimation(
                    lottie1,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier
                        .width(120.dp)
                        .height(originalDistance.dp + firstChipSize.value.dp)
                )
            }
        }

        // successPart
        Box(
            modifier = Modifier
                .offset(
                    y = firstChipSecondTranslation.value.dp - 58.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            if (showSuccessScreen) {
                RippleAnimation(
                    nbPulsar = 2,
                    pulsarStartRadius = firstChipSize.value,
                    pulsarEndRadius = 180f,
                    pulsarColor = Color(0xFFEDEDEE),
                    animationDuration = 2000,
                    animationDelay = 800,
                    startAnimation = !showGrowingEffect
                )
                LottieAnimationWithDefaultCompletion(
                    animationRes = R.raw.green_success,
                    onAnimationComplete = {
                        showGrowingEffect = true
                    }
                )

            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier.padding(bottom = 12.dp),
                onClick = { startAnimation = true }
            ) {
                Text(text = "Start")
            }
            Button(
                onClick = { reset = true }
            ) {
                Text(text = "Reset")
            }
        }
    }
}


@Composable
fun CircularChip(
    initials: String = "A",
    size: Dp = 30.dp,
    background: Color = Color(0xFFAFE9D4),
    roteAtY: Float = 0f,
    transY: Float = 0f,
    backFaceColor: Color = Color(0xFFEBC9FF),
    showThings: Boolean = false
) {
    Log.d("rotationDegree", "CircularChip:  $roteAtY")
    val borderThickness = if (roteAtY in 80f..94f) 4.dp else 0.dp
    Box(
        modifier = Modifier
            .size(size)
            .graphicsLayer {
                rotationY = -roteAtY
                translationY = transY.dp.toPx()
            }
            .background(
                color = if (roteAtY > 0 && roteAtY <= 78) {
                    backFaceColor
                } else {
                    background
                },
                shape = CircleShape
            )
    ) {
        if (showThings || roteAtY > 94) {
            Image(
                painter = painterResource(id = R.drawable.ic_favourite_payee_bg),
                contentDescription = null
            )
            Text(
                text = initials,
                style = MaterialTheme.typography.paragraph,
                color = Color(0xFF34353A),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Composable
fun SuccessCircle(
    size: Dp = 60.dp,
    roteAtY: Float = 0f,
    backgroundColor: Color = Color(0xFF144835)
) {
    Box(
        modifier = Modifier
            .size(size)
            .graphicsLayer {
                rotationY = -roteAtY
            }
            .background(
                color = backgroundColor,
                shape = CircleShape
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_action_accept_light),
            contentDescription = "check",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
//    Column(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        SuccessCircle()
//    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .height(80.dp)
                .fillMaxWidth()
                .background(Color.Black)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "liobnrestdyfugihjobhjklhbvaSzdxfcgvhbjnkmlmjnhbgvfcdrxszeaZsxdfcgvhbjgvfcdxrszeazsxdcfvghbjnkm",
                color = Color.White
            )
        }
    }
}
