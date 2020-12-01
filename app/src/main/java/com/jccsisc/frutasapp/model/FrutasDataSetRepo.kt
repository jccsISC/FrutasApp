package com.jccsisc.frutasapp.model

import com.jccsisc.frutasapp.MyResource
import com.jccsisc.frutasapp.ui.model.Fruta

class FrutasDataSetRepo {

    val getGenerateListFrutas = MyResource.Succes(
            listOf(
                    Fruta("Manzana", "Roja", 5.5F, 250.5F, "https://1.bp.blogspot.com/-0V5xiGGwhBc/VK0My5TjBTI/AAAAAAAADxY/cQjkOOq9uqM/s1600/manzana-roja.png"),
                    Fruta("Uva", "Verde", 25.9F, 300F, "https://www.gastronomiavasca.net/uploads/image/file/3436/uva_morada.jpg"),
                    Fruta("Banana", "Amarillo", 3.0F, 250F, "https://www.bidfoodiberia.com/media/catalog/product/cache/1/image/600x/17f82f742ffe127f42dca9de82fb58b1/p/l/ple2.jpg")
            )
    )
}