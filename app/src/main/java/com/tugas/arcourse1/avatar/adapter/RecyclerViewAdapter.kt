package com.tugas.arcourse1.avatar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.tugas.arcourse1.R
import com.tugas.arcourse1.data.DataModel
import kotlinx.android.synthetic.main.photo_layout.view.*

class RecyclerViewAdapter(var clickListener: ClickListener) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(), Filterable {

    var dataList = ArrayList<DataModel>()
    var itemModelListFilter = ArrayList<DataModel>()

    fun setData(itemModelList: ArrayList<DataModel>) {
        this.dataList = itemModelList
        this.itemModelListFilter = itemModelList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.title
        val desc = itemView.desc
        val image = itemView.image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.photo_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = dataList[position]
        holder.title.text = itemModel.title
        holder.desc.text = itemModel.desc
        holder.image.setImageResource(itemModel.image)

        holder.itemView.setOnClickListener {
            clickListener.ClickedItem(itemModel)
        }
    }

    override fun getItemCount() = dataList.size

    interface ClickListener {
        fun ClickedItem(itemModel: DataModel)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResult = FilterResults()
                if (charSequence == null || charSequence.length < 0) {
                    filterResult.count = itemModelListFilter.size
                    filterResult.values = itemModelListFilter
                } else {
                    var searchChr = charSequence.toString().toLowerCase()

                    val itemModel = ArrayList<DataModel>()

                    for (item in itemModelListFilter) {
                        if (item.title.contains(searchChr) || item.desc.contains(searchChr)) {
                            itemModel.add(item)
                        }
                    }
                    filterResult.count = itemModel.size
                    filterResult.values = itemModel
                }
                return filterResult
            }

            override fun publishResults(p0: CharSequence?, filterResult: FilterResults?) {
                itemModelListFilter = filterResult!!.values as ArrayList<DataModel>
                notifyDataSetChanged()
            }

        }
    }
}