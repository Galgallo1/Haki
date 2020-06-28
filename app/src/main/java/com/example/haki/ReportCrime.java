package com.example.haki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportCrime extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.textView) TextView mTextview;
    @BindView(R.id.submitButton) Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_crime);
        ButterKnife.bind(this);

        mButton.setOnClickListener(this);
        //Intent intent = getIntent();
        //String hello = intent.getStringExtra("hello");
        //mTextview.setText(hello);
    }

    @Override
    public void onClick(View view) {
        if(view==mButton)
            Intent intent = new Intent(ReportCrime.this, IncidenceReceived.class);
            startActivity(intent);
        }
    }
}