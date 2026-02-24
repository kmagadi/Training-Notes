package com.parking.dto;

public class Car {

    private String regNum;
    private String brand;
    private String carName;

    public Car() {}

    public Car(String regNum, String brand, String carName) {
        this.regNum = regNum;
        this.brand = brand;
        this.carName = carName;
    }

    public String getRegNum() { return regNum; }
    public void setRegNum(String regNum) { this.regNum = regNum; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getCarName() { return carName; }
    public void setCarName(String carName) { this.carName = carName; }
}