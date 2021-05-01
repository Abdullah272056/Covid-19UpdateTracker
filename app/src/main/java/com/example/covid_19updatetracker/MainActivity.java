package com.example.covid_19updatetracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.covid_19updatetracker.modelClass.OurObjectDataClass;
import com.example.covid_19updatetracker.retrofit.ApiInterface;
import com.example.covid_19updatetracker.retrofit.RetrofitClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //List<ResponseData> allDataList;
    List<String> nameList;
    String token;
    ApiInterface apiInterface;

    Call<OurObjectDataClass> call;



    private static final String BASE_URL = "https://coronavirus-19-api.herokuapp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        apiInterface = RetrofitClient.getRetrofit("https://coronavirus-19-api.herokuapp.com/").create(ApiInterface.class);


        apiInterface.getData().enqueue(new Callback<OurObjectDataClass>() {
            @Override
            public void onResponse(Call<OurObjectDataClass> call, Response<OurObjectDataClass> response) {
                Log.e("size","sss");
            }

            @Override
            public void onFailure(Call<OurObjectDataClass> call, Throwable t) {
                Log.e("size",t.getMessage());
            }
        });



    }

}
