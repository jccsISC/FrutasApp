package com.jccsisc.frutasapp.ui

import com.jccsisc.frutasapp.ui.model.Fruta

interface OnClickFrutaListener {

    fun onItemClick(fruta: Fruta, position: Int)
}