package com.example.chatbox

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE)
        getWindow().setStatusBarColor(Color.BLACK);
        val buttonSetLogin = findViewById<Button>(R.id.buttonSetLogin)
        val loginInput = findViewById<EditText>(R.id.loginInput)

        val sharedPreference = SharedPreference(this)

        buttonSetLogin.setOnClickListener {
            if(loginInput.text.isNullOrEmpty()){
                Toast.makeText(this, "Name must be not empty!", Toast.LENGTH_SHORT).show()
            }else{
                sharedPreference.save("LOGIN",loginInput.text.toString())
                val intent = Intent(this, ChatBoxActivity::class.java)
                intent.putExtra("LOGIN", sharedPreference.getValueString("LOGIN"))
                startActivity(intent)
            }
        }

        if(!sharedPreference.getValueString("LOGIN").isNullOrEmpty()){
            val intent = Intent(this, ChatBoxActivity::class.java)
            intent.putExtra("LOGIN", sharedPreference.getValueString("LOGIN"))
            startActivity(intent)
        }

/*        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)*/
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
        }
        return true
    }
}
