package com.perusu.vm_pro

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI


class MainActivity : AppCompatActivity() {

    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.navHostFragment)

        val host = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment?
            ?: return

        navController?.let {
            val appBarConfiguration = AppBarConfiguration(it.graph)
            NavigationUI.setupActionBarWithNavController(
                this,
                host.navController,
                appBarConfiguration
            )
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                navController?.navigateUp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}