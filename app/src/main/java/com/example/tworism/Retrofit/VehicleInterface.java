package com.example.tworism.Retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface VehicleInterface {
    @POST("/api/vehicles/")
    Call<VehicleModel> registerVe(@Body Map<String, String> body);

    @PUT("/api/vehicles/")
    Call<VehicleModel> ModificarV(@Body Map<String, String> body);
}

