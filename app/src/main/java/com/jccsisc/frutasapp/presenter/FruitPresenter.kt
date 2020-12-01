package com.jccsisc.frutasapp.presenter

import com.jccsisc.frutasapp.FruitContract
import com.jccsisc.frutasapp.model.FruitInteractor
import com.jccsisc.frutasapp.model.Fruta

class FruitPresenter(private val view: FruitContract.View) : FruitContract.Presenter {

    private val fruiteInteractor: FruitInteractor = FruitInteractor()

    override fun getListFruits() {
        fruiteInteractor.getFruits(object : FruitContract.OnResponseCallback {
            override fun onResponse(listFruit: ArrayList<Fruta>) {
                view.showListFruits(listFruit)
            }
        })
    }
}