package com.houseRent.houseService;

import com.houseRent.houseModel.House;

public class HouseService {
    // 1.响应HouseView的调用
    //2.完成对房屋信息的各种操作

    private House[] houses;
    private int houseNumbers = 0;
    private int idCounter = 1;
    private int searchIndex;//查找方法中使用到
    private int deleteIndex;//删除方法中使用到
    private int updateIndex;//修改方法中使用到

    public House[] getHouses() {
        return houses;
    }

    public int getSearchIndex() {
        return searchIndex;
    }

    public int getUpdateIndex() {
        return updateIndex;
    }

    public HouseService(int size) {
        houses = new House[size];
    }

    public House[] list() {
        return houses;
    }

    public boolean add(House newHouse) {
        if (houseNumbers >= houses.length) {//如果houses达到容量上限则执行此进行扩容
            House[] newHouses = new House[houses.length + 1];
            for (int i = 0; i < houses.length; i++) {//数组扩容
                newHouses[i] = houses[i];//将旧数组的元素赋值给newHouses
            }
            newHouses[newHouses.length - 1] = newHouse;//添加新house对象
            this.houses = newHouses;
            houseNumbers++;
            newHouse.setId(idCounter);//自动赋予编号
            idCounter++;
            return true;
        } else {
            houses[houseNumbers] = newHouse;
            houseNumbers++;
            newHouse.setId(idCounter);
            idCounter++;
            return true;
        }
    }

    public boolean search(int searchId) {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getId() == searchId) {
                searchIndex = i;
                return true;
            }
        }
        return false;
    }

    public boolean delete(int deleteId) {
        boolean searched = false;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getId() == deleteId) {
                deleteIndex = i;
                searched = true;
                break;
            }
        }
        if (searched) {
            for (int i = deleteIndex; i < houses.length - 1; i++) {
                houses[i] = houses[i + 1];
            }
            House[] newHouses = new House[houses.length - 1];//数组缩小
            for (int i = 0; i < houses.length - 1; i++) {
                newHouses[i] = houses[i];
            }
            houses = newHouses;
            houseNumbers--;
            return true;
        } else {
            return false;
        }
    }

    public boolean update(int updateId, String updateName, String updatePhoneNumber, String updateAddress, int updateRent, String updateState) {
        if (search(updateId)) {
            houses[searchIndex].setName(updateName);
            houses[searchIndex].setPhoneNumber(updatePhoneNumber);
            houses[searchIndex].setAddress(updateAddress);
            houses[searchIndex].setRent(updateRent);
            houses[searchIndex].setState(updateState);
            return true;
        } else
            return false;
    }
}
