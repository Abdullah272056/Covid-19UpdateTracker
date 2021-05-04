package com.example.covid_19updatetracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.covid_19updatetracker.modelClass.OurObjectDataClass;
import com.example.covid_19updatetracker.retrofit.ApiInterface;
import com.example.covid_19updatetracker.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<OurObjectDataClass> allDataList;
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

            apiInterface.getAllData().enqueue(new Callback<List<OurObjectDataClass>>() {
                @Override
                public void onResponse(Call<List<OurObjectDataClass>> call, Response<List<OurObjectDataClass>> response) {
                    if (response.code()==200){
                        allDataList=new ArrayList<>();
                        Log.e("response","success");
                        allDataList.addAll(response.body());

                        Log.e("size",String.valueOf( allDataList.size()));
                    }else {
                        Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onFailure(Call<List<OurObjectDataClass>> call, Throwable t) {
                    Log.e("response","failed");

                }
            });


//        apiInterface.getData().enqueue(new Callback<OurObjectDataClass>() {
//            @Override
//            public void onResponse(Call<OurObjectDataClass> call, Response<OurObjectDataClass> response) {
//                Log.e("size","sss");
//                Log.e("size",String.valueOf(response.body().getCountry()));
//
//            }
//
//            @Override
//            public void onFailure(Call<OurObjectDataClass> call, Throwable t) {
//                Log.e("size",t.getMessage());
//            }
//        });



    }

}
