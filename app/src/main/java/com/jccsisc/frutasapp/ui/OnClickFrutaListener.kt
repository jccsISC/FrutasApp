package com.jccsisc.frutasapp.ui

import com.jccsisc.frutasapp.model.Fruta

interface OnClickFrutaListener {

    fun onItemClick(fruta: Fruta, position: Int)
}