package com.carlostorres.borutodex.ui.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester

@Composable
fun SearchTopBar(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
    focusRequester: FocusRequester
) {

    SearchWidget(
        modifier = modifier,
        text = text,
        onTextChange = {
            onTextChange(it)
        },
        onSearchClicked ={
            onSearchClicked(it)
        },
        onCloseClicked = {
            onCloseClicked()
        },
        focusRequester = focusRequester
    )
    
}