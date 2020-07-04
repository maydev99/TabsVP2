package com.bombadu.tabsvp2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
            R.drawable.balloon,
            R.drawable.ice,
            R.drawable.me
        )

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter

        //viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        //viewPager.beginFakeDrag()
        //viewPager.fakeDragBy(-10f)
        //viewPager.endFakeDrag()

        TabLayoutMediator(tab_layout, viewPager){ tab, position ->
            tab.text = "Tab ${position + 1}"

        }.attach()

        tab_layout.addOnTabSelectedListener(object  : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Re-Selected ${tab?.text}", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Unselected ${tab?.text}", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }
}