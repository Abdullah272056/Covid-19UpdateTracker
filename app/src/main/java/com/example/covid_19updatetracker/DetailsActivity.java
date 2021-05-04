package com.example.covid_19updatetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView countryName,totalCase,todayCase,totalDeaths,todayDeaths,
            recover,active,critical,casePerMillion,deathsPerMillion,
            totalTest,testPerMillion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        countryName=findViewById (R.id.CountryName);
        totalCase=findViewById (R.id.totalCase);
        todayCase=findViewById (R.id.todayCases);
        todayDeaths=findViewById (R.id.todayDeaths);
        totalDeaths=findViewById (R.id.totalDeaths);
        recover=findViewById (R.id.recover);
        active=findViewById (R.id.active);
        critical=findViewById (R.id.critical);
        casePerMillion=findViewById (R.id.casePerMillion);
        deathsPerMillion=findViewById (R.id.deathsPerMillion);
        totalTest=findViewById (R.id.totalTest);
        testPerMillion=findViewById (R.id.testPerMillion);


        
    }
}