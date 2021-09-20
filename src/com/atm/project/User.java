package com.atm.project;

public class User {

    private String cardNo;
    private String fullName;
    private int pin;

    public User(String cardNo, String fullName, int pin) {
        this.cardNo = cardNo;
        this.fullName = fullName;
        this.pin = pin;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
