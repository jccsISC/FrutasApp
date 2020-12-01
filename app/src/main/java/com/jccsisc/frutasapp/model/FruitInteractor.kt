package com.jccsisc.frutasapp.model

import com.jccsisc.frutasapp.FruitContract

class FruitInteractor {
    //se encarga de la comunicación en la capa de datos
    var listFrutas: ArrayList<Fruta> = ArrayList()


    fun getFruits(responseCallback: FruitContract.OnResponseCallback) {

        listFrutas.add(Fruta("Manzana", "Roja", "37", "0.300", "https://1.bp.blogspot.com/-0V5xiGGwhBc/VK0My5TjBTI/AAAAAAAADxY/cQjkOOq9uqM/s1600/manzana-roja.png"))
        listFrutas.add(Fruta("Uva", "Verde", "25", "0.200", "https://www.gastronomiavasca.net/uploads/image/file/3436/uva_morada.jpg"))
        listFrutas.add(Fruta("Banana", "Amarillo", "15", "0.100", "https://www.bidfoodiberia.com/media/catalog/product/cache/1/image/600x/17f82f742ffe127f42dca9de82fb58b1/p/l/ple2.jpg"))
        listFrutas.add(Fruta("Melón", "Anaranjado", "50", "0.600", "https://agroalimentando.com/mediaserver/2/main-8186.jpeg"))
        listFrutas.add(Fruta("Sándia", "Verde", "80", "2.700", "https://naturalezaorganicacr.files.wordpress.com/2018/12/sandia-5.jpg?w=640"))


        responseCallback.onResponse(listFrutas)
    }

}