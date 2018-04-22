package ru.boltachev.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public  class Controller {

    static final String BASE_URL = "http://www.mocky.io/";

    public static HtcApi getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        HtcApi htcApi = retrofit.create(HtcApi.class);
        return htcApi;
    }

}
