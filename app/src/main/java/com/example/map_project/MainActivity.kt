package com.example.map_project

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var drawer: DrawerLayout
    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var navigation_view: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        drawer = findViewById(R.id.drawer_layout)
        navigation_view = findViewById(R.id.nav_view)

        setSupportActionBar(toolbar)
        toogle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toogle)
        toogle.syncState()
        toolbar.setNavigationIcon(R.drawable.ic_account_32dp)


        navigation_view.menu.getItem(0).setActionView(R.layout.arrows)
        navigation_view.menu.getItem(1).setActionView(R.layout.back_arrows)
        navigation_view.menu.getItem(2).setActionView(R.layout.arrows)
        navigation_view.menu.getItem(3).setActionView(R.layout.arrows)
         //The color u want



        //Status bar height
        fun getStatusBarHeight() {
            var result = 0;
            var resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = getResources().getDimensionPixelSize(resourceId);
            }
            nav_view.setPadding(0, result + 25, 0 ,0 );
        }
        getStatusBarHeight()

        //Close btn
        close_btn.setOnClickListener{
            if(drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }



    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        getMenuInflater().inflate(R.menu.drawer_menu, menu);
//
//        // change color for icon 0
//        var yourdrawable = navigation_view.menu.getItem(0).icon; // change 0 with 1,2 ...
//        yourdrawable.mutate();
//        yourdrawable.setColorFilter(getResources().getColor(R.color.selected_icon_color), PorterDuff.Mode.SRC_IN);
//        return true;
//    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }
}
