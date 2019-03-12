package com.blogspot.skferdous.justdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView welcome,copy;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = (TextView)findViewById(R.id.welcome);
        copy = (TextView)findViewById(R.id.copy);
        image = (ImageView)findViewById(R.id.image);


        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        welcome.startAnimation(animation);

        Animation animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        copy.startAnimation(animation1);

        Animation animation2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.uptodown);
        image.startAnimation(animation2);

        Handler handler= new Handler();
        handler.postDelayed(r,3000);

    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            Intent intent= new Intent(MainActivity.this,HomePage.class);
            startActivity(intent);
            finish();
        }
    };
    }

