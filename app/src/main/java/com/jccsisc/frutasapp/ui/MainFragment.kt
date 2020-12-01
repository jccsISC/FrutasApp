package com.jccsisc.frutasapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jccsisc.frutasapp.MyResource
import com.jccsisc.frutasapp.R
import com.jccsisc.frutasapp.databinding.FragmentMainBinding
import com.jccsisc.frutasapp.model.FrutasModel
import com.jccsisc.frutasapp.ui.model.Fruta


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            btnAgregarFruta.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_agregarFrutaFragment)
                setUpRecyclerView()
            }
        }
    }


    private fun setUpRecyclerView() {
        binding.apply {
            rvFrutas.layoutManager = LinearLayoutManager(requireContext())

            val getGenerateListFrutas = MyResource.Succes(
                    listOf(
                            Fruta("Manzana", "Roja", 5.5F, 250.5F, "https://1.bp.blogspot.com/-0V5xiGGwhBc/VK0My5TjBTI/AAAAAAAADxY/cQjkOOq9uqM/s1600/manzana-roja.png"),
                            Fruta("Uva", "Verde", 25.9F, 300F, "https://www.gastronomiavasca.net/uploads/image/file/3436/uva_morada.jpg"),
                            Fruta("Banana", "Amarillo", 3.0F, 250F, "https://www.bidfoodiberia.com/media/catalog/product/cache/1/image/600x/17f82f742ffe127f42dca9de82fb58b1/p/l/ple2.jpg")
                    )
            )

            rvFrutas.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
            rvFrutas.adapter = MainAdapter(requireContext(), getGenerateListFrutas.data)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}