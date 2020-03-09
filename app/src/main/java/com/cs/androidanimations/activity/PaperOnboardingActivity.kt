package com.cs.androidanimations.activity

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cs.androidanimations.R
import com.cs.androidanimations.fragment.BlankFragment
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage


class PaperOnboardingActivity : AppCompatActivity() {

    private var fragmentManager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper_onboarding)
        fragmentManager = supportFragmentManager
        val onBoardingFragment = PaperOnboardingFragment.newInstance(getDataForOnboarding())
        val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, onBoardingFragment)
        fragmentTransaction.commit()

        onBoardingFragment.setOnRightOutListener {
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            val bf: Fragment = BlankFragment()
            fragmentTransaction.replace(R.id.fragment_container, bf)
            fragmentTransaction.commit()
        }
    }

    private fun getDataForOnboarding(): ArrayList<PaperOnboardingPage>? { // prepare data
        val scr1 = PaperOnboardingPage("Hotels", "All hotels and hostels are sorted by hospitality rating", Color.parseColor("#678FB4"), R.drawable.hotels, R.drawable.key)
        val scr2 = PaperOnboardingPage("Banks", "We carefully verify all banks before add them into the app", Color.parseColor("#65B0B4"), R.drawable.banks, R.drawable.wallet)
        val scr3 = PaperOnboardingPage("Stores", "All local stores are categorized for your convenience", Color.parseColor("#9B90BC"), R.drawable.stores, R.drawable.shopping_cart)
        val elements: ArrayList<PaperOnboardingPage> = ArrayList()
        elements.add(scr1)
        elements.add(scr2)
        elements.add(scr3)
        return elements
    }
}
