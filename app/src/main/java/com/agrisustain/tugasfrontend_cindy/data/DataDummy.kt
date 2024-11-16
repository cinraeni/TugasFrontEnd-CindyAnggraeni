package com.agrisustain.tugasfrontend_cindy.data

import com.agrisustain.tugasfrontend_cindy.R
import com.agrisustain.tugasfrontend_cindy.model.Makeup
import com.agrisustain.tugasfrontend_cindy.model.Profil

object DataDummy {
    val profil = listOf(
        Profil(
            1,
            "Cindy",
            "Politeknik Negeri Batam",
            "Teknik Informatika",
            "cindy@gmail.com",
            R.drawable.profil
        )
    )
    val makeup = listOf(
        Makeup(
            1,
            "Blush On",
            "Memberikan warna kemerahan alami pada pipi, memberikan tampilan sehat dan muda",
            R.drawable.blushon
        ),
        Makeup(
            2,
            "Compact Powder",
            "Mengunci makeup, mengurangi kilap, dan memberikan hasil akhir matte",
            R.drawable.compact
        ),
        Makeup(
            3,
            "Cushion",
            "Produk serbaguna yang menggabungkan foundation, concealer, dan SPF, memberikan hasil akhir dewy atau matte",
            R.drawable.cushion
        ),
        Makeup(
            4,
            "Loose Powder",
            "Mirip dengan compact powder, tetapi dalam bentuk bubuk. Dapat digunakan untuk mengunci makeup atau untuk mematikan kilap kulit berminyak",
            R.drawable.loose
        ),
        Makeup(
            5,
            "Highlighter",
            "Menambahkan kilau pada titik-titik tinggi wajah, seperti tulang pipi, tulang alis, dan pangkal hidung",
            R.drawable.highlighter
        ),
        Makeup(
            6,
            "Eyeliner",
            "Mendefinisikan dan menonjolkan mata, membuatnya terlihat lebih besar atau lebih kecil, tergantung pada aplikasinya",
            R.drawable.eyeliner
        ),
        Makeup(
            7,
            "Eyeshadow",
            "Menambahkan warna dan dimensi pada kelopak mata, menciptakan berbagai tampilan mata",
            R.drawable.eyeshadow
        ),
        Makeup(
            8,
            "Mascara",
            "Memperpanjang, menebalkan, dan melentikan bulu mata, membuatnya lebih menonjol",
            R.drawable.mascara
        ),
        Makeup(
            9,
            "Lip Balm",
            "Melembapkan dan melindungi bibir dari kekeringan dan pecah-pecah",
            R.drawable.lipbalm
        ),
        Makeup(
            10,
            "Lipstick",
            "Menambahkan warna dan definisi pada bibir, meningkatkan penampilannya",
            R.drawable.lipstik
        )
    )
}