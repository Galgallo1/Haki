package com.example.haki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IncidenceReceived extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.textView7) TextView mTextView;
    @BindView(R.id.exploreButton) Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidence_received);
        ButterKnife.bind(this);

        mButton.setOnClickListener(this);
        Intent intent = getIntent();
    }

    @Override
    public void onClick(View view) {
        if(view == mButton){
            Intent intent = new Intent(MainActivity.this, )
        }
    }
}