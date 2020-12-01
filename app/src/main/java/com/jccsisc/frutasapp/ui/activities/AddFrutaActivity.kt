package com.jccsisc.frutasapp.ui.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jccsisc.frutasapp.FruitContract
import com.jccsisc.frutasapp.databinding.ActivityAddFrutaBinding
import com.jccsisc.frutasapp.model.Fruta
import com.jccsisc.frutasapp.ui.ImagenController
import kotlinx.android.synthetic.main.activity_add_fruta.*
import kotlinx.android.synthetic.main.activity_add_fruta.tvPeso
import kotlinx.android.synthetic.main.activity_detaalles.*
import kotlinx.android.synthetic.main.activity_main.*

class AddFrutaActivity : AppCompatActivity(), FruitContract.View  {

    lateinit var binding: ActivityAddFrutaBinding
    private val SELECT_ACTIVITY_IMAGE = 2
    var isSelected: Boolean = false
    private var imageUri: Uri? = null
    lateinit var fruta:Fruta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddFrutaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            ivAddFruta.setOnClickListener {
                ImagenController.selectImageGallery(this@AddFrutaActivity, SELECT_ACTIVITY_IMAGE)
                isSelected = true
            }

            btnAgregar.setOnClickListener { addFruit() }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when {
            requestCode == SELECT_ACTIVITY_IMAGE && resultCode == Activity.RESULT_OK -> {
                if (data != null) {
                    imageUri = data.data!!
                }
                binding.ivAddFruta.setImageURI(imageUri)
            }
        }
    }

    private fun addFruit() {
        val image: String = imageUri.toString()
        val name: String  = tvName.text.toString()
        val color: String = tvName.text.toString()
        val peso: String  = tvPeso.text.toString()
        val prec: String  = tvPrec.text.toString()

        if (isSelected) {
            if (name.isNotEmpty() && color.isNotEmpty() && peso.isNotEmpty() && prec.isNotEmpty()) {

                fruta = Fruta(name, color, peso, prec, image)
                val intent = Intent()
                intent.putExtra("fruta", fruta)
                setResult(Activity.RESULT_OK, intent)

                Toast.makeText(applicationContext, "Guardado", Toast.LENGTH_SHORT).show()
                finish()
            }else {
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
            }
        }else {
            Toast.makeText(this, "Agrega una imagen", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showListFruits(listFruit: ArrayList<Fruta>) {
        listFruit.add(fruta)
        rvFrutas.adapter?.notifyDataSetChanged()
    }
}

