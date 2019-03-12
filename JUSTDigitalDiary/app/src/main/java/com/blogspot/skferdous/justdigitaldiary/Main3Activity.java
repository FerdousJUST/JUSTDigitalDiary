package com.blogspot.skferdous.justdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class Main3Activity extends AppCompatActivity {
    private CardView cd01,cd02,cd03,cd04,cd05,cd06,cd07;
    private LinearLayout pagelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        pagelayout=(LinearLayout)findViewById(R.id.deptalllist);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);

        cd01  = (CardView)findViewById(R.id.card1);
        cd02  = (CardView)findViewById(R.id.card2);
        cd03  = (CardView)findViewById(R.id.card3);
        cd04  = (CardView)findViewById(R.id.card4);
        cd05  = (CardView)findViewById(R.id.card5);
        cd06  = (CardView)findViewById(R.id.card6);
        cd07  = (CardView)findViewById(R.id.card7);


        cd01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        cd02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this,BioUnit.class);
                startActivity(intent);
            }
        });

        cd03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this,AppliedUnit.class);
                startActivity(intent);
            }
        });
        cd05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this,ArtsUnit.class);
                startActivity(intent);
            }
        });

        cd04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this,PureScience.class);
                startActivity(intent);
            }
        });

        cd06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this,BusinessDept.class);
                startActivity(intent);
            }
        });

        cd07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this,HealthUnit.class);
                startActivity(intent);
            }
        });

    }
}
