package com.example.covid_19updatetracker.modelClass;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19updatetracker.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.ALARM_SERVICE;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{


    Context context;
    private List<OurObjectDataClass> allData;
    CustomAdapter.OnContactClickListener onContactClickListener;

    public CustomAdapter(Context context, List<OurObjectDataClass> allData, OnContactClickListener onContactClickListener) {
        this.context = context;
        this.allData = allData;
        this.onContactClickListener = onContactClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.listview_row_design,parent,false);
        return new MyViewHolder(view,onContactClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

    holder.nameTextView.setText(allData.get(position).getCountry());
    holder.totalDeathTextView.setText(allData.get(position).getDeaths());





    }

    @Override
    public int getItemCount() {
        return allData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nameTextView,totalDeathTextView;
        CustomAdapter.OnContactClickListener onContactClickListener;
        public MyViewHolder(@NonNull View itemView, CustomAdapter.OnContactClickListener onContactClickListener) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.countryNameTextViewId);
            totalDeathTextView=itemView.findViewById(R.id.totalDeathTextViewId);
            this.onContactClickListener=onContactClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onContactClickListener.onContactClick(getAdapterPosition());
        }
    }

    public  interface  OnContactClickListener{
        void onContactClick(int position);
    }



}
