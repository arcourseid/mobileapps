package com.tugas.arcourse1.avatar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.tugas.arcourse1.R
import com.tugas.arcourse1.avatar.adapter.RecyclerViewAdapter
import com.tugas.arcourse1.data.DataModel
import kotlinx.android.synthetic.main.fragment_celana.*

class CelanaFragment : Fragment(), RecyclerViewAdapter.ClickListener {

    val Celana = arrayOf(
        DataModel("Kece Abis", "25", R.drawable.img_celana1),
        DataModel("Casual Tetap Ganteng", "25", R.drawable.img_celana2),
        DataModel("Rumahan #1", "25", R.drawable.img_celana3),
        DataModel("Tentara Gagah Berani", "25", R.drawable.img_celana4),
        DataModel("Rumahan #2", "25", R.drawable.img_celana5),
        DataModel("Nongkrong Santai #1", "25", R.drawable.img_celana6),
        DataModel("Rumahan #3", "25", R.drawable.img_celana7),
        DataModel("Rumahan #4", "25", R.drawable.img_celana8),
        DataModel("Dilanku bukan Dilanmu", "25", R.drawable.img_celana9),
        DataModel("Nongkrong Santai #2", "25", R.drawable.img_celana10)
    )

    val itemModelList = ArrayList<DataModel>()
    var recyclerViewAdapter: RecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celana, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (item in Celana) {
            itemModelList.add(item)
        }

        recyclerViewAdapter = RecyclerViewAdapter(this)
        recyclerViewAdapter!!.setData(itemModelList)
        rvCelana.layoutManager = GridLayoutManager(context, 2)
        rvCelana.setHasFixedSize(true)
        rvCelana.adapter = recyclerViewAdapter
    }

    override fun ClickedItem(itemModel: DataModel) {
        TODO("Not yet implemented")
    }
}