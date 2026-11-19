package com.example.view.route

import com.example.a0212_roomdatabase.R
import com.example.roomdb.uicontroller.DestinasiNavigasi

object DestinasiDetailSiswa : DestinasiNavigasi {

    override val route = "detail_siswa"

    override val titleRes = R.string.detail

    const val itemIdArg = "IdSiswa"

    val routeWithArgs = "$route/{$itemIdArg}"
}