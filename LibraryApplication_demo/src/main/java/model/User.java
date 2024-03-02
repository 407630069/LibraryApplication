package model;

import java.time.LocalDateTime;

public class User {

    private int userId;
    private String phoneNumber;
    private String password;
    private String userName;
    private LocalDateTime registrationTime;
    private LocalDateTime lastLoginTime;

    public User() {
    }

    public User(int userId, String phoneNumber, String password, String userName, LocalDateTime registrationTime, LocalDateTime lastLoginTime) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userName = userName;
        this.registrationTime = registrationTime;
        this.lastLoginTime = lastLoginTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

}
