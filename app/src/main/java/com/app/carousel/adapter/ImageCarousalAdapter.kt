package com.app.carousel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.carousel.R
import com.app.carousel.databinding.ItemImageBinding
import com.app.carousel.util.DataUtil.loadImage

class ImageCarousalAdapter(private val imageList :List<Int>) : RecyclerView.Adapter<ImageCarousalAdapter.ImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image , parent , false))
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bindData(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size

    inner class ImageHolder(itemView :View) : RecyclerView.ViewHolder(itemView) {
        private val bind = ItemImageBinding.bind(itemView)
        fun bindData(imgResId : Int) {
            /*bind.imgView.scaleType = ImageView.ScaleType.CENTER_CROP
            bind.imgView.load(imgResId) {
                this.crossfade(true)
                crossfade(200)
            }*/

            bind.imgView.loadImage(imgResId , true , 200)
        }
    }
}