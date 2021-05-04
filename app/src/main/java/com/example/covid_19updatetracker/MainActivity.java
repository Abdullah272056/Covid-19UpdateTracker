package com.example.covid_19updatetracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.covid_19updatetracker.modelClass.CustomAdapter;
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

public class MainActivity extends AppCompatActivity implements CustomAdapter.OnContactClickListener{
    List<OurObjectDataClass> allDataList;
    List<String> nameList;
    ApiInterface apiInterface;



    RecyclerView recyclerView;
    CustomAdapter customAdapter;



    CustomAdapter.OnContactClickListener onContactClickListener;
    private static final String BASE_URL = "https://coronavirus-19-api.herokuapp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerViewId);
        onContactClickListener=this;
        apiInterface = RetrofitClient.getRetrofit("https://coronavirus-19-api.herokuapp.com/").create(ApiInterface.class);

            apiInterface.getAllData().enqueue(new Callback<List<OurObjectDataClass>>() {
                @Override
                public void onResponse(Call<List<OurObjectDataClass>> call, Response<List<OurObjectDataClass>> response) {
                    if (response.code()==200){
                        allDataList=new ArrayList<>();
                        nameList=new ArrayList<>();
                        Log.e("response","success");
                        allDataList.addAll(response.body());
                        customAdapter = new CustomAdapter(MainActivity.this,allDataList,onContactClickListener);
                        recyclerView.setAdapter(customAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


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


    }

    @Override
    public void onContactClick(int position) {
        Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
        startActivity(intent);
    }
}
