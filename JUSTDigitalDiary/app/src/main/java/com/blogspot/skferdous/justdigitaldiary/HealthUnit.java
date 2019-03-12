package com.blogspot.skferdous.justdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class HealthUnit extends AppCompatActivity {
    private CardView cd11,cd22;

    private LinearLayout pagelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_unit);

        pagelayout=(LinearLayout)findViewById(R.id.deptalllist);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);

        cd11  = (CardView)findViewById(R.id.art11);
        cd22  = (CardView)findViewById(R.id.art22);

        cd11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent= new Intent(HealthUnit.this,DeanHealth.class);
                startActivity(intent);
            }
        });
        cd22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HealthUnit.this,PessDept.class);
                startActivity(intent);
            }
        });
    }
}
