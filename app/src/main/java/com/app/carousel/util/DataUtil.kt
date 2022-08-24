package com.app.carousel.util

import android.widget.ImageView
import coil.load
import com.app.carousel.R
import com.app.carousel.model.ImageData

object DataUtil {

    val imageList = listOf(
        R.drawable.img_10 , R.drawable.img_2 , R.drawable.img_4 , R.drawable.img_5,
        R.drawable.img_6 , R.drawable.img_7 , R.drawable.img_8
    )

    val dataList = listOf(
        ImageData("Playsam Streamliner" , R.drawable.img_10),
        ImageData("Images API" , R.drawable.img_2),
        ImageData("Wasa Crispbread" , R.drawable.img_4),
        ImageData("Visual Representation" , R.drawable.img_5),
        ImageData(" Electronic Display" , R.drawable.img_6),
        ImageData("Image Label" , R.drawable.img_7),
        ImageData("Carousal" , R.drawable.img_8),
        ImageData("Data Pic" , R.drawable.img_7),
        ImageData("Google" , R.drawable.img_8),
        ImageData("Linkedin" , R.drawable.img_7),
        ImageData("Youtube" , R.drawable.img_6),
        ImageData("Lorem Ipsum" , R.drawable.img_5),
        ImageData("dolor sit" , R.drawable.img_4),
        ImageData("Consectetur Adipiscing" , R.drawable.img_2),
        ImageData("Commodo Consequat" , R.drawable.img_6),
        ImageData("Physical Exercise" , R.drawable.img_4),
        ImageData("Nemo enim" , R.drawable.img_7),
        ImageData("Neque porro" , R.drawable.img_8),
    )


    fun ImageView.loadImage(resId : Int , isCrossFade : Boolean = false , duration :Int = 0) {
        scaleType = ImageView.ScaleType.CENTER_CROP
        this.load(resId) {
            this.crossfade(isCrossFade)
            crossfade(duration)
        }
    }

}