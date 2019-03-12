package com.blogspot.skferdous.justdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class BioUnit extends AppCompatActivity {
    private CardView mb,fmb,gebt,phar,deanbio;
    private LinearLayout pagelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_unit);

        pagelayout=(LinearLayout)findViewById(R.id.deptalllist);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);


        mb = (CardView)findViewById(R.id.mb);
        fmb = (CardView)findViewById(R.id.fmb);
        gebt = (CardView)findViewById(R.id.gebt);
        phar = (CardView)findViewById(R.id.phar);
        deanbio = (CardView)findViewById(R.id.deanbio);

        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BioUnit.this,MbDept.class);
                startActivity(intent);
            }
        });
        fmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BioUnit.this,FmbDept.class);
                startActivity(intent);
            }
        });
        gebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BioUnit.this,GebtDept.class);
                startActivity(intent);
            }
        });
        phar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BioUnit.this,PharDept.class);
                startActivity(intent);
            }
        });
        deanbio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BioUnit.this,DeanBio.class);
                startActivity(intent);
            }
        });
    }
}
