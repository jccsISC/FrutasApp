package com.jccsisc.frutasapp.presenter

import com.jccsisc.frutasapp.MyResource
import com.jccsisc.frutasapp.model.FrutasDataSetRepo
import com.jccsisc.frutasapp.model.FrutasModel
import com.jccsisc.frutasapp.ui.model.Fruta

class FrutasImpl(private val dataFrutas: FrutasDataSetRepo): FrutasModel{

    override fun getListFrutas(): MyResource<List<Fruta>> {
        return dataFrutas.getGenerateListFrutas
    }
}