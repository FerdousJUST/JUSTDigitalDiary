package com.blogspot.skferdous.justdigitaldiary;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CalenderPageFour extends AppCompatActivity {
    public GregorianCalendar cal_month, cal_month_copy;
    private HwAdapter hwAdapter;
    private TextView tv_month;

    DatabaseReference reference;
    // ArrayList<HomeCollection> list;
    ArrayList<HomeCollection> date_collection_arr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_page_two);

        // date_collection_arr=new ArrayList<HomeCollection>();
        HomeCollection.date_collection_arr=new ArrayList<HomeCollection>();
        // list = new ArrayList<HomeCollection>();


        reference = FirebaseDatabase.getInstance().getReference().child("Calendar");
        reference.keepSynced(true);


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    HomeCollection p = dataSnapshot1.getValue(HomeCollection.class);
                    HomeCollection.date_collection_arr.add(p);
                }
                //  model = new ArrayList<>();
                HomeCollection.date_collection_arr=new ArrayList<HomeCollection>();
                for (int i = 0; i < HomeCollection.date_collection_arr.size(); i++) {


                    //   HomeCollection.date_collection_arr.add( new HomeCollection("2019-01-03" ,"Thusday","Weekly Off Day","This is Holiday"));
                    HomeCollection.date_collection_arr.add( new HomeCollection(HomeCollection.date_collection_arr.get(i).date ,HomeCollection.date_collection_arr.get(i).name,HomeCollection.date_collection_arr.get(i).subject,HomeCollection.date_collection_arr.get(i).description));

                    // model.add(new ModelAdapter( HomeCollection.date_collection_arr.get(i).getName(), HomeCollection.date_collection_arr.get(i).getDesignation(), HomeCollection.date_collection_arr.get(i).getEmail(), HomeCollection.date_collection_arr.get(i).getPhone(), "Contact me:"));
                }
                //   LinearLayoutManager manager = new LinearLayoutManager(CalenderPageTwo.this);
                //   RecyclerView.LayoutManager layoutManager = manager;
                //    recyclerView.setLayoutManager(layoutManager);


                //  secondlayoutadapter adapter = new secondlayoutadapter(CalenderPageTwo.this, model);
                //  recyclerView.setAdapter(adapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CalenderPageFour.this, "Oops....Something Wrong", Toast.LENGTH_SHORT).show();

            }
        });


        // January


        //HomeCollection.date_collection_arr.add( new HomeCollection("2019-01-03" ,"Thusday","Weekly Off Day","This is Holiday"));
        //HomeCollection.date_collection_arr.add( new HomeCollection("2019-01-04" ,"Friday","Weekly Off Day","This is Holiday"));
        /*
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-01-10" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-01-11" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-01-17" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-01-18" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-01-24" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-01-25" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-01-31" ,"Thusday","Weekly Off Day","This is Holiday"));

        //February

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-02-01" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-02-07" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-02-08" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-02-14" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-02-15" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-02-21" ,"International Mother Language Day","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-02-22" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-02-28" ,"Thusday","Weekly Off Day","This is Holiday"));

        //March

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-01" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-07" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-08" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-14" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-15" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-21" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-22" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-28" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-29" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-17" ,"Sunday (17 March)","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-03-26" ,"Tuesday (26 March)","Holiday","This is Holiday"));

        //April

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-04-04" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-04-05" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-04-11" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-04-12" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-04-18" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-04-19" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-04-25" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-04-26" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-04-14" ,"Sunday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-04-21" ,"Sunday ","Holiday","This is Holiday"));


        //May

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-01" ,"Wednesday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-02" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-03" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-09" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-10" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-16" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-17" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-23" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-24" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-30" ,"Thusday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-31" ,"Friday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-18" ,"Saturday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-19" ,"Sunday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-20" ,"Monday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-21" ,"Tuesday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-05-22" ,"Wednesday ","Holiday","This is Holiday"));

        //June

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-01" ,"Saturday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-02" ,"Sunday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-03" ,"Monday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-04" ,"Tuesday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-05" ,"Wednesday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-06" ,"Thusday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-07" ,"Friday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-08" ,"Saturday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-09" ,"Sunday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-10" ,"Monday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-13" ,"Thusday ","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-14" ,"Friday ","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-20" ,"Thusday ","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-21" ,"Friday ","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-27" ,"Thusday ","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-06-28" ,"Friday ","Weekly Off Day","This is Holiday"));

        //July

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-07-05" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-07-04" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-07-12" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-07-11" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-07-19" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-07-18" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-07-26" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-07-25" ,"Thusday","Weekly Off Day","This is Holiday"));

        //August

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-02" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-01" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-09" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-08" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-16" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-15" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-23" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-22" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-30" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-29" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-10" ,"Saturday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-11" ,"Sunday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-12" ,"Monday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-13" ,"Tuesday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-08-14" ,"Wednesday ","Holiday","This is Holiday"));


        //September

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-09-06" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-09-05" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-09-13" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-09-12" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-09-20" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-09-19" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-09-27" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-09-26" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-09-10" ,"Tuesday","Weekly Off Day","This is Holiday"));

        //October

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-04" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-03" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-11" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-10" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-18" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-17" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-25" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-24" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-31" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-05" ,"Saturday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-06" ,"Sunday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-07" ,"Monday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-08" ,"Tuesday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-10-09" ,"Wednesday ","Holiday","This is Holiday"));

        //November

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-11-01" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-11-07" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-11-08" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-11-14" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-11-15" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-11-21" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-11-22" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-11-28" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-11-29" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-11-10" ,"Sunday","Holiday","This is Holiday"));


        //December

        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-06" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-05" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-13" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-12" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-20" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-19" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-27" ,"Friday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-26" ,"Thusday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-25" ," Wednesday","Weekly Off Day","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-16" ,"Monday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-28" ,"Saturday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-29" ,"Sunday","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-30" ,"Monday ","Holiday","This is Holiday"));
        HomeCollection.date_collection_arr.add( new HomeCollection("2019-12-31" ,"Tuesday ","Holiday","This is Holiday"));

*/

        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        cal_month_copy = (GregorianCalendar) cal_month.clone();
        hwAdapter = new HwAdapter(this, cal_month, date_collection_arr);

        tv_month = (TextView) findViewById(R.id.tv_month);
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));


        ImageButton previous = (ImageButton) findViewById(R.id.ib_prev);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cal_month.get(GregorianCalendar.MONTH) == 4&&cal_month.get(GregorianCalendar.YEAR)==2018) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
                    Toast.makeText(CalenderPageFour.this, "Event Detail is available for current session only.", Toast.LENGTH_SHORT).show();
                }
                else {
                    setPreviousMonth();
                    refreshCalendar();
                }


            }
        });
        ImageButton next = (ImageButton) findViewById(R.id.Ib_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cal_month.get(GregorianCalendar.MONTH) == 5&&cal_month.get(GregorianCalendar.YEAR)==2020) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
                    Toast.makeText(CalenderPageFour.this, "Event Detail is available for current session only.", Toast.LENGTH_SHORT).show();
                }
                else {
                    setNextMonth();
                    refreshCalendar();
                }
            }
        });
        GridView gridview = (GridView) findViewById(R.id.gv_calendar);
        gridview.setAdapter(hwAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String selectedGridDate = HwAdapter.day_string.get(position);
                ((HwAdapter) parent.getAdapter()).getPositionList(selectedGridDate, CalenderPageFour.this);
            }

        });
    }
    protected void setNextMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    protected void setPreviousMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMinimum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH, cal_month.get(GregorianCalendar.MONTH) - 1);
        }
    }

    public void refreshCalendar() {
        hwAdapter.refreshDays();
        hwAdapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
    }
}

