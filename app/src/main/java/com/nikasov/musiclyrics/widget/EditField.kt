package com.nikasov.musiclyrics.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EditField(
    label: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = { }
) {
    Box(modifier = modifier.fillMaxWidth()) {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            singleLine = true,
            label = { Text(text = label) },
            onValueChange = {
                text = it
                onValueChange(it)
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun EditFieldPreview() {
    EditField("Text")
}