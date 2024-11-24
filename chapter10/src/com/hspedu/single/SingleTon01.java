package com.hspedu.single;

//单例模式-饿汉式
public class SingleTon01 {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getGirlFriend();
        System.out.println(instance);
    }
}

class GirlFriend {
    private String name;

    //1.将构造器私有化
    private GirlFriend(String name) {
        this.name = name;
    }

    //2.在类的内部直接创建
    private static GirlFriend gf = new GirlFriend("xh");

    //3.提供一个公共的static方法去返回gf对象
    public static GirlFriend getGirlFriend() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}