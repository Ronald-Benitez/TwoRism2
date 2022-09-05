package com.example.tworism.Models;

public class TravelModel {
    private String TravelId;
    private String UserId;
    private String VehicleId;
    private String TravelDate;
    private String TravelTime;
    private String TravelPrice;
    private String TravelCapacity;
    private String TravelRegistered;
    private String TravelOrigin;
    private String TravelDestination;
    private String TravelLatitudes;
    private String TravelLongitudes;
    private String TravelTags;
    private String TravelIncludes;
    private String TravelExcludes;
    private String createdAt;
    private String updatedAt;

    public TravelModel() {

    }

    public TravelModel(String travelId, String userId, String vehicleId, String travelDate, String travelTime, String travelPrice, String travelCapacity, String travelRegistered, String travelOrigin, String travelDestination, String travelLatitudes, String travelLongitudes, String travelTags, String travelIncludes, String travelExcludes, String createdAt, String updatedAt) {
        this.TravelId = travelId;
        this.UserId = userId;
        this.VehicleId = vehicleId;
        this.TravelDate = travelDate;
        this.TravelTime = travelTime;
        this.TravelPrice = travelPrice;
        this.TravelCapacity = travelCapacity;
        this.TravelRegistered = travelRegistered;
        this.TravelOrigin = travelOrigin;
        this.TravelDestination = travelDestination;
        this.TravelLatitudes = travelLatitudes;
        this.TravelLongitudes = travelLongitudes;
        this.TravelTags = travelTags;
        this.TravelIncludes = travelIncludes;
        this.TravelExcludes = travelExcludes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getTravelId() {
        return TravelId;
    }

    public void setTravelId(String travelId) {
        TravelId = travelId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(String vehicleId) {
        VehicleId = vehicleId;
    }

    public String getTravelDate() {
        return TravelDate;
    }

    public void setTravelDate(String travelDate) {
        TravelDate = travelDate;
    }

    public String getTravelTime() {
        return TravelTime;
    }

    public void setTravelTime(String travelTime) {
        TravelTime = travelTime;
    }

    public String getTravelPrice() {
        return TravelPrice;
    }

    public void setTravelPrice(String travelPrice) {
        TravelPrice = travelPrice;
    }

    public String getTravelCapacity() {
        return TravelCapacity;
    }

    public void setTravelCapacity(String travelCapacity) {
        TravelCapacity = travelCapacity;
    }

    public String getTravelRegistered() {
        return TravelRegistered;
    }

    public void setTravelRegistered(String travelRegistered) {
        TravelRegistered = travelRegistered;
    }

    public String getTravelOrigin() {
        return TravelOrigin;
    }

    public void setTravelOrigin(String travelOrigin) {
        TravelOrigin = travelOrigin;
    }

    public String getTravelDestination() {
        return TravelDestination;
    }

    public void setTravelDestination(String travelDestination) {
        TravelDestination = travelDestination;
    }

    public String getTravelLatitudes() {
        return TravelLatitudes;
    }

    public void setTravelLatitudes(String travelLatitudes) {
        TravelLatitudes = travelLatitudes;
    }

    public String getTravelLongitudes() {
        return TravelLongitudes;
    }

    public void setTravelLongitudes(String travelLongitudes) {
        TravelLongitudes = travelLongitudes;
    }

    public String getTravelTags() {
        return TravelTags;
    }

    public void setTravelTags(String travelTags) {
        TravelTags = travelTags;
    }

    public String getTravelIncludes() {
        return TravelIncludes;
    }

    public void setTravelIncludes(String travelIncludes) {
        TravelIncludes = travelIncludes;
    }

    public String getTravelExcludes() {
        return TravelExcludes;
    }

    public void setTravelExcludes(String travelExcludes) {
        TravelExcludes = travelExcludes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
