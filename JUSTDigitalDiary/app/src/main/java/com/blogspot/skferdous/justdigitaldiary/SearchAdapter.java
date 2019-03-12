package com.blogspot.skferdous.justdigitaldiary;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    Context context;
    ArrayList<String> full_name;
    ArrayList<String> full_des;
    ArrayList<String> full_dep;
    ArrayList<String> full_email;
    ArrayList<String> full_phone;

    class SearchViewHolder extends RecyclerView.ViewHolder {
        // ImageView profileImage;
        TextView full_name, full_des,full_dep,full_email,full_phone;

        public SearchViewHolder(View itemView) {
            super(itemView);
            // profileImage = (ImageView) itemView.findViewById(R.id.profileImage);
            full_name = (TextView) itemView.findViewById(R.id.full_name);
            full_des = (TextView) itemView.findViewById(R.id.full_des);
            full_dep = (TextView) itemView.findViewById(R.id.full_dep);
            full_email = (TextView) itemView.findViewById(R.id.full_email);
            full_phone = (TextView) itemView.findViewById(R.id.full_phone);
        }
    }

    public SearchAdapter(Context context,  ArrayList<String> full_name,ArrayList<String> full_des,  ArrayList<String> full_dep, ArrayList<String> full_email, ArrayList<String> full_phone) {
        this.context = context;
        this.full_name = full_name;
        this.full_des = full_des;
        this.full_dep = full_dep;
        this.full_email = full_email;
        this.full_phone = full_phone;
    }

    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_list_items, parent, false);
        return new SearchAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.full_name.setText(full_name.get(position));
        holder.full_des.setText(full_des.get(position));
        holder.full_dep.setText(full_dep.get(position));
        holder.full_email.setText(full_email.get(position));
        holder.full_phone.setText(full_phone.get(position));
        // Glide.with(context).load(profilePicList.get(position)).asBitmap().placeholder(R.mipmap.ic_launcher_round).into(holder.profileImage);


        holder.full_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Full Name Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return full_name.size();
    }
}
