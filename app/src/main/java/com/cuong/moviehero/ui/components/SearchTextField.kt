package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.ui.theme.MovieHeroTheme

val searchKeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search)

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.body1.plus(TextStyle(MaterialTheme.colors.onBackground)),
    keyboardOptions: KeyboardOptions = searchKeyboardOptions,
    shape: Shape = RoundedCornerShape(32.dp),
    placeholder: String = "",
    value: String = "",
    onValueChange: (String) -> Unit = {},
    onSearch: () -> Unit = {},
) {
    val keyboardActions = remember(key1 = onSearch) {
        KeyboardActions(onSearch = {
            onSearch()
        })
    }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background, shape = shape)
            .shadow(4.dp, shape = shape),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle.plus(TextStyle(MaterialTheme.colors.onBackground)),
        shape = shape,
        placeholder = {
            Text(
                text = placeholder,
                style = textStyle.copy(
                    color = MaterialTheme.colors.onBackground.copy(
                        0.6f
                    )
                ),
                fontStyle = FontStyle.Italic
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    MovieHeroTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            SearchTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                placeholder = "preview placeholder",
            )
            Spacer(modifier = Modifier.height(16.dp))
            SearchTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "preview value",
            )
        }
    }
}