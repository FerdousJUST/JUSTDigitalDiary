package com.blogspot.skferdous.justdigitaldiary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<profile> profiles;
   // ArrayList<ModelAdapter>model;
    public MyAdapter(Context c,ArrayList<profile> p){
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,viewGroup,false));
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.name.setText(profiles.get(i).getName());
        myViewHolder.designation.setText(profiles.get(i).getDesignation());
        myViewHolder.department.setText(profiles.get(i).getDepartment());
        myViewHolder.gmail.setText(profiles.get(i).getEmail());
        myViewHolder.phone.setText(profiles.get(i).getPhone());
       // model=new ArrayList<>();


    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,designation,department,gmail,phone;

        public MyViewHolder(View itemView){
            super(itemView);
           // new ModelAdapter(R.drawable.manicon3,R.drawable.call,R.drawable.email,R.drawable.msg,"Mehedi Hassan","Assistant Professor","m.hassan@just.edu.bd ","01718945945","Contact me:");
            name = (TextView)itemView.findViewById(R.id.name);
            designation = (TextView)itemView.findViewById(R.id.designation);
            department = (TextView)itemView.findViewById(R.id.department);
            gmail = (TextView)itemView.findViewById(R.id.gmail);
            phone = (TextView)itemView.findViewById(R.id.phone);

        }
    }

}
