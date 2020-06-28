package com.example.haki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Incidences extends AppCompatActivity {
    @BindView(R.id.listView) ListView mListView;

    String [] inicidences = new String[]{"Police beat people in Likoni ferry during curfew, June 2020", "Killing od an innocent man in Kawangware, 2011",
            "police opened teargas on Issac Ruto's face,", "Several people injured during 2007 post election violence."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidences);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, inicidences);
        mListView.setAdapter(arrayAdapter);
    }
}