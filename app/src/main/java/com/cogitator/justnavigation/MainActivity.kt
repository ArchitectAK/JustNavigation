package com.cogitator.justnavigation

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Ankit Kumar on 03/10/2018
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        setupNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(drawerLayout, Navigation.findNavController(this, R.id.host_fragment))
    }

    override fun onBackPressed() {
        if ((drawerLayout).isDrawerOpen(GravityCompat.START)) {
            (drawerLayout).closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun setupNavigation() {
        val navController = Navigation.findNavController(this, R.id.host_fragment)

        // Update toolbar to reflect navigation
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        // Handle nav drawer item clicks
        (navigationView).setNavigationItemSelectedListener {
            it.isChecked = true
            (drawerLayout).closeDrawers()
            true
        }

        // Tie nav graph to items in nav drawer
        NavigationUI.setupWithNavController(navigationView, navController)
    }
}