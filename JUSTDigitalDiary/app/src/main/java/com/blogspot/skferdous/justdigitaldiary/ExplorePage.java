package com.blogspot.skferdous.justdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class ExplorePage extends AppCompatActivity {
    private CardView ex1,ex2,ex3,ex4;
    private RelativeLayout pagelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_page);

        pagelayout=(RelativeLayout)findViewById(R.id.mainpage09);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);

        ex1= (CardView)findViewById(R.id.ex1);
        ex2= (CardView)findViewById(R.id.ex2);
        ex3= (CardView)findViewById(R.id.ex3);
        ex4= (CardView)findViewById(R.id.ex4);

        ex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExplorePage.this,Website.class);
                startActivity(intent);
            }
        });

        ex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExplorePage.this,DeptWebsite.class);
                startActivity(intent);
            }
        });
        ex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExplorePage.this,FacePage.class);
                startActivity(intent);
            }
        });
        ex4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExplorePage.this,YouPage.class);
                startActivity(intent);
            }
        });

    }
}
