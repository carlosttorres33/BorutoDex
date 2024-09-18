package com.carlostorres.borutodex.ui.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.carlostorres.borutodex.R
import com.carlostorres.borutodex.ui.theme.TOP_APP_BAR_HEIGHT
import com.carlostorres.borutodex.ui.theme.topAppBarBkgColor
import com.carlostorres.borutodex.ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchWidget(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
    focusRequester: FocusRequester
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT)
            .focusRequester(focusRequester = focusRequester),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topAppBarBkgColor
    ) {

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    text = "Search Here...",
                    color = Color.White,
                    modifier = Modifier.alpha(ContentAlpha.medium),
                )
            },
            singleLine = true,
            textStyle = TextStyle(
                color = MaterialTheme.colors.topAppBarContentColor
            ),
            leadingIcon = {
                Icon(
                    modifier = Modifier.alpha(
                        ContentAlpha.medium
                    ),
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.search_icon),
                    tint = MaterialTheme.colors.topAppBarContentColor
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()){
                            onTextChange("")
                        }else{
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close_icon),
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.topAppBarContentColor
            )
        )

    }

}