package com.example.haki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.reportButton) Button mReportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this)

        mReportButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == mReportButton){
            String Hello = "Hello";
            Intent intent = new Intent(MainActivity.this, ReportCrime.class);
            intent.putExtra("hello", Hello);
            startActivity(intent);
        }
    }
}