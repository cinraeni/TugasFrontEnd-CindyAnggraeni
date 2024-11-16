package com.agrisustain.tugasfrontend_cindy.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

@Composable
fun GridItem (
    makeup: Makeup,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        makeup.gambar?.let { painterResource(id = it) }?.let {
            Image(
                painter = it,
                contentDescription = makeup.nama, modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(150.dp)
                    .align(alignment = Alignment.Start)
            )
        }
        Column {
            Text(
                text = makeup.nama,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(150.dp),
                maxLines = 2
            )
            Text(
                text = "Manfaat : ${makeup.deskripsi}",
                style = MaterialTheme.typography.titleSmall,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                modifier = Modifier.width(150.dp),
                maxLines = 2
            )
        }
    }
}

@Composable
fun GridScreen (
    navController: NavController,
) {
    Column {
        Text(
            text = "Favorite",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.padding(8.dp)
        )

        val makeupList = DataDummy.makeup

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 120.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            items(makeupList) { makeupItem ->
                GridItem(makeupItem)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLaguItem (){
    GridScreen(navController = rememberNavController())
}

