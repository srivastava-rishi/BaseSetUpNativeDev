//package com.rishi.basesetup.screen.test
//
//import android.util.Log
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.DropdownMenu
//import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.rishi.basesetup.R
//import com.rishi.basesetup.navigation.actions.TestScreenActions
//import com.rishi.basesetup.ui.theme.black_60
//import kotlin.math.log
//
//
//@Composable
//fun TestScreen(
//    onAction: (homeScreenActions: TestScreenActions) -> Unit
//) {
//    TestScreenContent()
//}
//
//@Composable
//private fun TestScreenContent(
//    modifier: Modifier = Modifier
//) {
//    //var count = 0
//    var count by remember {
//        mutableIntStateOf(0)
//    }
//
//    var openedOrNot by remember {
//        mutableStateOf(false)
//    }
//    var selected by remember {
//        mutableStateOf("+91")
//    }
//
//    val usernames = listOf("+91", "+92", "+64", "+11", "+45")
//
//
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .background(black_60)
//            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Box {
//            Row(
//                modifier = Modifier
//                    .background(Color.White, shape = RoundedCornerShape(80.dp))
//                    .padding(12.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Icon(
//                    modifier = Modifier.clickable {
//                        openedOrNot = true
//                    },
//                    painter = painterResource(id = R.drawable.ic_hexagon_tick),
//                    contentDescription = null
//                )
//                Spacer(modifier = Modifier.size(4.dp))
//                Text(text = selected)
//            }
//
//            DropdownMenu(
//                expanded = openedOrNot,
//                onDismissRequest = {
//                }) {
//                for (i in 0..usernames.size - 1) {
//                    DropdownMenuItem(
//                        text = {
//                            Text(text = usernames.get(i))
//                        },
//                        onClick = {
//                            openedOrNot = false
//                            selected = usernames[i]
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun TestScreenPreview() {
////    TestScreenContent(modifier = Modifier)
//
//    Column(
//        modifier = Modifier.fillMaxSize()
//    ) {
//
//        val demoItems = listOf(
//            "+91" to "🇮🇳",
//            "+1" to "🇺🇸",
//            "+44" to "🇬🇧",
//            "+61" to "🇦🇺"
//        )
//
//        CountryCodeDropdown(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            items = demoItems,
//            defaultSelected = "+91" to "🇮🇳"
//        ) { selectedItem ->
//            println("Selected country code: $selectedItem")
//        }
//    }
//}
//
//
//@Composable
//fun CountryCodeDropdown(
//    modifier: Modifier = Modifier,
//    items: List<Pair<String, String>> = listOf(
//        "+91" to "🇮🇳",
//        "+1" to "🇺🇸",
//        "+44" to "🇬🇧",
//        "+61" to "🇦🇺"
//    ),
//    defaultSelected: Pair<String, String> = "+91" to "🇮🇳",
//    onItemSelected: (String) -> Unit = {}
//) {
//    var isDropdownExpanded by remember { mutableStateOf(false) }
//    var selectedItem by remember { mutableStateOf(defaultSelected) }
//
//    Box(
//        modifier = modifier
//            .border(1.dp, Color.Gray, shape = RoundedCornerShape(80.dp))
//            .background(Color.Transparent, shape = RoundedCornerShape(80.dp))
//    ) {
//        Row(
//            modifier = Modifier
//                .clickable { isDropdownExpanded = true }
//                .padding(horizontal = 16.dp, vertical = 12.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = selectedItem.second, style = MaterialTheme.typography.body1, modifier = Modifier.padding(end = 8.dp))
//            Text(text = selectedItem.first, style = MaterialTheme.typography.body1)
//            Spacer(modifier = Modifier.width(8.dp))
//            Icon(
//                painter = painterResource(id = R.drawable.ic_arrow_down),
//                contentDescription = "Dropdown Icon",
//                modifier = Modifier.size(16.dp)
//            )
//        }
//
//        DropdownMenu(
//            expanded = isDropdownExpanded,
//            onDismissRequest = { isDropdownExpanded = false }
//        ) {
//            items.forEach { item ->
//                DropdownMenuItem(
//                    text = {
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Text(text = item.second, style = MaterialTheme.typography.body1, modifier = Modifier.padding(end = 8.dp))
//                            Text(text = item.first)
//                        }
//                    },
//                    onClick = {
//                        isDropdownExpanded = false
//                        selectedItem = item
//                        onItemSelected(item.first)
//                    }
//                )
//            }
//        }
//    }
//}
