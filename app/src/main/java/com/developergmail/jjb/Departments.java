package com.developergmail.jjb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Departments extends AppCompatActivity {
    Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);
    }

    public void gotoReferees(View view) {
        myintent=new Intent(Departments.this,Referees_List.class);

    }

    public void gotoCoaches(View view) {
        myintent=new Intent(Departments.this,Coaches_list.class);
    }

    public void gotoStaff(View view) {
        myintent=new Intent(Departments.this,Alumni_List.class);
    }

    public void gotoFitnessCenter(View view) {
        myintent=new Intent(Departments.this,FitnessCenter_list.class);
    }
}
