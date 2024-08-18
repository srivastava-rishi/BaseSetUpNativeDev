package com.rishi.basesetup.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.rishi.basesetup.ui.theme.captionDefault
import com.rishi.basesetup.ui.theme.captionLink
import com.rishi.basesetup.ui.theme.disabledBgColor
import com.rishi.basesetup.ui.theme.disabledStrokeColor
import com.rishi.basesetup.ui.theme.errorColor
import com.rishi.basesetup.ui.theme.labelColor
import com.rishi.basesetup.ui.theme.placeHolderColor
import com.rishi.basesetup.ui.theme.strokeFilledColor
import com.rishi.basesetup.ui.theme.strokeUnfilledColor
import com.rishi.basesetup.ui.theme.textColor
import com.rishi.basesetup.ui.theme.textFieldStrokeFocused
import com.rishi.basesetup.ui.theme.textFieldStrokeNotFocused
import com.rishi.basesetup.ui.theme.textFieldTextColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.regex.Pattern

const val SPECIAL_CHARACTER_REGEX_TEXT = "[!@#\$%,&*()_+=|<>?{}/\\\\~-]"
const val SPECIAL_CHARACTER_REGEX_NUMERICAL = "[!@#\$%,.&*()_+=|<>?{}/\\\\~-]"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PBTextField(
    modifier: Modifier = Modifier,
    textFieldUiState: TextFieldUiState = TextFieldUiState(),
    singleLine: Boolean = true,
    maxChar: Int = 100,
    label: String = "",
    link: String = "",
    visualTransformation: VisualTransformation? = null,
    onValueChange: (String) -> Unit = {},
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeHolder: @Composable (() -> Unit) = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = keyboardType,
        imeAction = imeAction
    ),
    textStyle: TextStyle = LocalTextStyle.current,
    allowSpecialCharacters: Boolean = true,
    onLinkClick: () -> Unit = {}
) {
    var focused by remember {
        mutableStateOf(false)
    }

    val counter = textFieldUiState.value.length
    val keyboardController = LocalSoftwareKeyboardController.current
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    val coroutineScope = rememberCoroutineScope()

    Column {
        Box(
            modifier = modifier
                .border(
                    border = BorderStroke(
                        getStrokeWidth(focused = focused),
                        getStrokeColor(focused = focused, textFieldUiState = textFieldUiState)
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                .fillMaxWidth()
                .defaultMinSize(minHeight = 64.dp)
                .bringIntoViewRequester(bringIntoViewRequester)
                .background(
                    if (textFieldUiState.disable) MaterialTheme.colorScheme.disabledBgColor else Color.Transparent,
                    shape = RoundedCornerShape(12.dp)
                )
                .onFocusEvent { focusState ->
                    if (focusState.isFocused) {
                        coroutineScope.launch {
                            delay(100)
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                }
        ) {
            val specialCharacterMatcher = when (keyboardType) {
                KeyboardType.Number -> Pattern.compile(SPECIAL_CHARACTER_REGEX_NUMERICAL)
                else -> Pattern.compile(SPECIAL_CHARACTER_REGEX_TEXT)
            }
            TextField(
                singleLine = singleLine,
                enabled = !textFieldUiState.disable,
                value = textFieldUiState.value,
                keyboardOptions = keyboardOptions,
                visualTransformation = if (keyboardType == KeyboardType.NumberPassword || keyboardType == KeyboardType.Password) {
                    PasswordVisualTransformation()
                } else {
                    visualTransformation ?: VisualTransformation.None
                },
                onValueChange = {
                    if (it.length <= maxChar) {
                        if (!allowSpecialCharacters) {
                            if (!specialCharacterMatcher.matcher(it).find()) {
                                if (KeyboardType.Number == keyboardType) {
                                    onValueChange(it.trim())
                                } else {
                                    onValueChange(it)
                                }
                            }
                        } else {
                            onValueChange(it)
                        }
                    }
                },
                placeholder = placeHolder,
                label = textFieldLabel(label),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.textFieldTextColor,
                    unfocusedTextColor = MaterialTheme.colorScheme.textFieldTextColor,
                    disabledTextColor = MaterialTheme.colorScheme.textFieldTextColor,
                    focusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedPlaceholderColor = placeHolderColor,
                    unfocusedPlaceholderColor = placeHolderColor,
                    errorPlaceholderColor = placeHolderColor,
                    disabledLabelColor = labelColor,
                    focusedLabelColor = labelColor,
                    unfocusedLabelColor = labelColor,
                    cursorColor = textColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .defaultMinSize(64.dp)
                    .clickable(textFieldUiState.clickable, onClick = {})
                    .focusRequester(FocusRequester())
                    .onFocusChanged {
                        focused = it.isFocused
                    },
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                textStyle = textStyle,
                keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
            )
            if (link.isNotEmpty()) {
                Text(
                    text = link,
                    style = MaterialTheme.typography.captionLink,
                    color = MaterialTheme.colorScheme.textFieldTextColor,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp)
                        .clickable(onClick = onLinkClick)
                )
            }
        }
        if (textFieldUiState.drawRow()) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 16.dp, end = 16.dp)
            ) {
                if (textFieldUiState.isAssistiveEnabled()) {
                    Text(
                        text = textFieldUiState.assistiveText,
                        style = MaterialTheme.typography.bodySmall,
                        color = getCaptionColor(textFieldUiState),
                        modifier = Modifier.weight(0.8F)
                    )
                }
                if (textFieldUiState.counterTextEnabled) {
                    Text(
                        text = "$counter/$maxChar",
                        modifier = Modifier.weight(0.2F),
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.bodySmall,
                        color = getCaptionColor(textFieldUiState)
                    )
                }
            }
        }
    }
    AnimatedVisibility(visible = textFieldUiState.error && textFieldUiState.errorText.isNotEmpty()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = textFieldUiState.errorText,
                style = MaterialTheme.typography.captionDefault.copy(color = errorColor)
            )
        }
    }
}

private fun getCaptionColor(textFieldUiState: TextFieldUiState) =
    if (textFieldUiState.error) errorColor else labelColor

@Composable
private fun getStrokeColor(focused: Boolean, error: Boolean = false) =
    if (error) {
        errorColor
    } else {
        if (focused) MaterialTheme.colorScheme.textFieldStrokeFocused else MaterialTheme.colorScheme.textFieldStrokeNotFocused
    }

private fun getStrokeColor(textFieldUiState: TextFieldUiState, focused: Boolean) =
    if (textFieldUiState.error) {
        errorColor
    } else if (textFieldUiState.disable) {
        disabledStrokeColor
    } else {
        if (focused) strokeFilledColor else strokeUnfilledColor
    }

fun getStrokeWidth(focused: Boolean) =
    if (focused) {
        2.dp
    } else {
        1.dp
    }

@Composable
private fun textFieldLabel(label: String = ""): @Composable (() -> Unit)? {
    return if (label.isNotEmpty()) {
        { Text(label) }
    } else {
        null
    }
}

data class TextFieldUiState(
    var value: String = "",
    var error: Boolean = false,
    var disable: Boolean = false,
    var assistiveText: String = "",
    var counterTextEnabled: Boolean = false,
    var errorText: String = "",
    var clickable: Boolean = true,
) {
    fun isAssistiveEnabled() = assistiveText.isNotEmpty() && !error
    fun drawRow() = isAssistiveEnabled() || counterTextEnabled
}