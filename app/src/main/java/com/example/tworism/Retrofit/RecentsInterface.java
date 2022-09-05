package com.example.tworism.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RecentsInterface {
@GET("/api/travels/simplify")
    Call<List<RecentsDataModel>> getRecentsDataModel();
}
