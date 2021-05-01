package com.example.covid_19updatetracker.retrofit;

import com.example.covid_19updatetracker.modelClass.ModelClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/countries")
    Call<ModelClass> getData();

}
