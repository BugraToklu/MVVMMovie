package com.example.mvvmmovieapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception
import com.example.mvvmmovieapp.databinding.ItemViewBinding

class BindingAdapters {
    companion object{

        @JvmStatic @BindingAdapter("android:imageURL")
        fun setImageURL(imageView: ImageView,URL:String?){
            try {
                imageView.alpha = 0f
                Picasso.get().load(URL).noFade().into(imageView, object : Callback {
                    override fun onSuccess() {
                        imageView.animate().setDuration(300).alpha(1f).start()
                    }

                    override fun onError(e: Exception?) {

                    }

                })
            }catch (ignored: Exception){
                ignored.printStackTrace()
            }
        }
    }

}