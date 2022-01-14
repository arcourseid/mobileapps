package com.tugas.arcourse1.avatar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tugas.arcourse1.R
import com.tugas.arcourse1.avatar.adapter.RecyclerViewAdapter
import com.tugas.arcourse1.avatar.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_shop.*

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        var recyclerViewAdapter: RecyclerViewAdapter? = null

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when(position){
                0 -> {
                    tab.text = "Pakaian"
                }
                1 -> {
                    tab.text = "Celana"
                }
            }
        }.attach()

        val user = arrayOf("")

        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(filterString: String?): Boolean {
                recyclerViewAdapter!!.filter.filter(filterString)
                return true
            }

            override fun onQueryTextChange(filterString: String?): Boolean {
                recyclerViewAdapter!!.filter.filter(filterString)
                return true
            }
        })
    }
}