package com.blogspot.skferdous.justdigitaldiary;


import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.requestPermissions;

public class secondlayoutadapter extends RecyclerView.Adapter<secondlayoutadapter.ViewHolder> {

    private Context mcontext;
    private ArrayList<ModelAdapter> mlist;

    secondlayoutadapter(Context context, ArrayList<ModelAdapter> list) {
        mcontext = context;
        mlist = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        View view = layoutInflater.inflate(R.layout.cse_teacher_list, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {


        final ModelAdapter modelAdapter = mlist.get(position);

        ImageView Image, Call, Email, Msg;
        TextView name, deg, email, phone, textme;

        name = viewHolder.item_name1;
        deg = viewHolder.item_deg1;
        email = viewHolder.item_email1;
        phone = viewHolder.item_phone1;
        textme = viewHolder.textme;

        Image = viewHolder.item_image;
        Call = viewHolder.btn_call1;
        Email = viewHolder.btn_email1;
        Msg = viewHolder.btn_msg1;

        Image.setImageResource(modelAdapter.getImage01());
        Call.setImageResource(modelAdapter.getImage02());
        Email.setImageResource(modelAdapter.getImage03());
        Msg.setImageResource(modelAdapter.getImage04());


        name.setText(modelAdapter.getName01());
        deg.setText(modelAdapter.getDeg01());
        email.setText(modelAdapter.getEmail01());
        phone.setText(modelAdapter.getPhone01());
        textme.setText(modelAdapter.getTextme01());


        viewHolder.btn_call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "this is making a calling for you", Toast.LENGTH_SHORT).show();

                String number = mlist.get(position).getPhone01();
                if (number.isEmpty()) {
                    Toast.makeText(mcontext, "but you donot enter a number", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (mcontext.checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(mcontext, "unissued call permission", Toast.LENGTH_SHORT).show();
                            requestPermissions((Activity) mcontext, new String[]{Manifest.permission.CALL_PHONE}, 10);
                            return;
                        }
                        mcontext.startActivity(intent);
                    }
                }
            }
        });

        viewHolder.btn_msg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "this is making a message system for you", Toast.LENGTH_SHORT).show();
                String number = mlist.get(position).getPhone01();;
                String MSG = "Assalamo Olykom,";
                if (number.isEmpty() && MSG.isEmpty()) {
                    Toast.makeText(mcontext, "Email address is not found", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("smsto:" + number));
                    intent.putExtra("sms_body", MSG);
                    mcontext.startActivity(intent);
                    try {
                        mcontext.startActivity(Intent.createChooser(intent, "Choose an message client..... "));
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(mcontext, "Messaging address is not found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        viewHolder.btn_email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "this is making a email system", Toast.LENGTH_SHORT).show();
                String sendto = mlist.get(position).getEmail01();
                String sendsub = "subject";
                String sendmsg = "messege";
                if (sendto.isEmpty() && sendsub.isEmpty() && sendmsg.isEmpty()) {
                    Toast.makeText(mcontext, "Email address is not found", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{sendto});
                    intent.putExtra(Intent.EXTRA_SUBJECT, sendsub);
                    intent.putExtra(Intent.EXTRA_TEXT, sendmsg);
                    try {
                        mcontext.startActivity(Intent.createChooser(intent, "Choose an email client..... "));
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(mcontext, "Email address is not found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView item_image;
        TextView item_name1,item_deg1,item_email1,item_phone1,textme;
        ImageView btn_call1,btn_email1,btn_msg1;

        public ViewHolder(View itemView) {
            super(itemView);

            item_image= itemView.findViewById(R.id.item_image1);
            item_name1= itemView.findViewById(R.id.item_name);
            item_deg1= itemView.findViewById(R.id.item_deg);
            item_email1= itemView.findViewById(R.id.item_email);
            item_phone1= itemView.findViewById(R.id.item_phone);
            textme= itemView.findViewById(R.id.textme);
            btn_call1= itemView.findViewById(R.id.btn_call);
            btn_email1= itemView.findViewById(R.id.btn_email);
            btn_msg1= itemView.findViewById(R.id.btn_msg);

        }

    }


}

