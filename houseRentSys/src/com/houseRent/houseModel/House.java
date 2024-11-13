package com.houseRent.houseModel;

public class House {
    //编号，房主，电话，地址，租金，状态（已出租或未出租）
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private int rent;
    private String state;//状态

    public House(String name, String phoneNumber, String address, int rent, String state) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return id +
                "\t\t\t" + name +
                "\t\t\t\t" + phoneNumber +
                "\t\t\t\t" + address +
                "\t\t\t\t" + rent +
                "\t\t\t" + state;
    }
}
