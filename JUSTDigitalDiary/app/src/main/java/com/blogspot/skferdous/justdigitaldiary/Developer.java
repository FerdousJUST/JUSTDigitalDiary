package com.blogspot.skferdous.justdigitaldiary;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Developer extends AppCompatActivity {
    private Button btn,btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        btn = (Button) findViewById(R.id.button);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Developer.this, "this is making a email system", Toast.LENGTH_SHORT).show();

                String sendto = "ferdousjust2018@gmail.com";
                String sendsub = "subject";
                String sendmsg = "messege";
                if (sendto.isEmpty() && sendsub.isEmpty() && sendmsg.isEmpty()) {
                    Toast.makeText(Developer.this, "Email address is not found", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{sendto});
                    intent.putExtra(Intent.EXTRA_SUBJECT, sendsub);
                    intent.putExtra(Intent.EXTRA_TEXT, sendmsg);
                    try {
                        startActivity(Intent.createChooser(intent, "Choose an email client..... "));
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(Developer.this, "Email address is not found", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Developer.this, "this is making a message system for you", Toast.LENGTH_SHORT).show();
                String number = "01785247043";
                String MSG = "Assalamo Olykom,";
                if (number.isEmpty() && MSG.isEmpty()) {
                    Toast.makeText(Developer.this, "Email address is not found", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("smsto:" + number));
                    intent.putExtra("sms_body", MSG);
                   startActivity(intent);
                    try {
                      startActivity(Intent.createChooser(intent, "Choose an message client..... "));
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(Developer.this, "Messaging address is not found", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickme("https://www.linkedin.com/in/sk-ferdous-rahman-130a72113/");
            }
        });


    }
    public void clickme(String url) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
