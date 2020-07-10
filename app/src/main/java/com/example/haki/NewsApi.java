package com.example.haki;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface NewsApi {
    @GET("/v2/everything")
    Call<NewsSearchResponse> getNews(
        @Query("apiKey") String apiKey,
        @Query("q") String q
    );
}
