package com.developergmail.jjb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Coach_Team extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach__team);
    }

    public void gotoTeamManagement(View view) {
        intent=new Intent(Coach_Team.this,Team_Management.class);xa
    }
}
