package com.omerkagandanaci.projecttrial.View.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.omerkagandanaci.projecttrial.R;

public class AddTrain extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;
    public void init(){

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Train");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_train);
        init();
    }
}