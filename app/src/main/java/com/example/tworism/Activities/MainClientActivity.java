package com.example.tworism.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tworism.Adapter.RecentsDataAdapter;
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

public class MainClientActivity extends AppCompatActivity {

    RecyclerView recentRecycler;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    RecentsDataAdapter recentsDataAdapter;
    List<RecentsDataModel> recentsDataModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);

        recentRecycler = findViewById(R.id.recent_recycler);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        recentRecycler.setLayoutManager(layoutManager);
        recentsDataAdapter =new RecentsDataAdapter(recentsDataModelList);
        recentRecycler.setAdapter(recentsDataAdapter);

        fetchRecentData();
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


}