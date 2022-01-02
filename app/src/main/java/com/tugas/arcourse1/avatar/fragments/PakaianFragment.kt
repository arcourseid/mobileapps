package com.tugas.arcourse1.avatar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tugas.arcourse1.R
import com.tugas.arcourse1.avatar.adapter.PhotoAdapter
import com.tugas.arcourse1.data.DataModel
import kotlinx.android.synthetic.main.fragment_pakaian.*

class PakaianFragment : Fragment() {

    private lateinit var photoAdapter: PhotoAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    private var dataList = mutableListOf<DataModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pakaian, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPakaian.apply {
            rvPakaian.layoutManager = GridLayoutManager(context, 2)
            photoAdapter = PhotoAdapter()
            rvPakaian.adapter = photoAdapter

            dataList.add(DataModel("Outfit Kece Abis", "25", R.drawable.img_outfit1))
            dataList.add(DataModel("Rumahan #1", "10", R.drawable.img_outfit2))
            dataList.add(DataModel("Nongkrong santai #1", "25", R.drawable.img_outfit3))
            dataList.add(DataModel("Casual Tetap Ganteng", "15", R.drawable.img_outfit4))
            dataList.add(DataModel("Rumahan #2", "10", R.drawable.img_outfit5))
            dataList.add(DataModel("Rumahan #3", "10", R.drawable.img_outfit6))
            dataList.add(DataModel("Jeans Mempesona", "20", R.drawable.img_outfit7))
            dataList.add(DataModel("Nongkrong Santai #2", "25", R.drawable.img_outfit8))
            dataList.add(DataModel("Dilanku bukan Dilanmu", "25", R.drawable.img_outfit9))
            dataList.add(DataModel("Tentara Gagah Berani", "15", R.drawable.img_outfit10))

            photoAdapter.setDataList(dataList)
        }
    }
}