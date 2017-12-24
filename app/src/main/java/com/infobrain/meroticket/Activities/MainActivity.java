package com.infobrain.meroticket.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.infobrain.meroticket.Fragments.frag_about_us;
import com.infobrain.meroticket.Fragments.frag_account;
import com.infobrain.meroticket.Fragments.frag_bus_booking;
import com.infobrain.meroticket.Fragments.frag_bus_search;
import com.infobrain.meroticket.Fragments.frag_home;
import com.infobrain.meroticket.Fragments.frag_setting;
import com.infobrain.meroticket.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences pref_from,pref_to,pref_state,pref_date;
    private static long back_pressed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        displayFragment(R.id.nav_search);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (back_pressed + 2000 > System.currentTimeMillis()) {
                super.onBackPressed();
                finishAffinity();



            }
            else {
                Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
                back_pressed = System.currentTimeMillis();

            }



        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displayFragment(item.getItemId());
        return true;
    }
    public void displayFragment(int itemId){
        Fragment fragment=null;
        switch (itemId){
            case R.id.nav_home:
                fragment= new frag_home();
                break;
            case R.id.nav_search:
                fragment= new frag_bus_search();
                break;
            case R.id.nav_booking:
                fragment= new frag_bus_booking();
                break;
            case R.id.nav_setting:
                fragment= new frag_setting();
                break;
            case R.id.nav_about_us:
                fragment= new frag_about_us();
                break;
            case R.id.nav_account:
                fragment= new frag_account();
                break;
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_layout, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @Override
    protected void onDestroy() {
        pref_from = this.getApplicationContext().getSharedPreferences("FROMNAME", 0);
        pref_from.edit().remove("from_name").commit();

        pref_to = this.getApplicationContext().getSharedPreferences("TONAME", 0);
        pref_to.edit().remove("to_name").commit();
        // pref_to.edit().clear();
        pref_state= this.getApplicationContext().getSharedPreferences("STATE", 0);
        pref_state.edit().remove("day_night").commit();
        pref_date = this.getApplicationContext().getSharedPreferences("DATE", 0);
        pref_date.edit().remove("date").commit();
        super.onDestroy();
    }
}
