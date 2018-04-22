package ru.boltachev.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HtcApi {

    @GET("/v2/{url}")
    Call<Htc> getCompany(@Path("url") String url);

}
