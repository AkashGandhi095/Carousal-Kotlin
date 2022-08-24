package com.app.carousel.adapter

import android.annotation.SuppressLint
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.base.R
import com.app.carousel.databinding.ListItemBinding
import com.app.carousel.model.ImageData
import com.app.carousel.util.DataUtil
import com.app.carousel.util.DataUtil.loadImage

class DataAdapter() : RecyclerView.Adapter<DataAdapter.DataHolder>() {

    private val list = arrayListOf<ImageData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        return DataHolder(LayoutInflater.from(parent.context).inflate(com.app.carousel.R.layout.list_item , parent , false))
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataList(dataList : List<ImageData>) {
        if(list.isNotEmpty()) list.clear()
        list.addAll(dataList)
        notifyDataSetChanged()
    }

    inner class DataHolder(itemView :View) : RecyclerView.ViewHolder(itemView) {
        private val bind = ListItemBinding.bind(itemView)
        fun bindData(dataItem : ImageData) {
            bind.itemImgView.loadImage(dataItem.imgResId , true , 200)
            bind.txtLabelView.text = dataItem.labelName
        }
    }
}