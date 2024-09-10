package com.carlostorres.borutodex.ui.home.components

import android.content.res.Configuration
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.carlostorres.borutodex.R
import com.carlostorres.borutodex.ui.theme.topAppBarBkgColor
import com.carlostorres.borutodex.ui.theme.topAppBarContentColor
import com.carlostorres.borutodex.ui.theme.topAppBarIconColor

//@Preview//(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeTopBar(
    onSearchClicked : () -> Unit //= {}
) {

    TopAppBar(
        title = {
            Text(
                text = "Explore",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBkgColor,
        actions = {
            IconButton(
                onClick = { onSearchClicked() }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon),
                    tint = MaterialTheme.colors.topAppBarIconColor
                )
            }
        }
    )
}