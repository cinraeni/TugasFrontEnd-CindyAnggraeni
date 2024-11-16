package com.agrisustain.tugasfrontend_cindy.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.tugasfrontend_cindy.R
import com.agrisustain.tugasfrontend_cindy.data.DataDummy.profil
import com.agrisustain.tugasfrontend_cindy.model.Profil

@Composable
fun AboutItem (
    profil: Profil
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = painterResource(id = profil.foto),
            contentDescription = profil.nama, modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = profil.nama,
            style = MaterialTheme.typography.titleLarge,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(200.dp),
        )
    }
}


@Composable
fun AboutScreen (
    profil: Profil,
    navController: NavController
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .fillMaxSize()
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Profil", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            AboutItem(profil = Profil(
                1,
                "Cindy Anggraeni",
                "Politeknik Negeri Batam",
                "Teknik Informatika",
                "cindyanggraeni133@gmail.com",
                R.drawable.profil)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Box(
                modifier = Modifier
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp),
                    horizontalAlignment = Alignment.Start
                ){
                    Text(text = "Name:", fontWeight = FontWeight.Bold)
                    Text(text = profil.nama, color = Color.Gray)

                    Spacer(modifier = Modifier.height(16.dp))

                    // Menampilkan Umur
                    Text(text = "Asal:", fontWeight = FontWeight.Bold)
                    Text(text = profil.kampus, color = Color.Gray)

                    Spacer(modifier = Modifier.height(16.dp))

                    // Menampilkan Alamat
                    Text(text = "Jurusan:", fontWeight = FontWeight.Bold)
                    Text(text = profil.jurusan, color = Color.Gray)

                    Spacer(modifier = Modifier.height(16.dp))

                    // Menampilkan Email
                    Text(text = "Email:", fontWeight = FontWeight.Bold)
                    Text(text = profil.email, color = Color.Gray)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAboutScreen () {
    AboutScreen(profil = Profil(
        1,
        "Cindy Anggraeni",
        "Politeknik Negeri Batam",
        "Teknik Informatika",
        "cindyanggraeni133@gmail.com",
        R.drawable.profil
    ), navController = rememberNavController())
}