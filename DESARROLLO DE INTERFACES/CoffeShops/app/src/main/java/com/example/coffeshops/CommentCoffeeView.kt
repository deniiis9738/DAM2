package com.example.coffeshops

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeshops.ui.theme.Pink100
import com.example.coffeshops.ui.theme.Pink300
import com.example.coffeshops.ui.theme.alviaregular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentCoffeeView(title: String) {
    var showMenu by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<DataShops?>(null) }
    val rvState = rememberLazyStaggeredGridState()
    val comments = getCommentCoffeeShops()
    val showButton by remember {
        derivedStateOf {
            rvState.firstVisibleItemScrollOffset > 0
        }
    }

    Column {
        TopAppBar(
            title = { Text(text = "Coffee") },
            modifier = Modifier
                .fillMaxWidth(),
            navigationIcon = {
                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(Pink300),
            actions = {
                IconButton(
                    onClick = { showMenu = !showMenu },
                ) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "MoreVert",
                    )
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false },
                    Modifier.width(150.dp)
                ) {
                    DropdownMenuItem(
                        onClick = { showMenu },
                        text = { Text(text = "Compartir") },
                        leadingIcon = { Icon(imageVector = Icons.Filled.Share, contentDescription = "Compartir") }
                    )
                    DropdownMenuItem(
                        onClick = { showMenu },
                        text = { Text(text = "Álbum") },
                        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Álbum") }
                    )
                }
            }
        )
        Text(
            text = title,
            fontSize = 38.sp,
            fontFamily = alviaregular,
            modifier = Modifier.padding(10.dp),
        )
        LazyVerticalStaggeredGrid(
            state = rvState,
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.weight(2.5f),
            content = {
                items(comments) { comment ->
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        colors = CardDefaults.cardColors(Pink100)
                    ){
                        Text(
                            text = comment,
                            fontSize = 25.sp,
                            fontFamily = alviaregular,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun getCommentCoffeeShops(): List<String> {
    val dataComments = listOf(
        "Muy bueno",
        "Malísimo",
        "Horrendo",
        "Fantástico",
        "Muy bueno",
        "Malísimo",
        "Horrendo",
        "Fantástico",
        "Muy bueno",
        "Malísimo",
        "Horrendo",
        "Fantástico",
        "Muy bueno",
        "Malísimo",
        "Horrendo",
        "Fantástico",
        "Muy bueno",
        "Malísimo",
        "Horrendo",
        "Fantástico",
    )
    return dataComments
}