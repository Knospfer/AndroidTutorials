package com.mberrueta.a17_swipable_views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
            R.drawable.relief,
            R.drawable.unga,
            R.drawable.dinkleberg,
        )

        val adapter = ViewPagerAdapter(images)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        //TabLayout eventi
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@MainActivity,
                    "onTabSelected ${tab?.text}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@MainActivity,
                    "onTabUnselected ${tab?.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            //se tappo sulla tab selezionata
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@MainActivity,
                    "onTabReselected ${tab?.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

//       viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
//       questo non funziona
//        viewPager.beginFakeDrag()
//        viewPager.fakeDragBy(-10f)
//        viewPager.endFakeDrag()
    }
}