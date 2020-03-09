package com.cs.androidanimations.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cs.androidanimations.R
import com.cs.androidanimations.fragment.FragmentOne
import com.cs.androidanimations.fragment.FragmentThree
import com.cs.androidanimations.fragment.FragmentTwo
import com.google.android.material.snackbar.Snackbar
import eu.long1.spacetablayout.SpaceTabLayout


class SpaceTabsActivity : AppCompatActivity() {
    var tabLayout: SpaceTabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_space_tabs)
        val fragmentList: MutableList<Fragment> = ArrayList()
        fragmentList.add(FragmentOne())
        fragmentList.add(FragmentTwo())
        fragmentList.add(FragmentThree())

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        tabLayout = findViewById(R.id.spaceTabLayout)
        tabLayout!!.initialize(viewPager, supportFragmentManager, fragmentList, null)
    }
}
