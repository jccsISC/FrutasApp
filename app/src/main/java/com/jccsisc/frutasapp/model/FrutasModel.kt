package com.jccsisc.frutasapp.model

import com.jccsisc.frutasapp.MyResource
import com.jccsisc.frutasapp.ui.model.Fruta

interface FrutasModel {

    fun getListFrutas(): MyResource<List<Fruta>>
}