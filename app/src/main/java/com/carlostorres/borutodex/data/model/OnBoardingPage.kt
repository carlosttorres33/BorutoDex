package com.carlostorres.borutodex.data.model

import androidx.annotation.DrawableRes
import com.carlostorres.borutodex.R

sealed class OnBoardingPage (
    @DrawableRes
    val image : Int,
    val title : String,
    val description : String
){

    object First : OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greetings",
        description = "Are you a Boruto Fan? Cus if You are then we have a great news for u!"
    )
    object Second : OnBoardingPage(
        image = R.drawable.explore,
        title = "Explore",
        description = "Find your favorite heroes and learn some of the things that you didn´t know about."
    )
    object Third : OnBoardingPage(
        image = R.drawable.power,
        title = "Power",
        description = "Check out your heroe´s power and see how much are they strong comparing to others."
    )


}