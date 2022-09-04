package com.example.tworism.Retrofit;

public class VehicleModel {
    private int VehicleId;
    private String VehicleTuition;
    private String VehicleCapacity;
    private String VehicleType;
    private String createdAt;
    private String updatedAt;
    private String UserId;

    public VehicleModel(int Id, String VehicleT, String VehicleC, String VehicleTy, String UserId, String createdAt, String udatedAt) {
        VehicleId = Id;
        VehicleTuition = VehicleT;
        VehicleCapacity = VehicleC;
        VehicleType = VehicleTy;
        UserId = UserId;

        this.createdAt = createdAt;
        this.updatedAt = udatedAt;
    }

    public VehicleModel(String userId) {
        UserId = userId;
    }

    public VehicleModel() {
    }

    public int getVVehicleID() {
        return VehicleId;
    }

    public void setVehicleID(int VehicleID) {
        this.VehicleId = VehicleID;
    }

    public String getVehicleTuition() {
        return VehicleTuition;
    }

    public void setVehicleTuition(String vehicleTuition) {
        VehicleTuition = vehicleTuition;
    }

    public String getVehicleCapacity() {
        return VehicleCapacity;
    }

    public void setVehicleCapacity(String vehicleCapacity) {
        VehicleCapacity = vehicleCapacity;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
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

    public int getVehicleId() {
        return VehicleId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
