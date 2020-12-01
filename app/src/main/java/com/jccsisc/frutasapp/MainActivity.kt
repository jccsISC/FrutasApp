package com.jccsisc.frutasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jccsisc.frutasapp.databinding.ActivityMainBinding
import com.jccsisc.frutasapp.ui.AddFrutaActivity
import com.jccsisc.frutasapp.ui.DetaallesActivity
import com.jccsisc.frutasapp.ui.MainAdapter
import com.jccsisc.frutasapp.ui.OnClickFrutaListener
import com.jccsisc.frutasapp.ui.model.Fruta

class MainActivity : AppCompatActivity(), OnClickFrutaListener {

    lateinit var binding: ActivityMainBinding
    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

        binding.btnAgregarFruta.setOnClickListener {

            val intent = Intent(this, AddFrutaActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    private fun setUpRecyclerView() {
        binding.apply {
            rvFrutas.layoutManager = LinearLayoutManager(this@MainActivity)

            val getGenerateListFrutas = listOf(
                Fruta("Manzana", "Roja", "5.5", "0.300", "https://1.bp.blogspot.com/-0V5xiGGwhBc/VK0My5TjBTI/AAAAAAAADxY/cQjkOOq9uqM/s1600/manzana-roja.png"),
                Fruta("Uva", "Verde", "25", "0.200", "https://www.gastronomiavasca.net/uploads/image/file/3436/uva_morada.jpg"),
                Fruta("Banana", "Amarillo", "15", "0.350", "https://www.bidfoodiberia.com/media/catalog/product/cache/1/image/600x/17f82f742ffe127f42dca9de82fb58b1/p/l/ple2.jpg")
            )

            rvFrutas.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            rvFrutas.adapter = MainAdapter(this@MainActivity, getGenerateListFrutas, this@MainActivity)
        }
    }


    override fun onItemClick(fruta: Fruta, position: Int) {
        val intent = Intent(this, DetaallesActivity::class.java)
        intent.putExtra("fruta", fruta)
        startActivity(intent)
    }
}