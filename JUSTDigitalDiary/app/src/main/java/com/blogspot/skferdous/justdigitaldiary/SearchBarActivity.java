package com.blogspot.skferdous.justdigitaldiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchBarActivity extends AppCompatActivity {
    EditText search_edit_text;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    ArrayList<String> full_name;
    ArrayList<String> full_des;
    ArrayList<String> full_dep;
    ArrayList<String> full_email;
    ArrayList<String> full_phone;
    SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);

        search_edit_text = (EditText) findViewById(R.id.search_edit_text);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        databaseReference.keepSynced(true);

        /*
         * Create a array list for each node you want to use
         * */
        full_name = new ArrayList<>();
        full_des = new ArrayList<>();
        full_dep = new ArrayList<>();
        full_email = new ArrayList<>();
        full_phone = new ArrayList<>();

        search_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    setAdapter(s.toString());
                } else {
                    /*
                     * Clear the list when editText is empty
                     * */
                    full_name.clear();
                    full_des.clear();
                    full_dep.clear();
                    full_email.clear();
                    full_phone.clear();
                    recyclerView.removeAllViews();
                }
            }
        });
    }

    private void setAdapter(final String searchedString) {
        databaseReference.child("Search").child("faculty").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*
                 * Clear the list for every new search
                 * */
                full_name.clear();
                full_des.clear();
                full_dep.clear();
                full_email.clear();
                full_phone.clear();
                recyclerView.removeAllViews();

                int counter = 0;

                /*
                 * Search all users for matching searched string
                 * */
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String uid = snapshot.getKey();
                    String full_name1 = snapshot.child("name").getValue(String.class);
                    String full_des1 = snapshot.child("designation").getValue(String.class);
                    String full_dep1 = snapshot.child("department").getValue(String.class);
                    String full_email1 = snapshot.child("gmail").getValue(String.class);
                    String full_phone1 = snapshot.child("phone").getValue(String.class);

                    if (full_name1.toLowerCase().contains(searchedString.toLowerCase())) {
                        full_name.add(full_name1);
                        full_des.add(full_des1);
                        full_dep.add(full_dep1);
                        full_email.add(full_email1);
                        full_phone.add(full_phone1);
                        counter++;
                    }
                /*    else if (full_des1.toLowerCase().contains(searchedString.toLowerCase())) {
                        full_name.add(full_name1);
                        full_des.add(full_des1);
                        full_dep.add(full_dep1);
                        full_email.add(full_email1);
                        full_phone.add(full_phone1);
                        counter++;
                    }
                    else if (full_dep1.toLowerCase().contains(searchedString.toLowerCase())) {
                        full_name.add(full_name1);
                        full_des.add(full_des1);
                        full_dep.add(full_dep1);
                        full_email.add(full_email1);
                        full_phone.add(full_phone1);
                        counter++;
                    }
                    else if (full_email1.toLowerCase().contains(searchedString.toLowerCase())) {
                        full_name.add(full_name1);
                        full_des.add(full_des1);
                        full_dep.add(full_dep1);
                        full_email.add(full_email1);
                        full_phone.add(full_phone1);
                        counter++;
                    }
*/

                    /*
                     * Get maximum of 15 searched results only
                     * */
                    if (counter == 30)
                        break;
                }

                searchAdapter = new SearchAdapter(SearchBarActivity.this, full_name, full_des, full_dep,full_email,full_phone);
                recyclerView.setAdapter(searchAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
