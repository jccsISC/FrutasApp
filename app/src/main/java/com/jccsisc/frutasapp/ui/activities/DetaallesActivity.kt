package com.jccsisc.frutasapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.jccsisc.frutasapp.databinding.ActivityDetaallesBinding
import com.jccsisc.frutasapp.model.Fruta

class DetaallesActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetaallesBinding
    private lateinit var fruta: Fruta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetaallesBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        binding.apply {

            val bundle = intent.extras
            fruta = bundle?.getParcelable("fruta")!!
            Log.d("NAME", "$fruta")

            supportActionBar?.title = fruta.nombreFruta

            Glide.with(applicationContext).load(fruta.image).centerCrop().into(imageFruta)
            tvColor.text = fruta.colorFruta
            tvPeso.text = fruta.pesoFruta
            tvPrecio.text ="$ ${fruta.precioFruta}"
        }
    }
}