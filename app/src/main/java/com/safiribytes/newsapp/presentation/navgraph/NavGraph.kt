package com.safiribytes.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.safiribytes.newsapp.presentation.bookmark.BookmarkScreen
import com.safiribytes.newsapp.presentation.bookmark.BookmarkViewModel
import com.safiribytes.newsapp.presentation.news_navigator.NewsNavigator
import com.safiribytes.newsapp.presentation.onboarding.OnboardingScreen
import com.safiribytes.newsapp.presentation.onboarding.OnboardingViewModel

@Composable
fun NavGraph(
    startDestination: String
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination ){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnboardingScreen.route
        ) {
            composable(
                route = Route.OnboardingScreen.route
            ) {
                val viewModel: OnboardingViewModel = hiltViewModel()
                OnboardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
            ) {
            composable(route = Route.NewsNavigationScreen.route) {
//                val viewModel: BookmarkViewModel = hiltViewModel()
//                BookmarkScreen(state = viewModel.state.value, navigateToDetails = {})
                NewsNavigator()
            }
        }
    }
}