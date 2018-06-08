package com.gabar.mvpsample.RetrofitClient;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sanjeev on 7/8/17.
 */


public interface WebServices {

    @GET("/users/hadley/orgs")
    Call<JsonArray> getData();
}
