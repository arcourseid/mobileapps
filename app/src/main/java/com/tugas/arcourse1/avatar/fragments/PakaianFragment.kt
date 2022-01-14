package com.tugas.arcourse1.avatar.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.tugas.arcourse1.R
import com.tugas.arcourse1.avatar.adapter.RecyclerViewAdapter
import com.tugas.arcourse1.data.DataModel
import kotlinx.android.synthetic.main.fragment_pakaian.*

class PakaianFragment : Fragment(), RecyclerViewAdapter.ClickListener {

    val Pakaian = arrayOf(
        DataModel("Outfit Kece Abis", "25", R.drawable.img_outfit1),
        DataModel("Rumahan #1", "25", R.drawable.img_outfit2),
        DataModel("Nongkrong santai #1", "25", R.drawable.img_outfit3),
        DataModel("Casual Tetap Ganteng", "25", R.drawable.img_outfit4),
        DataModel("Rumahan #2", "25", R.drawable.img_outfit5),
        DataModel("Rumahan #3", "25", R.drawable.img_outfit6),
        DataModel("Jeans Mempesona", "25", R.drawable.img_outfit7),
        DataModel("Nongkrong Santai #2", "25", R.drawable.img_outfit8),
        DataModel("Dilanku bukan Dilanmu", "25", R.drawable.img_outfit9),
        DataModel("Tentara Gagah Berani", "25", R.drawable.img_outfit10)
    )

    val itemModelList = ArrayList<DataModel>()
    var recyclerViewAdapter: RecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pakaian, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (item in Pakaian) {
            itemModelList.add(item)
        }

        recyclerViewAdapter = RecyclerViewAdapter(this)
        recyclerViewAdapter!!.setData(itemModelList)
        rvPakaian.layoutManager = GridLayoutManager(context, 2)
        rvPakaian.setHasFixedSize(true)
        rvPakaian.adapter = recyclerViewAdapter
    }

    override fun ClickedItem(itemModel: DataModel) {
//        val intent = Intent(this, HomeActivity::class.java)
    }
}