package com.safiribytes.newsapp.presentation.navgraph

import android.widget.SearchView
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.safiribytes.newsapp.presentation.bookmark.BookmarkScreen
import com.safiribytes.newsapp.presentation.bookmark.BookmarkViewModel
import com.safiribytes.newsapp.presentation.home.HomeScreen
import com.safiribytes.newsapp.presentation.home.HomeViewModel
import com.safiribytes.newsapp.presentation.onboarding.OnboardingScreen
import com.safiribytes.newsapp.presentation.onboarding.OnboardingViewModel
import com.safiribytes.newsapp.presentation.search.SearchScreen
import com.safiribytes.newsapp.presentation.search.SearchViewModel

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
                val viewModel: BookmarkViewModel = hiltViewModel()
                BookmarkScreen(state = viewModel.state.value, navigate = {})
            }
        }
    }
}