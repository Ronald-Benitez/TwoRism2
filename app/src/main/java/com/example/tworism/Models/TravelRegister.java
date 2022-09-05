package com.example.tworism.Models;

public class TravelRegister {
    private String TravelRegisterId;
    private String TravelId;
    private String UserId;
    private String updaredAt;
    private String createdAt;

    public TravelRegister(String travelRegisterId, String travelId, String userId, String updaredAt, String createdAt) {
        setTravelRegisterId(travelRegisterId);
        setTravelId(travelId);
        setUserId(userId);
        this.setUpdaredAt(updaredAt);
        this.setCreatedAt(createdAt);
    }

    public TravelRegister() {
    }

    public String getTravelRegisterId() {
        return TravelRegisterId;
    }

    public void setTravelRegisterId(String travelRegisterId) {
        TravelRegisterId = travelRegisterId;
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

    public String getUpdaredAt() {
        return updaredAt;
    }

    public void setUpdaredAt(String updaredAt) {
        this.updaredAt = updaredAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
