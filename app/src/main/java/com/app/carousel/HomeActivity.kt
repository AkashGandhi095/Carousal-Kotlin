package com.app.carousel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.app.carousel.adapter.DataAdapter
import com.app.carousel.adapter.ImageCarousalAdapter
import com.app.carousel.databinding.ActivityHomeBinding
import com.app.carousel.util.DataUtil
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

private const val TAG = "HomeActivity***"
class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private val dataItemList = DataUtil.dataList
    private lateinit var dataAdapter : DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        setupCarousalImageSlider()
        setupRecyclerView()
        handleSearch()
    }

    private fun setupCarousalImageSlider() {

        val imgAdapter = ImageCarousalAdapter(DataUtil.imageList)
        binding.imgSlider.apply {
            adapter = imgAdapter
        }

        TabLayoutMediator(binding.tabLayout, binding.imgSlider) { _, _ -> }.attach()

        binding.imgSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                CoroutineScope(Dispatchers.Main).launch {
                    dataAdapter.updateDataList(dataItemList.shuffled())
                }
            }
        })
    }

    private fun setupRecyclerView() {
        dataAdapter = DataAdapter()
        binding.listView.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            addItemDecoration(DividerItemDecoration(this.context , DividerItemDecoration.VERTICAL))
            adapter = dataAdapter
        }
    }

    private fun handleSearch() {
        binding.editSearch.doOnTextChanged { text, start, before, count ->
            val list = dataItemList.filter { it.labelName.lowercase() == text.toString().lowercase() }
            Log.d(TAG, "handleSearch: ${list.size} , $text")
            if(list.isEmpty()) {
                dataAdapter.updateDataList(dataItemList)
            } else {
                dataAdapter.updateDataList(list)
            }

        }
    }
}