package com.example.reservebites

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.reservebites.ui.theme.ReserveBitesTheme
import com.example.reservebites.ui.viewmodels.ForYouViewModel
import com.example.reservebites.ui.viewmodels.LoginViewModel
import com.example.reservebites.ui.viewmodels.RestaurantViewModel
import com.example.reservebites.ui.views.FavouritesView
import com.example.reservebites.ui.views.ForYouView
import com.example.reservebites.ui.views.LoginView
import com.example.reservebites.ui.views.RestaurantView
import com.example.reservebites.ui.views.SearchView

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReserveBitesTheme {
                val navController = rememberNavController()
                val loginViewModel = LoginViewModel()
                val forYouViewModel = ForYouViewModel()
                val restaurantViewModel = RestaurantViewModel()
                var stateBar by remember { mutableStateOf(false) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { if (stateBar) TopAppBarReserveBites(loginViewModel) },
                    bottomBar = { if (stateBar) BottomAppBarReserveBites(navController, loginViewModel) }
                ) {
                    Column(
                        modifier = Modifier.padding(top = it.calculateTopPadding())
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "LoginView"
                        ) {
                            composable("LoginView") {
                                LoginView(navController, loginViewModel)
                                stateBar = false
                            }
                            composable("ForYouView") {
                                ForYouView(navController, forYouViewModel)
                                stateBar = true
                            }
                            composable("FavouritesView") {
                                FavouritesView(navController, loginViewModel)
                            }
                            composable("SearchView") {
                                SearchView(navController, loginViewModel)
                            }
                            composable("RestaurantView/{restaurantName}") { backStackEntry ->
                                val restaurantName = backStackEntry.arguments?.getString("restaurantName")
                                val restaurantCard = forYouViewModel.restaurantList.value?.find { it.name == restaurantName }
                                if (restaurantCard != null) {
                                    RestaurantView(restaurantCard = restaurantCard, restaurantViewModel = restaurantViewModel)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarReserveBites(loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.topappbar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
            )
            Text(
                text = "ReserveBites",
                color = Color.White,
                fontSize = 35.sp,
                fontFamily = loginViewModel.getFontFamily("Tangerine"),
                fontWeight = FontWeight.Bold
            )
        }
        TopAppBar(
            title = {

            },
            modifier = Modifier
                .fillMaxWidth(),
            navigationIcon = {
                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Return",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(Color.Transparent),
            actions = {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "MoreVert",
                        tint = Color.White
                    )
                }
            }
        )
    }
}

@Composable
fun BottomAppBarReserveBites(navController: NavController, loginViewModel: LoginViewModel) {
    BottomAppBar(
        containerColor = Color.Gray
    ) {
        var selectedTab by rememberSaveable { mutableStateOf(0) }
        val icons = listOf(Icons.Default.Home, Icons.Default.Favorite, Icons.Default.Search)

        val destinations = listOf("ForYouView", "FavouritesView", "SearchView")

        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.Gray,
            contentColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            icons.forEachIndexed { index, icon ->
                Tab(
                    selected = selectedTab == index,
                    onClick = {
                        if (selectedTab != index) {
                            navController.navigate(destinations[index])
                            selectedTab = index
                        }
                    },
                    selectedContentColor = Color.Blue,
                    unselectedContentColor = Color.White
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null
                    )
                }
            }
        }
    }
}