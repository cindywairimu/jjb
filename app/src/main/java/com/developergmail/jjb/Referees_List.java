package com.developergmail.jjb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import java.io.OptionalDataException;
import java.sql.Ref;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class Referees_List extends AppCompatActivity {
    final String[]Firstname={"Chester","Chris","Banda","Eli","Clinton","Mike","Zoe"};
    final String[]Lastname={"Lee","Wayne","Bunda","Moses","Gates","Eze","Yay"};
   final Integer[]image={R.drawable.ic_launcher_foreground, R.drawable.logo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referees__list);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Ref>Reflist=prepareDate();
        RefAdapter adapter= new RefAdapter(Reflist,this);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
}

    private ArrayList<Ref> prepareDate() {
        ArrayList<Ref> Reflist=new ArrayList<>();

        for (int i = 0; i<Firstname.length; i++){
            Ref ref = new Ref() {


                @Override
                public String getBaseTypeName() throws SQLException {
                    return null;
                }

                @Override
                public Object getObject(Map<String, Class<?>> map) throws SQLException {
                    return null;
                }

                @Override
                public Object getObject() throws SQLException {
                    return null;
                }

                @Override
                public void setObject(Object o) throws SQLException {

                }
            };
            ref.setFirstname(Firstname[i]);
            ref.setLastname(Lastname[i]);
            }
            return Reflist;
        }
    }

