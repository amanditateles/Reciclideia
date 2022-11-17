package com.example.reciclideia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [IdeiasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IdeiasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: MeuAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var ideiasArrayList: ArrayList<Ideias>

    lateinit var imageId: Array<Int>
    lateinit var cabecalho: Array <String>
    lateinit var ideias: Array <String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ideias, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment IdeiasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IdeiasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MeuAdapter(ideiasArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(){


        ideiasArrayList = arrayListOf<Ideias>()

        imageId = arrayOf(
            R.drawable.tartaruga_pet_1,
            R.drawable.cofrinho_de_lata_de_nescau_2,
            R.drawable.vaso_de_flores_utilizando_garrafa_de_vidro_2,
            R.drawable.cofrinho_latadeleite,
            R.drawable.porcos_copos,
            R.drawable.xicara_copinho,

        )

        cabecalho = arrayOf(
            getString(R.string.titulo_a),
            getString(R.string.titulo_b),
            getString(R.string.titulo_c),
            getString(R.string.titulo_d),
            getString(R.string.titulo_e),
            getString(R.string.titulo_f),

        )

        ideias = arrayOf(
            getString(R.string.fonte_imagem_1),
            getString(R.string.fonte_imagem_2),
            getString(R.string.fonte_imagem_3),
            getString(R.string.fonte_imagem_3),
            getString(R.string.fonte_imagem_3),
        )

        for (i in imageId.indices){

            val ideias = Ideias(imageId[i],cabecalho[i])
            ideiasArrayList.add(ideias)
        }
        

    }
}