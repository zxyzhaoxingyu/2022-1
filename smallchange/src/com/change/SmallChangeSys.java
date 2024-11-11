package com.change;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    //先完成显示菜单，并可以选择菜单，给出对应提示
    public static void main(String[] args) {
        boolean loop = true;
        String key = "";
        Scanner input = new Scanner(System.in);

        String detail = "--------------零钱通明细-------------";

        double money = 0;//交易额
        double balance = 0;//余额
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String note = "";//消费说明

        do {
            System.out.println("\n--------------零钱通菜单-------------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");
            System.out.print("请输入（1-4）：");
            key = input.next();

            //使用switch分支控制
            switch (key) {
                case "1":
                    System.out.println(detail);
                    break;
                case "2":
                    System.out.print("收益入账金额：");
                    money = input.nextDouble();
                    if (money <= 0) {
                        System.out.println("收益入账金额应该大于0");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.print("消费金额：");
                    money = input.nextDouble();
                    //money的值应该校验
                    if (money <= 0 || money > balance) {
                        System.out.println("消费金额应该在0-" + balance);
                        break;
                    }
                    System.out.print("消费说明：");
                    note = input.next();
                    balance -= money;
                    date = new Date();
                    detail += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
                    String choice = "";
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
                    break;
                default:
                    System.out.println("选择有误，请重新输入。");
            }
        } while (loop);
        System.out.println("------------您已退出零钱通-------------");

    }
}
