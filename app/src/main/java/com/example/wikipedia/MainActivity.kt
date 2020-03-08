package com.example.wikipedia

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.wikipedia.ExploreFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val exploreFragment: ExploreFragment = ExploreFragment()
    private val favoritesFragment: FavoritesFragment = FavoritesFragment()
    private val historyFragment: HistoryFragment = HistoryFragment()

    private val onNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        val transaction=supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when(item.itemId){
            R.id.navigation_explore-> transaction.replace(R.id.fragment_container,exploreFragment)
            R.id.navigation_favorites-> transaction.replace(R.id.fragment_container,favoritesFragment)
            R.id.navigation_history->transaction.replace(R.id.fragment_container,historyFragment)
        }

        transaction.commit()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val transaction=supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,exploreFragment)
        transaction.commit()
    }
}
