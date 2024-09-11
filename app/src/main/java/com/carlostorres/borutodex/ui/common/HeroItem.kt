package com.carlostorres.borutodex.ui.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.carlostorres.borutodex.R
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.ui.home.components.RatingWidget
import com.carlostorres.borutodex.ui.navigation.ScreenRoutes
import com.carlostorres.borutodex.ui.theme.HERO_ITEM_HEIGHT
import com.carlostorres.borutodex.ui.theme.LARGE_PADDING
import com.carlostorres.borutodex.ui.theme.MEDIUM_PADDING
import com.carlostorres.borutodex.ui.theme.SMALL_PADDING
import com.carlostorres.borutodex.ui.theme.topAppBarContentColor
import com.carlostorres.borutodex.util.Constants

@Composable
fun HeroItem(
    modifier: Modifier = Modifier,
    hero: Hero,
    navController: NavHostController
) {

    Card(
        modifier = modifier
            .height(HERO_ITEM_HEIGHT)
            .clickable {
                navController
                    .navigate(
                        ScreenRoutes.Details.passHeroID(heroID = hero.id)
                    )
            },
        shape = RoundedCornerShape(LARGE_PADDING),
        elevation = CardDefaults.cardElevation(defaultElevation = SMALL_PADDING)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = "${Constants.BASE_URL}${hero.image}",
                contentDescription = stringResource(R.string.hero_image),
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )

            Surface(
                modifier = Modifier
                    .fillMaxHeight(0.4f)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                color = Color.Black.copy(alpha = 0.5f)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(MEDIUM_PADDING)
                ) {

                    Text(
                        text = hero.name,
                        color = MaterialTheme.colors.topAppBarContentColor,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = hero.about,
                        color = Color.White.copy(alpha = ContentAlpha.medium),
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

                    Row(
                        modifier = Modifier
                            .padding(SMALL_PADDING),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        RatingWidget(
                            modifier = Modifier.padding(end = SMALL_PADDING),
                            rating = hero.rating
                        )
                        
                        Text(
                            text = "(${hero.rating})",
                            textAlign = TextAlign.Center,
                            color = Color.White.copy(alpha = ContentAlpha.medium)
                        )

                    }

                }

            }

        }

    }

}

@Preview (showSystemUi = true)
@Composable
private fun HIP() {

    HeroItem(
        hero = Hero(
            id = 1,
            name = "Sasuke Uchiha",
            image = "",
            about = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            rating = 4.5,
            power = 100,
            month = "",
            day = "",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()
        ),
        navController = rememberNavController()
    )

}