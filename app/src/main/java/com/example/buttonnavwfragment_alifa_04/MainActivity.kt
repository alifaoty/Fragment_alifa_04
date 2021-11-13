package com.example.buttonnavwfragment_alifa_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.buttonnavwfragment_alifa_04.fragment.FavoriteFragment
import com.example.buttonnavwfragment_alifa_04.fragment.MusicFragment

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val favoriteFragment = FavoriteFragment()
        val musicFragment = MusicFragment()

        makeCurrentFragment (favoriteFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_favorite -> makeCurrentFragment(favoriteFragment)
                R.id.menu_music -> makeCurrentFragment(musicFragment)

            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_nav, fragment)
            commit()
        }
    }
}