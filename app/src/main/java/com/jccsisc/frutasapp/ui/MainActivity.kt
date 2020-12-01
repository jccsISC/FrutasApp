package com.jccsisc.frutasapp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jccsisc.frutasapp.FruitContract
import com.jccsisc.frutasapp.databinding.ActivityMainBinding
import com.jccsisc.frutasapp.model.Fruta
import com.jccsisc.frutasapp.presenter.FruitPresenter
import com.jccsisc.frutasapp.ui.activities.AddFrutaActivity
import com.jccsisc.frutasapp.ui.activities.DetaallesActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OnClickFrutaListener, FruitContract.View {

    private var fruitPresenter:FruitContract.Presenter? = null
    lateinit var binding: ActivityMainBinding
    var newFruit: Fruta? = null
    var listFrutas: ArrayList<Fruta> = ArrayList()
    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fruitPresenter = FruitPresenter(this)
        fruitPresenter?.getListFruits()

        setUpRecyclerView()

        binding.btnAgregarFruta.setOnClickListener {
           startActivityForResult(Intent(this, AddFrutaActivity::class.java), REQUEST_CODE)
        }
    }

    private fun setUpRecyclerView() {
        binding.apply {
            rvFrutas.layoutManager = LinearLayoutManager(this@MainActivity)
            rvFrutas.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }
    }


    override fun onItemClick(fruta: Fruta, position: Int) {
        val intent = Intent(this, DetaallesActivity::class.java)
        intent.putExtra("fruta", fruta)
        startActivity(intent)
    }

    override fun showListFruits(listFruit: ArrayList<Fruta>) {
        rvFrutas.adapter = MainAdapter(this@MainActivity, listFruit, this@MainActivity)
        rvFrutas.adapter?.notifyDataSetChanged()
        listFrutas = listFruit
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                newFruit = data!!.extras!!["fruta"] as Fruta?

                newFruit?.let { listFrutas.add(it) }
                rvFrutas.adapter?.notifyDataSetChanged()
            }
        }
    }

}

