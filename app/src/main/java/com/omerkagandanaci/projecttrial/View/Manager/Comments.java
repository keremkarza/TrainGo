package com.omerkagandanaci.projecttrial.View.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.omerkagandanaci.projecttrial.R;

import java.util.Objects;

public class Comments extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;
    public void init(){

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Comments");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        init();
    }
}