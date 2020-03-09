package com.cs.androidanimations.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.cs.androidanimations.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shimmer_effect.setOnClickListener {
            val intent = Intent(this@MainActivity, ShimmerActivity::class.java)
            startActivity(intent)
        }

        spaceTab.setOnClickListener {
            val intent = Intent(this@MainActivity, SpaceTabsActivity::class.java)
            startActivity(intent)
        }

        folding_cell.setOnClickListener {
            val intent = Intent(this@MainActivity, FoldingCellAcivity::class.java)
            startActivity(intent)
        }

        onboarding.setOnClickListener {
            val intent = Intent(this@MainActivity, PaperOnboardingActivity::class.java)
            startActivity(intent)
        }

    }
}
