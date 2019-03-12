package com.blogspot.skferdous.justdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class PureScience extends AppCompatActivity {
    private CardView phy,chem,math,deanpure;
    private LinearLayout pagelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pure_science);

        pagelayout=(LinearLayout)findViewById(R.id.deptalllist);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);

        phy = (CardView)findViewById(R.id.phy);
        chem = (CardView)findViewById(R.id.chem);
        math = (CardView)findViewById(R.id.math);
        deanpure = (CardView)findViewById(R.id.deanpure);

        phy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PureScience.this,PhysicsDept.class);
                startActivity(intent);
            }
        });
        chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PureScience.this,ChemistryDept.class);
                startActivity(intent);
            }
        });

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PureScience.this,MathDept.class);
                startActivity(intent);
            }
        });
        deanpure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PureScience.this,DeanPure.class);
                startActivity(intent);
            }
        });


    }
}
