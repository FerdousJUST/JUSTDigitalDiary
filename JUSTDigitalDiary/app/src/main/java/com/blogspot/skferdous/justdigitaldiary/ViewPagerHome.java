package com.blogspot.skferdous.justdigitaldiary;

import android.animation.ArgbEvaluator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerHome extends AppCompatActivity {

    ViewPager viewPagerHome;
    private RelativeLayout pagelayout;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        pagelayout=(RelativeLayout)findViewById(R.id.cardpage);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        pagelayout.startAnimation(animation);

        btn = (Button)findViewById(R.id.btnOrder);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewPagerHome.this,HomePage.class);
                startActivity(intent);
            }
        });

        models = new ArrayList<>();
        models.add(new Model(R.drawable.vcpic1, "Vice-Chancellor", "Jashore University of Science and Technology"));
        models.add(new Model(R.drawable.cam10, "Image", "University Day"));
        models.add(new Model(R.drawable.cam18, "Image", "JUST Campus"));
        models.add(new Model(R.drawable.cam21, "Image", "JUST Central Mosque"));
        models.add(new Model(R.drawable.cam20, "Image", "Beautiful Picture of JUST Campus"));
        models.add(new Model(R.drawable.cam3, "Image", "Academic Building of JUST Campus"));
        models.add(new Model(R.drawable.cam23, "Image", "JUST Cafeteria"));
        models.add(new Model(R.drawable.cam2, "Image", "JUST Busket Ball Ground"));
        models.add(new Model(R.drawable.cam4, "Image", "JUST Big PlayGround"));
        models.add(new Model(R.drawable.cam5, "Image", "JUST Campus Road"));
        models.add(new Model(R.drawable.cam6, "Image", "Beautiful Scenario of JUST Campus "));
        models.add(new Model(R.drawable.cam7, "Image", "Night Scenario of JUST Cafeteria"));
        models.add(new Model(R.drawable.cam8, "Image", "JUST Big Playground"));
        models.add(new Model(R.drawable.cam9, "Image", "Adommo Ekhattor"));
        models.add(new Model(R.drawable.cam11, "Image", "In font of JUST Central Mosque"));
        models.add(new Model(R.drawable.cam12, "Image", "JUST Academic Buildings"));
        models.add(new Model(R.drawable.cam13, "Image", "JUST Campus Road"));
        models.add(new Model(R.drawable.cam14, "Image", "JUST Playground"));
        models.add(new Model(R.drawable.cam15, "Image", "JUST Adommo Ekhattor"));
        models.add(new Model(R.drawable.cam16, "Image", "Celebrating Pitha Festival"));
        models.add(new Model(R.drawable.cam17, "Image", "JUST Campus Road"));
        models.add(new Model(R.drawable.cam19, "Image", "JUST Central Shahid Miner"));
        models.add(new Model(R.drawable.cam22, "Image", "JUST Campus Road"));
        models.add(new Model(R.drawable.cam24, "Image", "JUST Adommo Ekhattor"));
        models.add(new Model(R.drawable.cam25, "Image", "Convocation Ceremony"));
        models.add(new Model(R.drawable.cam26, "Image", "Beautiful Scenario of JUST Campus"));
        models.add(new Model(R.drawable.cam27, "Image", "Main Gate at JUST Campus"));


        adapter = new Adapter(models, this);


        viewPagerHome =  findViewById(R.id.viewpagerhome);
        viewPagerHome.setAdapter(adapter);
        viewPagerHome.setPadding(10, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6),
                getResources().getColor(R.color.color7),
                getResources().getColor(R.color.color8),
                getResources().getColor(R.color.color9),
                getResources().getColor(R.color.color10),
                getResources().getColor(R.color.color11),
                getResources().getColor(R.color.color12),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6),
                getResources().getColor(R.color.color7),
                getResources().getColor(R.color.color8),
                getResources().getColor(R.color.color9),
                getResources().getColor(R.color.color10),
                getResources().getColor(R.color.color11),
                getResources().getColor(R.color.color12),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3)
        };

        colors = colors_temp;

        viewPagerHome.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPagerHome.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPagerHome.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

}
