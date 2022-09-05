package com.example.tworism.Retrofit;

public class RecentsDataModel {
    private int TravelId;
    private String TravelDate;
    private String TravelOrigin;
    private String TravelDestination;
    private String TravelPrice;

    public RecentsDataModel(int travelId, String travelDate, String travelOrigin, String travelDestination, String travelPrice) {
        this.TravelId = travelId;
        this.TravelDate = travelDate;
        this.TravelOrigin = travelOrigin;
        this.TravelDestination = travelDestination;
        this.TravelPrice = travelPrice;
    }

    public int getTravelId() {
        return TravelId;
    }

    public void setTravelId(int travelId) {
        TravelId = travelId;
    }

    public String getTravelDate() {
        return TravelDate;
    }

    public void setTravelDate(String travelDate) {
        TravelDate = travelDate;
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

    public String getTravelPrice() {
        return TravelPrice;
    }

    public void setTravelPrice(String travelPrice) {
        TravelPrice = travelPrice;
    }
}
