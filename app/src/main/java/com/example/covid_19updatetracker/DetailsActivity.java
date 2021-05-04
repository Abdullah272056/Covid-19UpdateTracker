package com.example.covid_19updatetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.covid_19updatetracker.modelClass.OurObjectDataClass;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    TextView countryName,totalCase,todayCase,totalDeaths,todayDeaths,
            recover,active,critical,casePerMillion,deathsPerMillion,
            totalTest,testPerMillion;
    List<OurObjectDataClass> selectedData;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
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


        Intent intent=getIntent();

        countryName.setText(String.valueOf (intent.getStringExtra("country")));
        todayCase.setText(todayCase.getText ().toString ()+"\n"+intent.getStringExtra("todayCases"));
        totalCase.setText(totalCase.getText ().toString ()+"\n"+intent.getStringExtra("cases"));
        totalDeaths.setText(totalDeaths.getText ().toString ()+"\n"+intent.getStringExtra("deaths"));
        todayDeaths.setText(todayDeaths.getText ().toString ()+"\n"+intent.getStringExtra("todayDeaths"));
        recover.setText(recover.getText ().toString ()+"\n"+intent.getStringExtra("recovered"));
        active.setText(active.getText ().toString ()+"\n"+intent.getStringExtra("active"));
        critical.setText(critical.getText ().toString ()+"\n"+intent.getStringExtra("critical"));
        casePerMillion.setText(casePerMillion.getText ().toString ()+"\n"+intent.getStringExtra("casesPerOneMillion"));
        deathsPerMillion.setText(deathsPerMillion.getText ().toString ()+"\n"+intent.getStringExtra("deathsPerOneMillion"));
        totalTest.setText(totalTest.getText ().toString ()+"\n"+intent.getStringExtra("totalTests"));
        testPerMillion.setText(testPerMillion.getText ().toString ()+"\n"+intent.getStringExtra("testsPerOneMillion"));


    }
}