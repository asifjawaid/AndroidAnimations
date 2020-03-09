package com.cs.androidanimations.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.cs.androidanimations.R
import kotlinx.android.synthetic.main.activity_shimmer.*

class ShimmerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shimmer)

        shimmer_layout.startShimmerAnimation()
        shimmer_text.startShimmerAnimation()

        val handler = Handler()
        val runnable = Runnable {
            shimmer_layout.stopShimmerAnimation()
            shimmer_text.stopShimmerAnimation()
        }

        handler.postDelayed(runnable, 3000)
    }
}
