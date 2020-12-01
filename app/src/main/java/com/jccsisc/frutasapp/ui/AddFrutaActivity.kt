package com.jccsisc.frutasapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jccsisc.frutasapp.R
import com.jccsisc.frutasapp.databinding.ActivityAddFrutaBinding
import com.jccsisc.frutasapp.ui.model.Fruta
import kotlinx.android.synthetic.main.activity_add_fruta.*

class AddFrutaActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddFrutaBinding

    lateinit var fruta: List<Fruta>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddFrutaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnAgregar.setOnClickListener {
                addFruit()
            }
        }
    }

    private fun addFruit() {

        val name: String = tvName.text.toString()
        val color: String = tvName.text.toString()
        val peso: String = tvPeso.text.toString()
        val precio: String = tvPrec.text.toString()

        if (name.isNotEmpty() && color.isNotEmpty() && peso.isNotEmpty() && precio.isNotEmpty()) {
            Toast.makeText(applicationContext, "Guardado", Toast.LENGTH_SHORT).show()
            fruta = listOf(
                Fruta(name, color, peso, precio, "https://1.bp.blogspot.com/-0V5xiGGwhBc/VK0My5TjBTI/AAAAAAAADxY/cQjkOOq9uqM/s1600/manzana-roja.png")
            )


        }else {
            Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}