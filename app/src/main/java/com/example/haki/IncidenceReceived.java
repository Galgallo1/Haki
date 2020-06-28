package com.example.haki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class IncidenceReceived extends AppCompatActivity {
    @BindView(R.id.textView7) TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidence_received);

        Intent intent = getIntent();
    }
}