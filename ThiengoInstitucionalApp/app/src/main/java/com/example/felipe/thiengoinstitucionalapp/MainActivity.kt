package com.example.felipe.thiengoinstitucionalapp

import android.Manifest
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.maxcruz.reactivePermissions.ReactivePermissions
import com.maxcruz.reactivePermissions.entity.Permission
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    val REQUEST_CODE = 554
    val reacPermissions =  ReactivePermissions(this,REQUEST_CODE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
            this, drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == R.id.nav_contato_urgente){
            makePhoneCall()
        }else if(id == R.id.nav_sms){

            startActivity <SMSActivity>( "inicio_texto" to "Olá" )

        }else if(id == R.id.nav_email){
            email("felipe11xx@hotmail.com","Tenho um trabalho Android", "Olá\n\n")
        }else if(id == R.id.nav_compartilhar){
            share("http://www.thiengo.com.br","Thiengo[Calopsita]")
        }else if(id == R.id.nav_site){
            browse("http://www.thiengo.com.br")
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return false
    }

    private fun makePhoneCall(){
        val phone = Permission(
            Manifest.permission.CALL_PHONE,
            R.string.explicacao_permissao,
            true)

        val permission = listOf(phone)

        reacPermissions.observeResultPermissions().subscribe{
            event -> run{
                if(event.second){
                    makeCall("982662197")
                }

            }
       }
        reacPermissions.evaluate(permission)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        if(requestCode == REQUEST_CODE){
            reacPermissions.receive(permissions,grantResults)
        }
    }
}
