package com.rishi.basesetup.screen

import android.content.Context
import android.content.pm.PackageManager
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat


@Composable
fun CallStateWithRuntimePermission() {
    val context = LocalContext.current
    val telephonyManager = remember {
        context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    }

    // State to track permission
    val permissionGranted = remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.READ_PHONE_STATE
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    if (permissionGranted.value) {
        Log.d("liom22", "CallStateWithRuntimePermission:  line ni 44")
        // Permission granted, listen to call state
        val callState = remember { mutableIntStateOf(telephonyManager.callState) }

        // Listener for call state changes
        val phoneStateListener = remember {
            object : PhoneStateListener() {
                override fun onCallStateChanged(state: Int, phoneNumber: String?) {
                    super.onCallStateChanged(state, phoneNumber)
                    callState.value = state
                }
            }
        }

        DisposableEffect(Unit) {
            telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
            onDispose {
                telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE)
            }
        }

        Log.d("liom22", "CallStateWithRuntimePermission:  line ni 66 ${callState.intValue}")

        // Display call state
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {}
            ) {
                Text(
                    fontSize = 29.sp,
                    text = when (callState.intValue) {
                        TelephonyManager.CALL_STATE_IDLE -> "Call State: Idle"
                        TelephonyManager.CALL_STATE_RINGING -> "Call State: Ringing"
                        TelephonyManager.CALL_STATE_OFFHOOK -> "Call State: Off Hook"
                        else -> "Call State: Unknown"
                    }
                )
            }
        }

    } else {
        Log.d("liom22", "CallStateWithRuntimePermission:  line ni 75")
        RequestPermission { granted ->
            permissionGranted.value = granted
        }
    }
}

@Composable
fun RequestPermission(onPermissionResult: (Boolean) -> Unit) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            onPermissionResult(isGranted)
        }
    )

    // UI for requesting permission
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Permission required to access call state.")
        Button(onClick = {
            launcher.launch(android.Manifest.permission.READ_PHONE_STATE)
        }) {
            Text("Grant Permission")
        }
    }
}
