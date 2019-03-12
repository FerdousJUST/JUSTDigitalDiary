package com.blogspot.skferdous.justdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class ArtsUnit extends AppCompatActivity {
    private CardView cd1,cd2;
    private LinearLayout pagelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_unit);

        pagelayout=(LinearLayout)findViewById(R.id.deptalllist);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);

        cd1 =(CardView)findViewById(R.id.art1);
        cd2 =(CardView)findViewById(R.id.art2);

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ArtsUnit.this,DeanArts.class);
                startActivity(intent);
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ArtsUnit.this,EnglishDept.class);
                startActivity(intent);
            }
        });
    }
}
