package com.example.tworism.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tworism.Adapter.RecentsDataAdapter;
import android.widget.ImageView;


import com.example.tworism.MainActivity;
import com.example.tworism.Models.RecentsModel;
import com.example.tworism.R;
import com.example.tworism.Retrofit.RecentsDataModel;
import com.example.tworism.Retrofit.RecentsInterface;
import com.example.tworism.Retrofit.VehicleInterface;
import com.example.tworism.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.example.tworism.R;
import com.example.tworism.Users.ProfileActivity;


public class MainClientActivity extends AppCompatActivity {

    RecyclerView recentRecycler;

    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    RecentsDataAdapter recentsDataAdapter;
    List<RecentsDataModel> recentsDataModelList = new ArrayList<>();

    RecentsDataAdapter recentsAdapter;
    ImageView profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);
        String UserId = getIntent().getStringExtra("UserId");
        String UserName = getIntent().getStringExtra("UserName");

        profile = findViewById(R.id.profile);

        recentRecycler = findViewById(R.id.recent_recycler);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        recentRecycler.setLayoutManager(layoutManager);
        recentsDataAdapter =new RecentsDataAdapter(recentsDataModelList);
        recentRecycler.setAdapter(recentsDataAdapter);


        fetchRecentData();

        setRecentDateRecycler();

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainClientActivity.this, ProfileActivity.class);
                intent.putExtra("UserId", UserId);
                intent.putExtra("UserName", UserName);
                intent.putExtra("Procedure", "Cliente");
                startActivity(intent);
            }
        });

    }

    private  void setRecentDateRecycler(){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentRecycler.setLayoutManager(layoutManager);

    }

    public void fetchRecentData(){
        RecentsInterface api = RetrofitClient.getClient().create(RecentsInterface.class);
        api.getRecentsDataModel().enqueue(new Callback<List<RecentsDataModel>>() {
            @Override
            public void onResponse(Call<List<RecentsDataModel>> call, Response<List<RecentsDataModel>> response) {
                if (response.isSuccessful() && response.body()!=null){
                    recentsDataModelList.addAll(response.body());
                    recentsDataAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<RecentsDataModel>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainClientActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onBackPressed(){
        Intent intent = new Intent(MainClientActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}