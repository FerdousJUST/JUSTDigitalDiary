package com.blogspot.skferdous.justdigitaldiary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DeanBio extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    RecyclerView recyclerView;
    DatabaseReference reference;
    ArrayList<profile> list;
    ArrayList<ModelAdapter>model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dean_bio);

       // DialogBox box = new DialogBox();
       // box.show(getSupportFragmentManager(),"Alert Dialog Box ");
        Toast.makeText(DeanBio.this, "Internet connection is required for initial data synchronization.......!", Toast.LENGTH_SHORT).show();


        reference = FirebaseDatabase.getInstance().getReference().child("Campus").child("DeanBio");
        reference.keepSynced(true);

        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();

        recyclerView = (RecyclerView)findViewById(R.id.deanb);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<profile>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    profile p = dataSnapshot1.getValue(profile.class);
                    list.add(p);
                }
                model=new ArrayList<>();
                for( int i=0; i< list.size(); i++ ) {
                    model.add(new ModelAdapter(R.drawable.manicon3, R.drawable.call, R.drawable.email, R.drawable.msg, list.get(i).getName(), list.get(i).getDesignation(), list.get(i).getEmail(), list.get(i).getPhone(), "Contact me:"));
                }
                LinearLayoutManager manager= new LinearLayoutManager(DeanBio.this);
                RecyclerView.LayoutManager layoutManager= manager;
                recyclerView.setLayoutManager(layoutManager);
                Toast.makeText(DeanBio.this, "This is updated list from database.......!", Toast.LENGTH_SHORT).show();



                secondlayoutadapter adapter= new secondlayoutadapter(DeanBio.this,model);
                recyclerView.setAdapter(adapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DeanBio.this, "Oops....Something Wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
