package ru.alox1d.startcomposeproject.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTest() {
    val listItems = listOf(
        NavItem("Favorite", Icons.Filled.Favorite),
        NavItem("Edit", Icons.Filled.Edit),
        NavItem("Delete", Icons.Filled.Delete),
    )

    ModalNavigationDrawer(
        drawerContent = {
            DrawerContent(listItems)
        }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "TopAppBar titlke")
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar {
                    listItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = true,
                            onClick = { },
                            icon = {
                                Icon(imageVector = item.icon, contentDescription = item.title)
                            },
                            label = {
                                Text(text = "Favourite label")
                            }
                        )
                    }
                }
            }
        ) {
            Text(
                modifier = Modifier.padding(it),
                text = "Scaffold"
            )
        }
    }
}

@Composable
private fun DrawerContent(listItems: List<NavItem>) {
    ModalDrawerSheet {
        listItems.forEachIndexed { index, navItem ->
            NavigationDrawerItem(
                label = { Text(text = navItem.title) },
                selected = true,
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.title)
                },
                onClick = { })
        }
    }
}

class NavItem(val title: String, val icon: ImageVector)
