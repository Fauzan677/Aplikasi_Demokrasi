package com.example.oneboarding

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.oneboarding.adapter.OnBoardingViewPagerAdapter
import com.example.oneboarding.model.OnBoardingData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {

    var onBoardingViewPagerAdapter : OnBoardingViewPagerAdapter? = null
    var tabLayout : TabLayout? = null
    var onBoardingViewPager : ViewPager? = null
    var next : TextView? = null
    var skip : TextView? = null
    var position = 0
    var sharedPreferences : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(restorePrefData()) {
            val i = Intent(applicationContext, HomeActivity::class.java)
//            startActivity(i)
        }

        tabLayout = findViewById(R.id.tab_indicator)
        next = findViewById(R.id.next)
        skip = findViewById(R.id.skip)

        val onBoardingData : MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("APLIKASI DEMOKRASI", "Melihat informasi terkini yang sedang ramai diperbincangkan atau informasi terbaru yang dialami oleh seseorang maupun kelompok",
            R.drawable.onboarding1
        ))
        onBoardingData.add(OnBoardingData("APLIKASI DEMOKRASI", "Membuat petisi tentang suatu permasalahan agar mendapat perhatian di kalangan luas",
            R.drawable.onboarding2
        ))
        onBoardingData.add(OnBoardingData("APLIKASI DEMOKRASI", "Membuat petisi tentang suatu permasalahan agar mendapat perhatian di kalangan luas",R.drawable.onboarding3))
        onBoardingData.add(OnBoardingData("APLIKASI DEMOKRASI", "Ditampilkan semua biodata pejabat agar masyarakat mengetahui pemimpinnya dan semua yang berkaitan dengannya",
            R.drawable.onboarding4
        ))
        onBoardingData.add(OnBoardingData("APLIKASI DEMOKRASI", "Mari menuju kehidupan demokrasi yang merdeka",
            R.drawable.onboarding5
        ))


        setOnBoardingViewPagerAdapter(onBoardingData)
        position = onBoardingViewPager!!.currentItem
//bisa jadi salah
        next?.setOnClickListener {
8
           if(position < onBoardingData.size) {
               position ++
               onBoardingViewPager!!.currentItem = position
           }
            if(position == onBoardingData.size) {
                savePrefData()
                val i = Intent(applicationContext, LoginPage::class.java)
                startActivity(i)
            }

        }

        skip?.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginPage::class.java)
            startActivity(intent)
        }

        tabLayout!!.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                position = tab!!.position
                if(tab.position==onBoardingData.size-1){
                    next!!.text = "Memulai"
                    skip!!.text = " "

                }
                else {
                    next!!.text = "Lanjut"
                    skip!!.text = "Lewati"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData : List<OnBoardingData>) {

        onBoardingViewPager= findViewById(R.id.screenPager);
        onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this,onBoardingData)
        onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter

        tabLayout?.setupWithViewPager(onBoardingViewPager)

    }

    private fun savePrefData() {
//ini juga bisa salah
        sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }

    private fun restorePrefData(): Boolean {

        sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun", false)

    }
    override fun onBackPressed() {
        finishAffinity()
    }
}