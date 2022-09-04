package com.example.tworism.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tworism.Adapter.RecentsAdapter;
import com.example.tworism.Models.RecentsModel;
import com.example.tworism.R;

import java.util.ArrayList;
import java.util.List;

public class MainClientActivity extends AppCompatActivity {

    //RecyclerViews
    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);

        //Datos  de prueba para recents recyclerView
        List<RecentsModel> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsModel("El cuco","San Miguel","35"));
        recentsDataList.add(new RecentsModel("Volcan chaparrastique","San Miguel","35"));
        recentsDataList.add(new RecentsModel("Catedral","San Miguel","35"));
        recentsDataList.add(new RecentsModel("Un nombre largo de prueba","San Miguel","35"));
        recentsDataList.add(new RecentsModel("Indica el nombre aqui por favor","San salvador","35"));
        recentsDataList.add(new RecentsModel("El cuco","San Miguel","Desde 35 hasta 85 y todo denevhfv"));
        recentsDataList.add(new RecentsModel("El cuco","San Miguel","35"));


        setRecentRecycler(recentsDataList);
    }

    private void setRecentRecycler(List<RecentsModel> recentsDataList){

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false );
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }
}