package com.example.covid_19updatetracker.retrofit;

import com.example.covid_19updatetracker.modelClass.OurObjectDataClass;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("countries/afghanistan")
    Call<OurObjectDataClass> getData();

    @GET("countries")
    Call<List<OurObjectDataClass>> getAllData();
}
