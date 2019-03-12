package com.blogspot.skferdous.justdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class BusinessDept extends AppCompatActivity {
    private CardView ais,manag,fb,deanbus;
    private LinearLayout pagelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_dept);

        pagelayout=(LinearLayout)findViewById(R.id.deptalllist);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);

        ais = (CardView)findViewById(R.id.ais);
        manag = (CardView)findViewById(R.id.manag);
        fb = (CardView)findViewById(R.id.fb);
        deanbus = (CardView)findViewById(R.id.deanbus);


        ais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusinessDept.this,AisDept.class);
                startActivity(intent);
            }
        });
        manag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusinessDept.this,ManagDept.class);
                startActivity(intent);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusinessDept.this,FinanceDept.class);
                startActivity(intent);
            }
        });

        deanbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusinessDept.this,DeanBus.class);
                startActivity(intent);
            }
        });

    }
}
