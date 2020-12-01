package com.jccsisc.frutasapp.ui

import com.jccsisc.frutasapp.ui.model.Fruta

interface OnDrinkClickListener {
    fun onDrinkClick(fruta: Fruta, position: Int)
}