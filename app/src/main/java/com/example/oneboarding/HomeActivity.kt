package com.example.oneboarding

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.oneboarding.databinding.ActivityHomeBinding
import com.example.oneboarding.databinding.ActivityMainBinding
import com.example.oneboarding.fragment.CommunityFragment
import com.example.oneboarding.fragment.DescFragment
import com.example.oneboarding.fragment.HomeFragment
import com.example.oneboarding.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeBinding

    val fragmentHome : Fragment = HomeFragment()
    val fragmentProfile : Fragment = ProfileFragment()
    val fragmentDesc : Fragment = DescFragment()
    val fragmentCommunity : Fragment = CommunityFragment()
    val fm : FragmentManager = supportFragmentManager
//    selanjutnya adalah default fragement yang aktiv saat app pertama kali dijalankan
    var active : Fragment = fragmentHome
    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonNavigation ()

//        val terima = intent.getStringExtra("text")

    }

    private fun buttonNavigation() {
//        disni kita akan memanggil fragment" nya
//        yang ketika buttonnya diklik dia akan menampilkan  apa
//        disini kita akan memanggil gimana kita akan menampilkan kontennya
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
//        maksudnya dihide karena yang tampil pertam buka ini jadi di sembunyikam
        fm.beginTransaction().add(R.id.container, fragmentProfile).hide(fragmentProfile).commit()
        fm.beginTransaction().add(R.id.container, fragmentDesc).hide(fragmentDesc).commit()
        fm.beginTransaction().add(R.id.container, fragmentCommunity).hide(fragmentCommunity).commit()

//        Selanjutnya kita akan membuat jika klik icon home dia akn manggil fragemnt home dst
        bottomNavigationView = binding.navView
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
//        0 artinya index yang pertama yaitu home dikasih index 0
//        selanjutnya mengatur jika di klik warnanya akan hidup
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            when (item.itemId) {
                R.id.home -> {
                    callFragment(0,fragmentHome)
                }
                R.id.desc -> {
                    callFragment(1,fragmentDesc)
                }
                R.id.community -> {
                    callFragment(2,fragmentCommunity)
                }
                R.id.profile -> {
                    callFragment(3,fragmentProfile)
                }
            }
            false
        }
    }

    private fun callFragment(index : Int, fragment: Fragment) {
        menuItem = menu.getItem(index)
//        yang berarti jika dia di klik dia akan nyala
        menuItem.isChecked = true
//        ini maksudnya jika mengeklik timbol lain maka yang active pertama yaitu home akan hide
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment

    }
    override fun onBackPressed() {
        finishAffinity()
    }

}