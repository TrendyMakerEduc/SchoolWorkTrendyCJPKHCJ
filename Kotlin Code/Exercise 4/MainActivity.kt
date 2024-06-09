package com.example.favourite_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.favourite_list.ui.theme.Favourite_ListTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Favourite_ListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FavoriteScreen()
                }
            }
        }
    }
}

@Composable
fun FavoriteList(favoriteItems: List<FavoriteItem>, onItemClicked: (Int) -> Unit) {
    LazyColumn {
        items(favoriteItems.size) { index ->
            val item = favoriteItems[index]
            FavoriteListItem(item = item, onClick = { onItemClicked(index) })
        }
    }
}



@Composable
fun FavoriteListItem(item: FavoriteItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick), // Set onClick listener here
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageResource),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = item.title,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = item.description,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.Gray
                )

            }
        }
    }
}

@Composable
fun FavoriteScreen() {
    val favoriteItems = listOf(
        FavoriteItem(
            imageResource = R.drawable.programming,
            title = "Programming",
            description = "The amount of programming I do makes me fulfilled at the end of each day it is done."
        ),
        FavoriteItem(
            imageResource = R.drawable.guitar,
            title = "Playing Guitar",
            description = "Chords and even playing solos make me feel like I control the music"
        ),
        FavoriteItem(
            imageResource = R.drawable.basketball,
            title = "Basketball",
            description = "A three point shot always is a great time. Especially when you are playing a game called 21, whoever gets to 21 first, wins."
        ),
        FavoriteItem(
            imageResource = R.drawable.fishing,
            title = "Fishing",
            description = "Fishing, ahh, a classic. The fight is always exhilarating, and the best part about keeping a fish, is turning it into fish cakes!"
        ),
        FavoriteItem(
            imageResource = R.drawable.videogames,
            title = "Video Games",
            description = "Video games are always great in the evening. A game after supper of something like Mario Tennis makes a very fun multiplayer experience, that everyone can join in on."
        )
    )

    var selectedListItem by remember { mutableStateOf<FavoriteItem?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            FavoriteList(favoriteItems = favoriteItems) { index ->
                selectedListItem = favoriteItems[index]
            }
        }

        selectedListItem?.let { selectedItem ->
            val index = favoriteItems.indexOf(selectedItem)
            val locationAndCost = getLocationAndCost(index)
            PanelWithLocAndCost(item = locationAndCost)
        }
    }
}




@Composable
fun getLocationAndCost(index: Int): locationAndCost {

    return when (index) {
        0 -> locationAndCost(
            cost = "500-1200$ average,",
            location = "Staples, Radio Shack, Computer Tech Shops"
        )
        1 -> locationAndCost(
            cost = "200-600$ average,",
            location = "G and G music, travelling sales online"
        )
        2 -> locationAndCost(
            cost = "5-20$ average,",
            location = "Canadian Tire, Walmart, Superstore, sports shops"
        )
        3 -> locationAndCost(
            cost = "50-600$ average, depending on the fish",
            location = "Canadian Tire, Walmart, Bass Pro Shop, Outdoors Sports shops"
        )
        4 -> locationAndCost(
            cost = "20-80$ average,",
            location = "Staples, Radio Shack, Computer Tech Shops, Walmart, Superstore, etc."
        )
        else -> locationAndCost("", "")
    }
}


@Composable
fun PanelWithLocAndCost(item : locationAndCost){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)

    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ){
            Text(
                text = "Location: " + item.location,
                fontSize = 20.sp,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Cost: " + item.cost,
                fontSize = 16.sp,
                style = MaterialTheme.typography.displaySmall,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun FavoriteLocationsReturnedValue(): Int {
    val favoriteItems = listOf(
        locationAndCost(
            cost = "500-1200$ average,",
            location = "Staples, Radio Shack, Computer Tech Shops"
        ),
        locationAndCost(
            cost = "200-600$ average,",
            location = "G and G music, travelling sales online"
        ),
        locationAndCost(
            cost = "5-20$ average,",
            location = "Canadian Tire, Walmart, Superstore, sports shops"
        ),
        locationAndCost(
            cost = "50-600$ average, depending on the fish",
            location = "Canadian Tire, Walmart, Bass Pro Shop, Outdoors Sports shops"
        ),
        locationAndCost(
            cost = "20-80$ average,",
            location = "Staples, Radio Shack, Computer Tech Shops, Walmart, Superstore, etc."
        )
    )

    FavoriteLocations(locationsAndCosts = favoriteItems)
    return favoriteItems.size
}

@Composable
fun FavoriteLocations(locationsAndCosts: List<locationAndCost>) {
    val numberOfRows = locationsAndCosts.size / 2
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(locationsAndCosts) { item ->
                PanelWithLocAndCost(item = item)
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height((numberOfRows * 200).dp) // Adjust the height as needed
                .align(Alignment.BottomCenter)
        )
    }
}

data class FavoriteItem(val imageResource: Int, val title: String, val description: String)
data class locationAndCost( val location: String, val cost: String)


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Favourite_ListTheme {
        FavoriteScreen()
    }
}