package com.agrisustain.tugasfrontend_cindy.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.agrisustain.tugasfrontend_cindy.R
import com.agrisustain.tugasfrontend_cindy.data.DataDummy
import com.agrisustain.tugasfrontend_cindy.model.Makeup

@Composable
fun DetailMakeupContent (
    newMakeupList: List<Makeup>,
    modifier: Modifier
) {
    if (newMakeupList.isNotEmpty()) {
        val makeup = newMakeupList[0] // Ambil makeup pertama yang sesuai

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier.padding(16.dp)
        ) {
            makeup.gambar?.let { painterResource(id = it) }?.let {
                Image(
                    painter = it,
                    contentDescription = newMakeupList[0].nama,
                    modifier = Modifier
                        .size(height = 250.dp, width = 170.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = makeup.nama,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Deskripsi : ${newMakeupList[0].deskripsi}",
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    } else {
        Text(text = "makeup not found", modifier = modifier.padding(16.dp))
    }
}

@Composable
fun DetailMakeupScreen (
    modifier: Modifier = Modifier,
    navController: NavController,
    makeupid: Int?
) {
    val newMakeupList = DataDummy.makeup.filter { makeup -> makeup.id == makeupid }
    Column(
        modifier = modifier
    ) {
        DetailMakeupContent(newMakeupList = newMakeupList, modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailContent () {
    val sampleMakeup = Makeup(
        1,
        "Blush On",
        "Memberikan warna kemerahan alami pada pipi, memberikan tampilan sehat dan muda",
        R.drawable.blushon)
    DetailMakeupContent(
        newMakeupList = listOf(sampleMakeup),
        modifier = Modifier.fillMaxWidth()
    )
}

