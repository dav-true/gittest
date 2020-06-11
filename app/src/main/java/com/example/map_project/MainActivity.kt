package com.example.map_project




import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATION")
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
        navigation_view.setItemIconTintList(null);
        navigation_view.menu.getItem(1).setChecked(true)

        invalidateOptionsMenu()



        //Status bar height
        fun getStatusBarHeight() {
            var result = 0;
            var resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = resources.getDimensionPixelSize(resourceId);
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return false;
    }

//    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.drawer_menu, menu)
//        val navigationView = findViewById(R.id.nav_view) as NavigationView
//        val menu = navigationView.menu
//        val nav_main: MenuItem = menu.findItem(R.id.nav_main)
//        nav_main.setChecked(true)
////        nav_login.setIcon(R.drawable.ic_remove_red_eye_black_24dp)
////        nav_login.icon.setColorFilter(Color.parseColor("#ea3479"), PorterDuff.Mode.SRC_ATOP)
////        Toast.makeText(this, nav_login.icon.toString(), Toast.LENGTH_LONG).show()
//        return onPrepareOptionsMenu(menu)
//    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }
}
