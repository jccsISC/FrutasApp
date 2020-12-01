package com.jccsisc.frutasapp

import com.jccsisc.frutasapp.model.Fruta

interface FruitContract {

    interface View {
        fun showListFruits(listFruit: ArrayList<Fruta>)
    }


    interface  Presenter {
        fun getListFruits()
    }

    interface OnResponseCallback{
        fun onResponse(listFruit: ArrayList<Fruta>)
    }
}