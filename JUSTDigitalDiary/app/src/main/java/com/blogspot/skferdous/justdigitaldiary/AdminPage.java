package com.blogspot.skferdous.justdigitaldiary;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminPage extends AppCompatActivity {

    private Button btn11,btn22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);


        btn11 = (Button) findViewById(R.id.button11);
        btn22 = (Button) findViewById(R.id.button22);

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(AdminPage.this, "this is making a email system", Toast.LENGTH_SHORT).show();

                String sendto = "skferdousrahman2017@gmail.com";
                String sendsub = "Subject (Contact with Admin)";
                String sendmsg = "Regards,Share Your Name,Designation,Department,Email Address and Phone number with the admin";
                if (sendto.isEmpty() && sendsub.isEmpty() && sendmsg.isEmpty()) {
                    Toast.makeText(AdminPage.this, "Email address is not found", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{sendto});
                    intent.putExtra(Intent.EXTRA_SUBJECT, sendsub);
                    intent.putExtra(Intent.EXTRA_TEXT, sendmsg);
                    try {
                        startActivity(Intent.createChooser(intent, "Choose an email client..... "));
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(AdminPage.this, "Email address is not found", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(AdminPage.this, "this is making a message system for you", Toast.LENGTH_SHORT).show();
                String number = "01785247043";
                String MSG = "Assalamo Olykom,Share Your Name,Designation,Department,Email Address and Phone number with the admin";
                if (number.isEmpty() && MSG.isEmpty()) {
                    Toast.makeText(AdminPage.this, "Email address is not found", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("smsto:" + number));
                    intent.putExtra("sms_body", MSG);
                    startActivity(intent);
                    try {
                        startActivity(Intent.createChooser(intent, "Choose an message client..... "));
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(AdminPage.this, "Messaging address is not found", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}
