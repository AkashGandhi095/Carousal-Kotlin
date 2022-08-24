package com.app.carousel.util

import android.widget.ImageView
import coil.load
import com.app.carousel.R
import com.app.carousel.model.ImageData

object DataUtil {

    val imageList = listOf(
        R.drawable.ic_undraw_aircraft_re_m05i , R.drawable.ic_undraw_bitcoin_re_urgq , R.drawable.ic_undraw_delivery_truck_vt6p , R.drawable.ic_undraw_eiffel_tower_re_e11r,
        R.drawable.ic_undraw_fireworks_re_2xi7 , R.drawable.ic_undraw_learning_sketching_nd4f , R.drawable.ic_undraw_proud_coder_re_exuy
    )

    val dataList = listOf(
        ImageData("Wandering  Mind" , R.drawable.ic_undraw_wandering_mind_re_x2a3),
        ImageData("Stripe Payments" , R.drawable.ic_undraw_stripe_payments_re_chlm),
        ImageData("Small Town" , R.drawable.ic_undraw_small_town_re_7mcn),
        ImageData("Proud Coder" , R.drawable.ic_undraw_proud_coder_re_exuy),
        ImageData("Off Road" , R.drawable.ic_undraw_off_road_re_leme),
        ImageData("Mobile Encryption" , R.drawable.ic_undraw_mobile_encryption_re_yw3o),
        ImageData("Learning Sketching" , R.drawable.ic_undraw_learning_sketching_nd4f),
        ImageData("Fireworks" , R.drawable.ic_undraw_fireworks_re_2xi7),
        ImageData("Eiffel Tower" , R.drawable.ic_undraw_eiffel_tower_re_e11r),
        ImageData("Delivery Truck" , R.drawable.ic_undraw_delivery_truck_vt6p),
        ImageData("BitCoin" , R.drawable.ic_undraw_bitcoin_re_urgq),
        ImageData("AirCraft" , R.drawable.ic_undraw_aircraft_re_m05i),
        ImageData("dolor sit" , R.drawable.ic_undraw_bitcoin_re_urgq),
        ImageData("Consectetur Adipiscing" , R.drawable.ic_undraw_off_road_re_leme),
        ImageData("Commodo Consequat" , R.drawable.ic_undraw_small_town_re_7mcn),
        ImageData("Physical Exercise" , R.drawable.ic_undraw_wandering_mind_re_x2a3),
        ImageData("Nemo enim" , R.drawable.ic_undraw_off_road_re_leme),
        ImageData("Neque porro" , R.drawable.ic_undraw_fireworks_re_2xi7),
    )


    fun ImageView.loadImage(resId : Int , isCrossFade : Boolean = false , duration :Int = 0) {
        this.load(resId) {
            this.crossfade(isCrossFade)
            crossfade(duration)
        }
    }

}