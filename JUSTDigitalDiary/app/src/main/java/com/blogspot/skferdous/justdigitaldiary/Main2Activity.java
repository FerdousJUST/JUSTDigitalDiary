package com.blogspot.skferdous.justdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private CardView cd1,cd2,cd3,cd4,cd5,cd6;
    private  ActionBarDrawerToggle toggle;
    private LinearLayout pagelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pagelayout=(LinearLayout)findViewById(R.id.deptalllist);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);

     //   Toolbar toolbar = findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

        cd1 = (CardView)findViewById(R.id.bankcardId1);
        cd2 = (CardView)findViewById(R.id.bankcardId2);
        cd3 = (CardView)findViewById(R.id.bankcardId3);
        cd4 = (CardView)findViewById(R.id.bankcardId4);
        cd5 = (CardView)findViewById(R.id.bankcardId5);
        cd6 = (CardView)findViewById(R.id.bankcardId6);

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this,VC_Sir.class);
                startActivity(intent);
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this,TreasurerSir.class);
                startActivity(intent);
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this,RegisterSir.class);
                startActivity(intent);
            }
        });
        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this,Others.class);
                startActivity(intent);
            }
        });

        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this,Institution.class);
                startActivity(intent);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(Main2Activity.this);

        drawer = findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(Main2Activity.this, drawer,
                R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.nav2:
                Intent intent2  = new Intent(Main2Activity.this,speachvc.class);
                startActivity(intent2);
                Toast.makeText(this, "Message from Honourable Vice-Chancellor", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav4:
                Intent intent1  = new Intent(Main2Activity.this,Website.class);
                startActivity(intent1);
                Toast.makeText(this, "Welcome to Visit Our JUST Website", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav5:
                Intent intent  = new Intent(Main2Activity.this,AboutUS.class);
                startActivity(intent);
                Toast.makeText(this, "About US", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav6:
                Intent intent8  = new Intent(Main2Activity.this,Developer.class);
                startActivity(intent8);
                Toast.makeText(this, "Information of Developer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav7:
                Intent intent9  = new Intent(Main2Activity.this,AdminPage.class);
                startActivity(intent9);
                Toast.makeText(this, "Information on Admin", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

