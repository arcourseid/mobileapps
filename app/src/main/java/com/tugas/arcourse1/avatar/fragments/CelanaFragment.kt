package com.tugas.arcourse1.avatar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tugas.arcourse1.R
import com.tugas.arcourse1.avatar.adapter.RecyclerViewAdapter
import com.tugas.arcourse1.data.DataModel
import kotlinx.android.synthetic.main.fragment_celana.*

class CelanaFragment : Fragment() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    private var dataList = mutableListOf<DataModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celana, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCelana.apply {
            rvCelana.layoutManager = GridLayoutManager(context, 2)
            recyclerViewAdapter = RecyclerViewAdapter()
            rvCelana.adapter = recyclerViewAdapter

            dataList.add(DataModel("Kece Abis", "25", R.drawable.img_celana1))
            dataList.add(DataModel("Casual Tetap Ganteng", "15", R.drawable.img_celana2))
            dataList.add(DataModel("Rumahan #1", "20", R.drawable.img_celana3))
            dataList.add(DataModel("Tentara Gagah Berani", "15", R.drawable.img_celana4))
            dataList.add(DataModel("Rumahan #2", "15", R.drawable.img_celana5))
            dataList.add(DataModel("Nongkrong Santai #1", "25", R.drawable.img_celana6))
            dataList.add(DataModel("Rumahan #3", "10", R.drawable.img_celana7))
            dataList.add(DataModel("Rumahan #4", "10", R.drawable.img_celana8))
            dataList.add(DataModel("Dilanku bukan Dilanmu", "25", R.drawable.img_celana9))
            dataList.add(DataModel("Nongkrong Santai #2", "25", R.drawable.img_celana10))

            recyclerViewAdapter.setDataList(dataList)
        }
    }
}