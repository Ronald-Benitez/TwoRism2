package com.example.tworism.Retrofit;

public class UserModel {
    private String UserId;
    private String UserName;
    private String UserEmail;
    private String UserPassword;
    private String UserType;
    private Boolean UserVerified;
    private String UserCalification;
    private String UserCalifications;
    private String createdAt;
    private String updatedAt;

    public UserModel(String userId, String userName, String userEmail, String userPassword, String userType, Boolean userVerified,String UserCalification, String UserCalifications, String createdAt, String udatedAt) {
        this.UserId = userId;
        this.UserName = userName;
        this.UserEmail = userEmail;
        this.UserPassword = userPassword;
        this.UserType = userType;
        this.UserVerified = userVerified;
        this.UserCalification = UserCalification;
        this.UserCalifications = UserCalifications;
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

    public String getUserCalification() {
        return UserCalification;
    }

    public void setUserCalification(String userCalification) {
        UserCalification = userCalification;
    }

    public String getUserCalifications() {
        return UserCalifications;
    }

    public void setUserCalifications(String userCalifications) {
        UserCalifications = userCalifications;
    }
}
