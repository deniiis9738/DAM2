package com.example.mywhatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.mywhatsapp.ui.theme.MyWhatsAppTheme
import com.example.mywhatsapp.ui.theme.Teal500
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWhatsAppTheme {
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = { TopBar(scrollBehavior) },
                    floatingActionButton = { SmallFAB() }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = it.calculateTopPadding())
                    ) {
                        MyTabs()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(scrollBehavior: TopAppBarScrollBehavior) {

    TopAppBar(
        title = { Text(text = "MyWhatsApp", color = Color.White) },
        modifier = Modifier
            .fillMaxWidth(),
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.smallTopAppBarColors(Teal500),
        actions = {
            IconButton(
                onClick = {  },
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar",
                    tint = Color.White
                )
            }
            IconButton(
                onClick = {  },
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Compartir",
                    tint = Color.White
                )
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyTabs() {
    val pagerState = rememberPagerState(pageCount = {3})
    val scope = rememberCoroutineScope()
    var titles = listOf("Chats", "Novedades", "Llamadas")

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = Teal500,
            contentColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { scope.launch { pagerState.scrollToPage(index) } },
                    text = { Text(text = title)}
                )
            }
        }
    }

    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> Chats()
            1 -> Novedades()
            2 -> Llamadas()
        }
    }
}

@Composable
fun SmallFAB() {
    Box(
        modifier = Modifier
            .padding(start = 30.dp, top = 110.dp)
            .fillMaxSize()
            .offset(300.dp, 580.dp)
    ) {
        ExtendedFloatingActionButton(
            content = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "",
                    tint = Color.White
                )
            },
            onClick = {  },
            containerColor = Teal500,
            modifier = Modifier
                .size(60.dp)
        )
    }
}