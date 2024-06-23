package com.safiribytes.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.safiribytes.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

var pages = listOf(
    Page(
        title = "Page 1",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
        image = R.drawable.onboarding1
    ),

    Page(
        title = "Page 2",
        description = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
        image = R.drawable.onboarding2
    ),

    Page(
        title = "Page 3",
        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. ",
        image = R.drawable.onboarding3
    )
)
