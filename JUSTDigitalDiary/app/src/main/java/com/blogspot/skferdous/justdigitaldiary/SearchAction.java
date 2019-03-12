package com.blogspot.skferdous.justdigitaldiary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class SearchAction extends AppCompatActivity {
    BottomNavigationView btm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_action);

        btm = findViewById(R.id.nav_viewpage);

         final NameFragment nameFragment = new NameFragment();


        btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                if (id == R.id.name){
                    //setFragment(nameFragment);
                    //setFragment(nameFragment);
                    return true;
                }else if (id == R.id.designation){
                   // setFragment(nameFragment);
                    return true;
                }else if (id == R.id.department){
                   // setFragment(nameFragment);
                    return true;
                }


                return false;
            }
        });

        btm.setSelectedItemId(R.id.name);

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction  = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }



}
