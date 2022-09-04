package com.example.tworism.Retrofit;

public class UserModel {
    private String UserId;
    private String UserName;
    private String UserEmail;
    private String UserPassword;
    private String UserType;
    private Boolean UserVerified;
    private String createdAt;
    private String updatedAt;

    public UserModel(String userId, String userName, String userEmail, String userPassword, String userType, Boolean userVerified, String createdAt, String udatedAt) {
        UserId = userId;
        UserName = userName;
        UserEmail = userEmail;
        UserPassword = userPassword;
        UserType = userType;
        UserVerified = userVerified;
        this.createdAt = createdAt;
        this.updatedAt = udatedAt;
    }

    public UserModel() {
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public Boolean getUserVerified() {
        return UserVerified;
    }

    public void setUserVerified(Boolean userVerified) {
        UserVerified = userVerified;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUdatedAt() {
        return updatedAt;
    }

    public void setUdatedAt(String udatedAt) {
        this.updatedAt = udatedAt;
    }
}
