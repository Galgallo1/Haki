package com.example.haki;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.haki.Constants.NEWS_BASE_URL;

public class NewsClient {
    private static Retrofit retrofit = null;

    public static NewsApi getNews(){
        if(retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    }).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(NEWS_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(NewsApi.class);
    }
}
