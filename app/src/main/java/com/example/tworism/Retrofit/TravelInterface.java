package com.example.tworism.Retrofit;

import com.example.tworism.Models.TravelModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TravelInterface {

    @FormUrlEncoded
    @POST("/api/travels/")
    Call<TravelModel> createTravel(@Field("UserId") String UserId,
                                   @Field("VehicleId") String VehicleId,
                                   @Field("TravelDate") String TravelDate,
                                   @Field("TravelTime") String TravelTime,
                                   @Field("TravelPrice") String TravelPrice,
                                   @Field("TravelCapacity") String TravelCapacity,
                                   @Field("TravelRegistered") String TravelRegistered,
                                   @Field("TravelOrigin") String TravelOrigin,
                                   @Field("TravelDestination") String TravelDestination,
                                   @Field("TravelLatitudes") String TravelLatitudes,
                                   @Field("TravelLongitudes") String TravelLongitudes,
                                   @Field("TravelTags") String TravelTags,
                                   @Field("TravelIncludes") String TravelIncludes,
                                   @Field("travelExcludes") String travelExcludes);

}
