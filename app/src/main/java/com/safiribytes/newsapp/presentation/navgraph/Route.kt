package com.safiribytes.newsapp.presentation.navgraph

sealed class Route (
    val  route: String
) {
    object  OnboardingScreen: Route(route = "onBoardingScreen")
    object  HomeScreen: Route(route = "homeScreen")
    object  SearchScreen: Route(route = "SearchScreen")
    object  BookmarkScreen: Route(route = "bookmarkScreen")
    object  DetailScreen: Route(route = "detailScreen")
    object  AppStartNavigation: Route(route = "appStartNavigation")
    object  NewsNavigation: Route(route = "newsNavigation")
    object  NewsNavigationScreen: Route(route = "newsNavigationScreen")
}