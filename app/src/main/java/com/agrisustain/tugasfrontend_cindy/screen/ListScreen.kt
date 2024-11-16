package com.agrisustain.tugasfrontend_cindy.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.tugasfrontend_cindy.data.DataDummy
import com.agrisustain.tugasfrontend_cindy.model.Makeup
import com.agrisustain.tugasfrontend_cindy.navigation.Screen

@Composable
fun PopularMakeupItem (
    makeup: Makeup,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(makeup.id)
        }
    ) {
        makeup.gambar?.let { painterResource(id = it) }?.let {
            Image(
                painter = it,
                contentDescription = makeup.nama, modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(150.dp)
            )
        }
        Text(
            text = makeup.nama,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(150.dp),
            maxLines = 1
        )
    }
}

@Composable
fun AllMakeupItem (
    makeup: Makeup,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClicked(makeup.id) }
    ) {
        makeup.gambar?.let { painterResource(id = it) }?.let {
            Image(
                painter = it,
                contentDescription = makeup.nama,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(80.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = makeup.nama, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = makeup.deskripsi, color = MaterialTheme.colorScheme.primary, maxLines = 1)
            }
        }
    }
}

@Composable
fun ListScreen (
    navController: NavController,
    modifier: Modifier = Modifier,
    makeup: List<Makeup> = DataDummy.makeup
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            Column {
                Text(
                    text = "Popular Items",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(8.dp)
                )
                LazyRow(
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = modifier
                ) {
                    items(makeup, key = { it.id }) {
                        PopularMakeupItem(makeup = it) { makeupid ->
                            navController.navigate(Screen.DetailMakeup.route + "/$makeupid")
                        }
                    }
                }
                Text(
                    text = "All Makeup Items",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        items(makeup, key = { it.id }) {
            AllMakeupItem(makeup = it) { makeupid ->
                navController.navigate(Screen.DetailMakeup.route + "/$makeupid")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewListScreen (){
    ListScreen(navController = rememberNavController())
}