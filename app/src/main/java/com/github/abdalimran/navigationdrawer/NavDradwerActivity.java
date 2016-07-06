package com.github.abdalimran.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class NavDradwerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private DrawerLayout hidedrawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navdrawer);

        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView= (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)==true)
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_menu1:
                Toast.makeText(getApplicationContext(),"New Clicked!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_menu2:
                Toast.makeText(getApplicationContext(),"Delete Clicked!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_menu3:
                Toast.makeText(getApplicationContext(),"Settings Clicked!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_menu4:
                Toast.makeText(getApplicationContext(),"Share Clicked!!",Toast.LENGTH_SHORT).show();
                break;
        }

        hidedrawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        if (hidedrawerLayout.isDrawerOpen(GravityCompat.START))
            hidedrawerLayout.closeDrawer(GravityCompat.START);

        return false;
    }
}
