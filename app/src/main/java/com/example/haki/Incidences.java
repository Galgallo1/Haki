package com.example.haki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.haki.Constants.NEWS_API_KEY;

public class Incidences extends AppCompatActivity {
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private IncidencesListAdapter mAdapter;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    public List<Article> articles;

    public static final String TAG = Incidences.class.getSimpleName();

   /* String [] inicidences = new String[]{"Police beat people in Likoni ferry during curfew, June 2020", "Killing od an innocent man in Kawangware, 2011",
            "police opened teargas on Issac Ruto's face,", "Several people injured during 2007 post election violence.", "Kwewe Mwandanza was killed by police in her mombasa home for no reason, 2014",
                "At least 5 people killed and 60 injured by gunfire when police tried to stop peaceful protest in Nyanza Region, 2016",
            "In 2010, police mistreated refugees fleeing wartorn Somalia through demanding bribes, unlawful threats and in extreme cases rape.",
                "Carilton Maina, the unarmed UK based University student died at the hands of police In Kibera, Nairobi, on December 22, 2018",
            "George Floyd by Minneapolis police sparked nationwide unrest in Us, 2020", ""};*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidences);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        /*ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, inicidences);
        mListView.setAdapter(arrayAdapter);*/

        NewsApi client = NewsClient.getNews();

        Call<NewsSearchResponse> call = client.getNews( NEWS_API_KEY, "police brutality");
        call.enqueue(new Callback<NewsSearchResponse>() {


            @Override
            public void onResponse(Call<NewsSearchResponse> call, Response<NewsSearchResponse> response) {
                hideProgressBar();
                if(response.isSuccessful()){
                    articles = response.body().getArticles();
                    mAdapter =new  IncidencesListAdapter(articles, Incidences.this);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Incidences.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    showRestaurants();
                }else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<NewsSearchResponse> call, Throwable t) {

                //Log.e(TAG, "onFailure: ",t );
                hideProgressBar();
                showFailureMessage();
            }
        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
        //mLocationTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}