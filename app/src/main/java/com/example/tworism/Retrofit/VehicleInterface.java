package com.example.tworism.Retrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface VehicleInterface {
    @GET("/api/vehicles/{UserID}")
    public abstract Call<List<VehicleModel>> listarVehiculos(@Path("UserID") String UserID);

    @POST("/api/vehicles/")
    Call<VehicleModel> registerVe(@Body Map<String, String> body);

    @PUT("/api/vehicles/{id}")
    Call<List<String>> ModificarV(@Path("id") String id, @Body Map<String, String> body);

    @DELETE("/api/vehicles/{id}")
    Call<Integer> EliminarV(@Path("id") String id);

    @GET("/api/vehicles/ById/{id}")
    Call<VehicleModel> BuscarV(@Path("id") String id);

}

