package com.blogspot.skferdous.justdigitaldiary;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,ModelButtomSheet.ActionListner {
    private CardView one,two,three,four,five,six;
    private LinearLayout pagelayout;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        pagelayout=(LinearLayout)findViewById(R.id.homepage);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);

        one = (CardView)findViewById(R.id.home1);
        two = (CardView)findViewById(R.id.home2);
        three = (CardView)findViewById(R.id.home3);
        four = (CardView)findViewById(R.id.home4);
        five = (CardView)findViewById(R.id.home5);
        six = (CardView)findViewById(R.id.home6);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this,Main2Activity.class);
                startActivity(intent);
            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ModelButtomSheet modelButtomSheet = new ModelButtomSheet();
                modelButtomSheet.setActionListner(HomePage.this);
                modelButtomSheet.show(getSupportFragmentManager(),"Menu Item");

              //  Intent intent1 = new Intent(HomePage.this,SearchMiddle.class);
              //  startActivity(intent1);



            }
        });




        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HomePage.this,Notepadhome.class);
                startActivity(intent2);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(HomePage.this,CalendarPageFive.class);
                startActivity(intent3);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(HomePage.this,ViewPagerHome.class);
                startActivity(intent3);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(HomePage.this,ExplorePage.class);
                startActivity(intent3);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view_page);
        navigationView.setNavigationItemSelectedListener(HomePage.this);

        drawer = findViewById(R.id.mainpage);
        toggle = new ActionBarDrawerToggle(HomePage.this, drawer,
                R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
/*
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
*/

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
                Intent intent2  = new Intent(HomePage.this,speachvc.class);
                startActivity(intent2);
                Toast.makeText(this, "Message from Honourable Vice-Chancellor", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav4:
                Intent intent1  = new Intent(HomePage.this,Website.class);
                startActivity(intent1);
                Toast.makeText(this, "Welcome to Visit Our JUST Website", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav5:
                Intent intent  = new Intent(HomePage.this,AboutUS.class);
                startActivity(intent);
                Toast.makeText(this, "About US", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav6:
                Intent intent8  = new Intent(HomePage.this,Developer.class);
                startActivity(intent8);
                Toast.makeText(this, "Information of Developer", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav7:
                Intent intent9  = new Intent(HomePage.this,AdminPage.class);
                startActivity(intent9);
                Toast.makeText(this, "Information on Admin", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are You Sure You Want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        HomePage.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    @Override
    public void onButtonClick(int id) {
        if (id == R.id.namebtn){
            Intent intent = new Intent(HomePage.this,SearchMiddle.class);
            startActivity(intent);
           //finish();
        }else if (id==R.id.degbtn){
            Intent intent = new Intent(HomePage.this,SearchMiddleTwo.class);
            startActivity(intent);
        }
        //else if (id==R.id.deptbtn){
           // Intent intent = new Intent(HomePage.this,SearchMiddleThree.class);
          //  startActivity(intent);
       // }
    }
}
