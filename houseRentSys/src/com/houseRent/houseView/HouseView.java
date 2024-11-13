package com.houseRent.houseView;

import com.houseRent.houseModel.House;
import com.houseRent.houseService.HouseService;

import java.util.Scanner;

public class HouseView {
    //1.显示界面
    //2.接受用户的输入
    //3.调用其它类完成对房屋信息的各种操作
    private boolean loop = true;//控制主菜单进出
    private String key;//接受用户的选择
    Scanner input = new Scanner(System.in);
    HouseService houseService = new HouseService(1);
    String choice = "";

    //显示房屋列表界面
    public void listHouse() {
        System.out.println("===================房屋出租列表===================");
        System.out.println("编号\t\t\t房主\t\t\t\t电话\t\t\t\t地址\t\t\t\t租金\t\t\t状态（已出租或未出租）");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("===================房屋列表显示完毕===================");
    }

    //显示添加房屋界面
    public void addHouse() {
        System.out.println("请输入添加的新房屋信息");
        System.out.print("姓名：");
        String name = input.next();
        System.out.print("电话：");
        String phoneNumber = input.next();
        System.out.print("地址：");
        String address = input.next();
        System.out.print("租金：");
        int rent = input.nextInt();
        System.out.print("状态：");
        String state = input.next();
        House house = new House(name, phoneNumber, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("===================添加房屋信息成功===================");
        } else {
            System.out.println("===================添加失败===================");
        }
    }

    //显示查找房屋界面
    public void searchHouse() {
        System.out.print("请输入您要查找的房屋的编号：");
        int searchKey = input.nextInt();
        if (houseService.search(searchKey)) {
            System.out.println("查找成功,以下是您查找的房屋信息");
            System.out.println("编号\t\t\t房主\t\t\t\t电话\t\t\t\t地址\t\t\t\t租金\t\t\t状态（已出租或未出租）");
            System.out.println(houseService.getHouses()[houseService.getSearchIndex()]);//显示查找的房屋信息
        } else {
            System.out.println("查找失败TwT，您查找的房屋编号不在系统中");
        }
    }

    //显示删除房屋界面
    public void deleteHouse() {
        System.out.print("请输入您要删除的房屋的编号：");
        int deleteId = input.nextInt();
        System.out.println("您真的要删除此房屋么，请谨慎选择（y/n）");
        String choice = input.next();
        while (true) {
            if (choice.equals("y")) {
                break;
            } else if (choice.equals("n")) {
                return;
            } else {
                System.out.print("您必须选择y（yes）或者n（no），请重新选择");
                choice = input.next();
            }
        }
        if (houseService.delete(deleteId)) {
            System.out.println("===================删除成功===================");
        } else {
            System.out.println("删除失败TwT，您删除的房屋编号不在系统中");
        }
    }

    //显示修改房屋信息界面
    public void updateHouse() {
        System.out.print("请输入您要修改信息的房屋的编号：");
        int updateId = input.nextInt();
        if (!houseService.search(updateId)) {
            System.out.println("修改失败TwT，您修改的房屋编号不在系统中");
            return;//如果没有搜索到房屋，直接跳出
        }
        System.out.println("请输入您要修改的信息");
        System.out.print("房主：（" + houseService.getHouses()[houseService.getSearchIndex()].getName() + "):");
        String updateName = input.next();
        System.out.print("电话：（" + houseService.getHouses()[houseService.getSearchIndex()].getPhoneNumber() + "):");
        String updatePhoneNumber = input.next();
        System.out.print("地址：（" + houseService.getHouses()[houseService.getSearchIndex()].getAddress() + "):");
        String updateAddress = input.next();
        System.out.print("租金：（" + houseService.getHouses()[houseService.getSearchIndex()].getRent() + "):");
        int updateRent = input.nextInt();
        System.out.print("状态：（" + houseService.getHouses()[houseService.getSearchIndex()].getState() + "):");
        String updateState = input.next();
        if (houseService.update(updateId, updateName, updatePhoneNumber, updateAddress, updateRent, updateState)) {
            System.out.println("修改房屋信息成功，以下是您修改后的信息");
            System.out.println("编号\t\t\t房主\t\t\t\t电话\t\t\t\t地址\t\t\t\t租金\t\t\t状态（已出租或未出租）");
            System.out.println(houseService.getHouses()[houseService.getUpdateIndex()]);
        }
    }

    //显示退出界面
    public void exit() {
        while (true) {
            System.out.println("你真的要退出么？ y/n");
            choice = input.next();
            if (choice.equals("y") || choice.equals("n")) {
                break;
            }
        }
        if (choice.equals("y")) {
            loop = false;
        }
    }

    public void showMean() {
        do {
            System.out.println("\n==================房屋出租系统==================");
            System.out.println("\t\t\t\t1.新增房源");
            System.out.println("\t\t\t\t2.查找房屋");
            System.out.println("\t\t\t\t3.删除房屋");
            System.out.println("\t\t\t\t4.修改房屋信息");
            System.out.println("\t\t\t\t5.房屋列表");
            System.out.println("\t\t\t\t6.退   出");
            System.out.print("请选择（1-6）：");
            key = input.next();
            switch (key) {
                case "1":
                    addHouse();
                    break;
                case "2":
                    searchHouse();
                    break;
                case "3":
                    deleteHouse();
                    break;
                case "4":
                    updateHouse();
                    break;
                case "5":
                    listHouse();
                    break;
                case "6":
                    exit();
                    break;
                default:
                    System.out.println("您应该输入（1-6）来进行选择");
                    break;
            }

        } while (loop);
    }
}
