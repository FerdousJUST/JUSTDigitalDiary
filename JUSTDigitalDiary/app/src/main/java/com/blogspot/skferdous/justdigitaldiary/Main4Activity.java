package com.blogspot.skferdous.justdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class Main4Activity extends AppCompatActivity {
    private CardView dean,cse,eee,ipe,che,pme,bme,tex;
    private LinearLayout pagelayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        pagelayout=(LinearLayout)findViewById(R.id.deptone);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);

        dean = (CardView)findViewById(R.id.dean);
        cse = (CardView)findViewById(R.id.cse);
        eee = (CardView)findViewById(R.id.eee);
        ipe = (CardView)findViewById(R.id.ipe);
        che = (CardView)findViewById(R.id.che);
        pme = (CardView)findViewById(R.id.pme);
        bme = (CardView)findViewById(R.id.bme);
        tex = (CardView)findViewById(R.id.tex);


        dean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this,DeanEngr.class);
                startActivity(intent);
            }
        });



        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this,Main5Activity.class);
                startActivity(intent);
            }
        });


        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this,EEEdept.class);
                startActivity(intent);
            }
        });


        ipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this,IpeDept.class);
                startActivity(intent);
            }
        });

        pme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this,PmeDept.class);
                startActivity(intent);
            }
        });
        che.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this,CheDept.class);
                startActivity(intent);
            }
        });
        bme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this,BmeDept.class);
                startActivity(intent);
            }
        });
        tex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this,TexDept.class);
                startActivity(intent);
            }
        });



    }
}
