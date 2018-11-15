package com.airlook.kwapp.rx5;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Net {

    static RxJava2CallAdapterFactory callAdapterFactory;
    //    GsonConverterFactory
    static GsonConverterFactory converterFactory;
    static HttpLoggingInterceptor httpLoggingInterceptor;
    static NetService netService;
    static OkHttpClient client;

    static {
        callAdapterFactory = RxJava2CallAdapterFactory.create();
        converterFactory = GsonConverterFactory.create();
        httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    public static NetService getNetService() {
        if (netService == null) {
            synchronized (Net.class) {
                if (netService == null) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .addConverterFactory(converterFactory)
                            .addCallAdapterFactory(callAdapterFactory)
                            .client(client)
                            .baseUrl("http://fy.iciba.com/ajax.php/")
                            .build();
                    netService = retrofit.create(NetService.class);
                }
            }
        }
        return netService;
    }
}
